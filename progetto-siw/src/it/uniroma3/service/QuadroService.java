package it.uniroma3.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import it.uniroma3.model.*;

public class QuadroService {

	private EntityManager em;

	public QuadroService() {

	}

	public Quadro inserisciQuadro(Quadro quadro) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(quadro);
		tx.commit();
		em.close();
		emf.close();
		return quadro;
	}

	public List<Quadro> getQuadri() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TypedQuery<Quadro> query = em.createNamedQuery("findAll", Quadro.class);
		List<Quadro> quadri = query.getResultList();
		tx.commit();
		em.close();
		emf.close();
		return quadri;
	}

	public Quadro getOne(Long id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Quadro quadro = em.find(Quadro.class, id);
		tx.commit();
		em.close();
		emf.close();
		return quadro;
	}

	public void delete(Quadro q) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("esercitazione-unit");
		this.em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.contains(q)? q: em.merge(q));
		tx.commit();
		em.close();
		emf.close();
	}
}