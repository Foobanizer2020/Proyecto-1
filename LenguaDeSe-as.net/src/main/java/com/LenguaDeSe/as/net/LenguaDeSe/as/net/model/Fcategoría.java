package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Fcategoría {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFcategoría", columnDefinition = "TINYINT")
	private Integer idFcategoría;
	
	@Column(columnDefinition="TEXT")
	private String nombre;
	
	@OneToMany(fetch =FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="frases")
	private Frase frase;
	
	public Fcategoría () {
		
	}

	public Fcategoría(Integer idFcategoría, String nombre, Frase frase) {
		super();
		this.idFcategoría = idFcategoría;
		this.nombre = nombre;
		this.frase = frase;
	}

	public Integer getIdFcategoría() {
		return idFcategoría;
	}

	public void setIdFcategoría(Integer idFcategoría) {
		this.idFcategoría = idFcategoría;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Frase getFrase() {
		return frase;
	}

	public void setFrase(Frase frase) {
		this.frase = frase;
	}

}
