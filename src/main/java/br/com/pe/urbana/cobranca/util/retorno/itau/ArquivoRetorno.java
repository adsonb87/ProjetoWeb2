package br.com.pe.urbana.cobranca.util.retorno.itau;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;
import org.jrimum.texgit.FlatFile;
import org.jrimum.texgit.Record;
import org.jrimum.texgit.Texgit;
import org.jrimum.utilix.ClassLoaders;

import br.com.pe.urbana.cobranca.exception.ArquivoRetornoException;

public class ArquivoRetorno {

	private final String nomeArquivoLayout = "ItauCNAB400Retorno.txg.xml";
	
	private Cabecalho cabecalho;
	private List<TransacaoTitulo> transacoes;
	private Sumario sumario;
	
	private FlatFile<Record> arquivoTexto;
	
	public ArquivoRetorno(File arquivo) throws ArquivoRetornoException {
		carregarLayout();
		carregarLinhas(arquivo);
		carregarInformacoes();
	}

	private void carregarInformacoes() throws ArquivoRetornoException {
		
		try{			
			this.cabecalho = new Cabecalho(this.arquivoTexto.getRecord("Header"));
			this.sumario = new Sumario(this.arquivoTexto.getRecord("Trailler"));
			
			Collection<Record> registroDeTransacoes = this.arquivoTexto.getRecords("TransacaoTitulo");
			this.transacoes = new ArrayList<>(registroDeTransacoes.size());
			for (Record registro : registroDeTransacoes) {
				transacoes.add(new TransacaoTitulo(registro));
			}
		} catch (Exception e) {
			throw new ArquivoRetornoException("Erro ao carregar arquivo de retorno");
		}		
	}

	private void carregarLinhas(File arquivo) {
		List<String> linhas;
		try {
			linhas = FileUtils.readLines(arquivo);
		} catch (IOException e) {
			throw new RuntimeException("Erro lendo linhas do arquivo de retorno", e);
		}
		this.arquivoTexto.read(linhas);
	}

	private void carregarLayout() {
		InputStream in = ClassLoaders.getResourceAsStream(nomeArquivoLayout, this.getClass());
		this.arquivoTexto = Texgit.createFlatFile(in);
	}
	
	public Cabecalho getCabecalho() {
		return cabecalho;
	}

	public List<TransacaoTitulo> getTransacoes() {
		return transacoes;
	}

	public Sumario getSumario() {
		return sumario;
	}

	public Map<Integer, Collection<TransacaoTitulo>> getTransacoesPorCodigoDeOcorrencia() {
		Map<Integer, Collection<TransacaoTitulo>> transacoesPorOcorrencias = new TreeMap<Integer, Collection<TransacaoTitulo>>();
		
		for (TransacaoTitulo transacao : getTransacoes()) {
			if (!transacoesPorOcorrencias.containsKey(transacao.getCodigoOcorrencia())) {
				ArrayList<TransacaoTitulo> transacoes = new ArrayList<TransacaoTitulo>();
				transacoes.add(transacao);
				transacoesPorOcorrencias.put(transacao.getCodigoOcorrencia(), transacoes);
			} else {
				transacoesPorOcorrencias.get(transacao.getCodigoOcorrencia()).add(transacao);
			}
		}
		
		return transacoesPorOcorrencias;
	}
	
}
