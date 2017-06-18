package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.model.Amministratore;
import it.uniroma3.model.Amministratore;
import it.uniroma3.repository.CrudRepositoryJPA;

public class AmministratoreService {
	
	private EntityManager em;

	public AmministratoreService() {
		
	}
	
	public Amministratore inserisciAmministratore(Amministratore amministratore) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(amministratore);
		tx.commit();
		em.close();
		emf.close();
		return amministratore;
	}

	public List<Amministratore> getAmministratori() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Amministratore> query = em.createNamedQuery("findAllAmministratori", Amministratore.class);
		List<Amministratore> amministratori = query.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return amministratori;
	}
	
	public Amministratore getOne(String email) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Amministratore amministratore = em.find(Amministratore.class, email);
		tx.commit();
		em.close();
		emf.close();
		return amministratore;
	}

	/*scrivere il controller e le pagine jsp per gestire inserimento/cancellazione di qualcosa,
	 * data la service? esiste un validatore con questa interfaccia*/
	public void delete(Amministratore a){
	EntityManagerFactory emf= Persistence.createEntityManagerFactory("esercitazione-unit");
	this.em= emf.createEntityManager();
	EntityTransaction et= em.getTransaction();
	et.begin();
	em.remove(em.contains(a)? a: em.merge(a));
	et.commit();
	em.close();
	emf.close();
	}

}