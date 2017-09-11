package br.com.pe.urbana.cobranca.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.pe.urbana.cobranca.model.Cobranca2;
import br.com.pe.urbana.cobranca.model.Status;
import br.com.pe.urbana.cobranca.repository.Cobrancas;
import br.com.pe.urbana.cobranca.util.jpa.Transactional;

public class NovaCobrancaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private Cobrancas cobrancas;

	@Transactional
	public Cobranca2 salvar(Cobranca2 cobranca) {
		cobranca.setStatus(Status.PENDENTE);
		cobranca = this.cobrancas.guardar(cobranca);

		return cobranca;
	}

}
