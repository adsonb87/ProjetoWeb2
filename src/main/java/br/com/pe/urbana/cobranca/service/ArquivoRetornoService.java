package br.com.pe.urbana.cobranca.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.jrimum.utilix.text.DateFormat;
import org.jrimum.utilix.text.DecimalFormat;

import br.com.pe.urbana.cobranca.exception.ArquivoRetornoException;
import br.com.pe.urbana.cobranca.model.Cobranca;
import br.com.pe.urbana.cobranca.model.Status;
import br.com.pe.urbana.cobranca.repository.Cobrancas;
import br.com.pe.urbana.cobranca.util.jpa.Transactional;
import br.com.pe.urbana.cobranca.util.retorno.itau.ArquivoRetorno;
import br.com.pe.urbana.cobranca.util.retorno.itau.Cabecalho;
import br.com.pe.urbana.cobranca.util.retorno.itau.Sumario;
import br.com.pe.urbana.cobranca.util.retorno.itau.TransacaoTitulo;

public class ArquivoRetornoService {

	@Inject
	private Cobrancas cobrancas;	
	
	// CRIA UMA LISTA DAS COBRANÇAS PAGAS E CARREGA NA SESSÃO
	private List<Cobranca> cobrancasPagas = null;
	FacesContext contexto = FacesContext.getCurrentInstance();	
	@SuppressWarnings("unchecked")
	public List<Cobranca> getCobrancasPagas() {
		
		cobrancasPagas = (List<Cobranca>) contexto.getExternalContext().getSessionMap().get("listaCobrancasPagas");
		
		return cobrancasPagas;
	}
	
	@Transactional
	public List<String> carregar(String fileName, InputStream inputstream) throws ArquivoRetornoException {
		
		// ANTES DE CARREGAR OUTRO ARQUIVO, REMOVE A LISTA DE COBRANÇAS DA SESSÃO
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("listaCobrancasPagas");
		
		ArquivoRetorno arquivoRetorno = criarArquivoRetorno(fileName, inputstream);
		
		List<String> mensagens = carregarMensagens(arquivoRetorno);
		
		int totalTitulosPagos = carregarTitulos(arquivoRetorno);
		
		mensagens.add("Total de títulos pagos: " + totalTitulosPagos);
		
		// ADICIONA A LISTA DE COBRANÇAS PAGAS NA SESSÃO
		contexto.getExternalContext().getSessionMap().put("listaCobrancasPagas", this.cobrancasPagas);
		
		return mensagens;
	}

	private int carregarTitulos(ArquivoRetorno arquivoRetorno) {
		Map<Integer, Collection<TransacaoTitulo>> titulosPorOcorrencia = arquivoRetorno.getTransacoesPorCodigoDeOcorrencia();
		
		// 06 = LIQUIDAÇÃO NORMAL
		// 02 = ENTRADA CONFIRMADA COM POSSIBILIDADE DE MENSAGEM (NOTA 20 – TABELA 10)
		
		int totalTitulosPagos = 0;
		cobrancasPagas = new ArrayList<>();
		
		// RETORNA APENAS AS TRANSAÇÕES PAGAS (6) = get(TransacaoTitulo.LIQUIDACAO)
		for (TransacaoTitulo t : titulosPorOcorrencia.get(TransacaoTitulo.LIQUIDACAO)) {
			String numero = t.getNossoNumeroConfTituloBanco()+"";
			Long codigoCobranca = Long.parseLong(numero);
			Cobranca cobranca = this.cobrancas.porCodigo(codigoCobranca);
			
			if ((cobranca != null) && (t.getValorTitulo().compareTo(cobranca.getValor()) >= 0) && (cobranca.getStatus() != Status.PAGO)) {
				cobranca.setStatus(Status.PAGO);
				cobranca.setDataPagamento(t.getDataOcorrencia());
				cobranca.setReguser("SISTEMA");
				cobranca.setRegdate(Calendar.getInstance().getTime());
				totalTitulosPagos++;
				cobrancasPagas.add(cobranca);
			}
		}
		return totalTitulosPagos;
	}

	private List<String> carregarMensagens(ArquivoRetorno arquivoRetorno) {
		Cabecalho cabecalho = arquivoRetorno.getCabecalho();
		Sumario sumario = arquivoRetorno.getSumario();
		List<String> mensagens = new ArrayList<>();
		mensagens.add("Data de crédito: " + DateFormat.DDMMYY_B.format(cabecalho.getDataCredito()));
		mensagens.add("Número de títulos em cobrança no banco: " + sumario.getQuantidadeDetalhes());
		mensagens.add("Valor total de títulos: " + DecimalFormat.MONEY_DD_BR.format(sumario.getValorTotalInformado()));
		return mensagens;
	}

	private ArquivoRetorno criarArquivoRetorno(String fileName, InputStream inputstream) throws ArquivoRetornoException {
		
		ArquivoRetorno arquivoRetorno = null;
		
		if(fileName != null && !fileName.equals("")) {
			try {
				File arquivo = File.createTempFile(fileName, "");
				FileUtils.copyInputStreamToFile(inputstream, arquivo);
				arquivoRetorno = new ArquivoRetorno(arquivo);
			} catch (IOException e) {
				throw new ArquivoRetornoException("Erro ao carregar arquivo de retorno");
			}	
		} else {
			throw new ArquivoRetornoException("Erro ao carregar arquivo de retorno");
		}
			
		return arquivoRetorno;
	}

}
