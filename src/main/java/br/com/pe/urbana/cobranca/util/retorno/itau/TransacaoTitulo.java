package br.com.pe.urbana.cobranca.util.retorno.itau;

import java.math.BigDecimal;
import java.util.Date;

import org.jrimum.texgit.Record;

public class TransacaoTitulo {
	
	public static final Integer LIQUIDACAO = 6;
	
	private Record registro;
	
	public TransacaoTitulo(Record registro) {
		if (registro != null) {
			this.registro = registro;
		} else {
			throw new IllegalArgumentException("Registro de transa��o n�o foi informado.");
		}
	}
	
	public Integer getIDRegsitro() {
		return registro.getValue("IDRegsitro");
	}
	
	public Integer getCodigoInscricao() {
		return registro.getValue("CodigoInscricao");
	}
	public String getNumeroInscricao() {
		return registro.getValue("NumeroInscricao");
	}
	
	public Integer getAgencia() {
		return registro.getValue("Agencia");
	}
	
	public Integer getZeros1() {
		return registro.getValue("Zeros1");
	}
	
	public Integer getConta() {
		return registro.getValue("Conta");
	}
	
	public Integer getDigitoContaEmpresa() {
		return registro.getValue("DigitoContaEmpresa");
	}
	
	public String getBrancos1() {
		return registro.getValue("Brancos1");
	}
	
	public String getUsoDaEmpresa() {
		return registro.getValue("UsoDaEmpresa");
	}
	
	public Integer getNossoNumeroIdTituloBanco1() {
		return registro.getValue("NossoNumeroIdTituloBanco1");
	}
	
	public String getBrancos2() {
		return registro.getValue("Brancos2");
	}
	
	public Integer getCarteira() {
		return registro.getValue("Carteira");
	}
	
	public Integer getNossoNumeroIdTituloBanco() {
		return registro.getValue("NossoNumeroIdTituloBanco");
	}
	
	public Integer getDigitoNossoNumero() {
		return registro.getValue("DigitoNossoNumero");
	}
	
	public String getBrancos3() {
		return registro.getValue("Brancos3");
	}
	
	public String getCodigoCarteira() {
		return registro.getValue("CodigoCarteira");
	}
	
	public Integer getCodigoOcorrencia() {
		return registro.getValue("CodigoOcorrencia");
	}
	
	public Date getDataOcorrencia() {
		return registro.getValue("DataOcorrencia");
	}
	
	public String getNumeroDocumento() {
		return registro.getValue("NumeroDocumento");
	}
	
	public Integer getNossoNumeroConfTituloBanco() {
		return registro.getValue("NossoNumeroConfTituloBanco");
	}
	
	public String getBrancos4() {
		return registro.getValue("Brancos4");
	}
	
	public Date getVencimento() {
		return registro.getValue("Vencimento");
	}
	
	public BigDecimal getValorTitulo() {
		return registro.getValue("ValorTitulo");
	}
	
	public Integer getCodigoBanco() {
		return registro.getValue("CodigoBanco");
	}
	
	public Integer getAgenciaCobradora() {
		return registro.getValue("AgenciaCobradora");
	}
	
	public Integer getDigitoAgenciaCobradora() {
		return registro.getValue("DigitoAgenciaCobradora");
	}
	
	public String getEspecie() {
		return registro.getValue("Especie");
	}
	
	public BigDecimal getTarifaCobranca() {
		return registro.getValue("TarifaCobranca");
	}
	
	public String getBrancos5() {
		return registro.getValue("Brancos5");
	}
	
	public BigDecimal getValorIOF() {
		return registro.getValue("ValorIOF");
	}
	
	public BigDecimal getValorAbatimento() {
		return registro.getValue("ValorAbatimento");
	}
	
	public BigDecimal getDesconto() {
		return registro.getValue("Desconto");
	}
	
	public BigDecimal getValorPrincipal() {
		return registro.getValue("ValorPrincipal");
	}
	
	public BigDecimal getJurosMoraMulta() {
		return registro.getValue("JurosMoraMulta");
	}
	
	public BigDecimal getOutrosCreditos() {
		return registro.getValue("OutrosCreditos");
	}
	
	public String getBoletoDDA() {
		return registro.getValue("BoletoDDA");
	}
	
	public String getBrancos6() {
		return registro.getValue("Brancos6");
	}
	
	public Date getDataCreditoLiquidacao() {
		return registro.getValue("DataCreditoLiquidacao");
	}
	
	public Integer getInstrucaoCancelada() {
		return registro.getValue("InstrucaoCancelada");
	}
	
	public String getBrancos7() {
		return registro.getValue("Brancos7");
	}
	
	public Integer getZeros2() {
		return registro.getValue("Zeros2");
	}
	
	public String getNomePagador() {
		return registro.getValue("NomePagador");
	}
	
	public String getBrancos8() {
		return registro.getValue("Brancos8");
	}
	
	public String getErros() {
		return registro.getValue("Erros");
	}
	
	public String getBrancos9() {
		return registro.getValue("Brancos9");
	}
	
	public String getCodigoLiquidacao() {
		return registro.getValue("CodigoLiquidacao");
	}
	
	public Integer getNumeroSequencialRegistroArq() {
		return registro.getValue("NumeroSequencialRegistroArq");
	}
}
