package br.com.pe.urbana.cobranca.util.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.pe.urbana.cobranca.model.Cedente;

public class TesteGerarTabelas {

	public static void main(String[] args) {
		EntityManagerProducer em = new EntityManagerProducer();
		EntityManager emg = em.create();
		
		Cedente cedente = new Cedente();
		cedente.setNome("Iago");
		cedente.setCnpj("123456789");
		
		emg.getTransaction().begin();
		
		//emg.persist(cedente);
		String jpql = "select c.nome from Cedente c "
					+ "where c.cnpj = :pCnpj";
		Query query = emg.createQuery(jpql);
		query.setParameter("pCnpj", cedente.getCnpj());
		
		List<String> cedentes = query.getResultList();
		
		for (String c: cedentes) {
			System.out.println(c);
		}
		
		System.out.println(cedentes.size());
		
		emg.getTransaction().commit();
		emg.close();
	}
}