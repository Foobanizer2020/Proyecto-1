package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Idioma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition="TEXT")
	private String nombre;
	
	@Column(columnDefinition="char(2)")
	private String abreviatura;
	
	// Hasta que se implemente clase Pais
	// private List<Pais> paises;
	
	
	public Idioma(Integer id, String nombre, String abreviatura) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
}
