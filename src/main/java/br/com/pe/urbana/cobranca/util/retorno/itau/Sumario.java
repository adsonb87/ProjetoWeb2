package br.com.pe.urbana.cobranca.util.retorno.itau;

import java.math.BigDecimal;

import org.jrimum.texgit.Record;

public class Sumario {

	private Record registro;

	public Sumario(Record registro) {
		if (registro != null) {
			this.registro = registro;
		} else {
			throw new IllegalArgumentException("Registro de sumário não informado.");
		}
	}
	
	public Integer getIDRegsitro() {
		return registro.getValue("IDRegsitro");
	}
	
	public Integer getCodigoRetorno() {
		return registro.getValue("CodigoRetorno");
	}
	
	public Integer getCodigoServico() {
		return registro.getValue("CodigoServico");
	}

	public Integer getCodigoBanco() {
		return registro.getValue("CodigoBanco");
	}
	
	public String getBrancos1() {
		return registro.getValue("Brancos1");
	}
	
	public Integer getQuantidadeTitulosSimples() {
		return registro.getValue("QuantidadeTitulosSimples");
	}
	
	public BigDecimal getValorTotal() {
		return registro.getValue("ValorTotal");
	}
	
	public String getAvisoBancario1() {
		return registro.getValue("AvisoBancario1");
	}
	
	public String getBrancos2() {
		return registro.getValue("Brancos2");
	}
	
	public Integer getQuantidadeTitulosCobranVinc() {
		return registro.getValue("QuantidadeTitulosCobranVinc");
	}
	
	public BigDecimal getValorTotalCobranVinc() {
		return registro.getValue("ValorTotalCobranVinc");
	}
	
	public String getAvisoBancario2() {
		return registro.getValue("AvisoBancario2");
	}
	
	public String getBrancos3() {
		return registro.getValue("Brancos3");
	}
	
	public Integer getQuantidadeTitulosCobranDiretaEscritural() {
		return registro.getValue("QuantidadeTitulosCobranDiretaEscritural");
	}
	
	public String getAvisoBancario3() {
		return registro.getValue("AvisoBancario3");
	}
	
	public Integer getControleDoArquivo() {
		return registro.getValue("ControleDoArquivo");
	}
	
	public Integer getQuantidadeDetalhes() {
		return registro.getValue("QuantidadeDetalhes");
	}
	
	public BigDecimal getValorTotalInformado() {
		return registro.getValue("ValorTotalInformado");
	}
	
	public String getBrancos4() {
		return registro.getValue("Brancos4");
	}
	
	public Integer getNumeroSequencialRegistroArq() {
		return registro.getValue("NumeroSequencialRegistroArq");
	}

}
