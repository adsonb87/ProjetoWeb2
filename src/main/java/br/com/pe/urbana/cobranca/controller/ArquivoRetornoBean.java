package br.com.pe.urbana.cobranca.controller;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import br.com.pe.urbana.cobranca.exception.ArquivoRetornoException;
import br.com.pe.urbana.cobranca.model.Cobranca;
import br.com.pe.urbana.cobranca.service.ArquivoRetornoService;
import br.com.pe.urbana.cobranca.util.jsf.FacesUtil;

@Named
@RequestScoped
public class ArquivoRetornoBean {

	private UploadedFile arquivo;
	
	private List<Cobranca> cobrancasPagas = getListaCobrancas();
	
	public List<Cobranca> getCobrancasPagar() {
		return cobrancasPagas;
	}

	@Inject
	private ArquivoRetornoService arquivoRetornoService;
	
	FacesContext contexto = FacesContext.getCurrentInstance();
	
	public void upload() {
		try {
			List<String> mensagens = arquivoRetornoService.carregar(arquivo.getFileName(), arquivo.getInputstream());
			mensagens.forEach(m -> FacesUtil.addSuccessMessage(m));	
			
			cobrancasPagas = getListaCobrancas();
		} catch (ArquivoRetornoException | IOException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		} 
	}

	public UploadedFile getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadedFile arquivo) {
		this.arquivo = arquivo;
	}
	
	@SuppressWarnings("unchecked")
	private List<Cobranca> getListaCobrancas() {
		return (List<Cobranca>) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("listaCobrancasPagas");
	}
	
}
