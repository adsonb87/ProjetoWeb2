package br.com.pe.urbana.cobranca.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.pe.urbana.cobranca.model.Cobranca;
import br.com.pe.urbana.cobranca.model.Cobranca2;

public class Cobrancas implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Cobranca2 guardar(Cobranca2 cobranca){
		return manager.merge(cobranca);
	}
	
	public Cobranca porCodigo(Long codigoCobranca) {
				
        String jpql = " SELECT c FROM Cobranca c WHERE c.codigo = :codigo";
		
        List<Cobranca> list = this.manager.createQuery(jpql, Cobranca.class)
        		.setParameter("codigo", codigoCobranca)
        		.getResultList();
        
        if(list.isEmpty()) return null;
        
        return list.get(0);
        
	}	

}
