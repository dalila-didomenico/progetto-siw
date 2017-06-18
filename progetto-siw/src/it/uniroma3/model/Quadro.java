package it.uniroma3.model;

import javax.persistence.*;

@Entity
@Table(name="quadri")
@NamedQuery(name = "findAll", query = "SELECT q FROM Quadro q")
public class Quadro {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(nullable=false)
	private String titolo;

	private int anno;
	private String tecnica;
	private String dimensioni;

	@ManyToOne
	@JoinColumn(name="artista")
	private Autore autore;

	public Quadro() {
		//
	}

	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getAnno() {
		return anno;
	}
	public void setAnno(int anno) {
		this.anno = anno;
	}
	public String getTecnica() {
		return tecnica;
	}
	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}
	public String getDimensioni() {
		return dimensioni;
	}
	public void setDimensioni(String dimensioni) {
		this.dimensioni = dimensioni;
	}
	public Long getId() {
		return id;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}
}