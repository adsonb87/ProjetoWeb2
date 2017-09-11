package br.com.pe.urbana.cobranca.util.retorno.itau;

import java.util.Date;

import org.jrimum.texgit.Record;

public class Cabecalho {

	private Record registro;

	public Cabecalho(Record registro) {
		if (registro != null) {
			this.registro = registro;
		} else {
			throw new IllegalArgumentException("Registro de cabeçalho não informado.");
		}
	}
	
	public Integer getIDRegsitroRetorno() {
		return registro.getValue("IDRegsitro");
	}
	
	public Integer getCodigoRetorno() {
		return registro.getValue("CodigoRetorno");
	}

	public String getLiteralRetorno() {
		return registro.getValue("LiteralRetorno");
	}

	public Integer getCodigoDeServico() {
		return registro.getValue("CodigoDeServico");
	}

	public String getLiteralServico() {
		return registro.getValue("LiteralServico");
	}
	
	public Integer getAgencia() {
		return registro.getValue("Agencia");
	}
	
	public Integer getZeros() {
		return registro.getValue("Zeros");
	}
	
	public Integer getConta() {
		return registro.getValue("Conta");
	}
	
	public Integer getDigitoConta() {
		return registro.getValue("DigitoConta");
	}
	
	public String getBrancos1() {
		return registro.getValue("Brancos1");
	}
	
	public String getNomeDaEmpresa() {
		return registro.getValue("NomeDaEmpresa");
	}
	
	public Integer getCodigoBanco() {
		return registro.getValue("CodigoBanco");
	}
	
	public String getNomeBanco() {
		return registro.getValue("NomeBanco");
	}
	
	public Date getDataGeracao() {
		return registro.getValue("DataGeracao");
	}
	
	public Integer getDensidade() {
		return registro.getValue("Densidade");
	}
	
	public String getUnidadeDensid() {
		return registro.getValue("UnidadeDensid");
	}
	
	public Integer getNumeroSequencialArquivoRet() {
		return registro.getValue("NumeroSequencialArquivoRet");
	}
	
	public Date getDataCredito() {
		return registro.getValue("DataCredito");
	}
	
	public String getBrancos2() {
		return registro.getValue("Brancos2");
	}
	
	public Integer NumeroSequencialRegistroArq() {
		return registro.getValue("NumeroSequencialRegistroArq");
	}
}
