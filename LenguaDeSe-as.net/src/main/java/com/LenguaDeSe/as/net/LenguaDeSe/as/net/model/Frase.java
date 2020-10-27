package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="frases")
public class Frase {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFrase")
	private Integer idFrase;
	
	@Column(columnDefinition="TEXT")
	private String gif;
	
	@Column(columnDefinition="TEXT")
	private String contenido;
	
	@ManyToOne
	@JoinColumn(name="Fcategoria")
	private Fcategoria fcategoria;

	@ManyToOne
	@JoinColumn(name="lenguas")
	private Lengua lengua;
	
	public Frase () {
		
	}

	public Frase(Integer idFrase, String gif, String contenido, Fcategoria fcategoria, Lengua lengua) {
		super();
		this.idFrase = idFrase;
		this.gif = gif;
		this.contenido = contenido;
		this.fcategoria = fcategoria;
		this.lengua = lengua;
	}

	public Integer getIdFrase() {
		return idFrase;
	}

	public void setIdFrase(Integer idFrase) {
		this.idFrase = idFrase;
	}

	public String getGif() {
		return gif;
	}

	public void setGif(String gif) {
		this.gif = gif;
	}

	public String getContenido() {
		return contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Fcategoria getFcategoria() {
		return fcategoria;
	}

	public void setFcategoría(Fcategoria fcategoria) {
		this.fcategoria = fcategoria;
	}

	public Lengua getLengua() {
		return lengua;
	}

	public void setLengua(Lengua lengua) {
		this.lengua = lengua;
	}
	
}
