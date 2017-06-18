package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.model.Autore;
import it.uniroma3.model.Quadro;

public class AutoreService {
	
	private EntityManager em;

	public AutoreService() {
		
	}
	
	public Autore inserisciAutore(Autore autore) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(autore);
		tx.commit();
		em.close();
		emf.close();
		return autore;
	}

	public List<Autore> getAutori() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Autore> query = em.createNamedQuery("findAllAutori", Autore.class);
		List<Autore> autori = query.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return autori;
	}
	
	public Autore getOneAutore(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Autore autore = em.find(Autore.class, id);
		tx.commit();
		em.close();
		emf.close();
		return autore;
	}

	/*scrivere il controller e le pagine jsp per gestire inserimento/cancellazione di qualcosa,
	 * data la service? esiste un validatore con questa interfaccia*/
	public void delete(Autore a){
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazione-unit");
	this.em= emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	et.begin();
	em.remove(em.contains(a)? a: em.merge(a));
	et.commit();
	em.close();
	emf.close();
	}
	
	public List<Quadro> getQuadriAutore(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Autore autore = em.find(Autore.class, id);
		List<Quadro> quadri = autore.getQuadri();
		tx.commit();
		em.close();
		emf.close();
		return quadri;		
	}
}