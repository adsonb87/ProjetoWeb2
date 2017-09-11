package com.andreitoledo.cobranca.util.retorno.bradesco;

import java.io.File;
import java.math.BigDecimal;

import br.com.pe.urbana.cobranca.exception.ArquivoRetornoException;
import br.com.pe.urbana.cobranca.util.retorno.itau.ArquivoRetorno;

public class ArquivoRetornoTest {
	
	public static void deve_retornar_valor_total_transacoes() throws ArquivoRetornoException {
		File arquivo = new File("CN10077A-VT-11-07-17.txt");
		ArquivoRetorno arquivoRetorno = new ArquivoRetorno(arquivo);
		
		BigDecimal valorTotal = arquivoRetorno.getSumario().getValorTotalInformado();
		System.out.println(valorTotal);
	}
	
	public static void main(String[] args) throws ArquivoRetornoException {
		deve_retornar_valor_total_transacoes();
	}
	
}
