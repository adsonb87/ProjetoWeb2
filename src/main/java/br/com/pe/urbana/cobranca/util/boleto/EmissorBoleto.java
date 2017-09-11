package br.com.pe.urbana.cobranca.util.boleto;

import java.io.File;
import java.io.Serializable;

import br.com.pe.urbana.cobranca.model.Cedente;
import br.com.pe.urbana.cobranca.model.Cobranca2;

public interface EmissorBoleto extends Serializable {

	public byte[] gerarBoleto(Cedente cedenteSistema, Cobranca2 cobrancaSistema);
	public File gerarBoletoEmArquivo(String arquivo, Cedente cedenteSistema, Cobranca2 cobrancaSistema);
	
}
