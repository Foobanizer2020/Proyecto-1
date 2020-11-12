package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name="fcategoria")
	private Integer fcategoria;

	@Column(name="lengua")
	private Integer lengua;
	
	public Frase () {
		
	}

	public Frase(Integer idFrase, String gif, String contenido, Integer fcategoria, Integer lengua) {
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

	public Integer getFcategoria() {
		return fcategoria;
	}

	public void setFcategoría(Integer fcategoria) {
		this.fcategoria = fcategoria;
	}

	public Integer getLengua() {
		return lengua;
	}

	public void setLengua(Integer lengua) {
		this.lengua = lengua;
	}
	
}
