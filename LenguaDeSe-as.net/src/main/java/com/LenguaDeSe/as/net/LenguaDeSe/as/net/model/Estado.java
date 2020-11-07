package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEstado")
	private Integer idEstado;
	
	@Column(name="nombre", columnDefinition="TEXT")
	private String nombre;
	
	private Integer pais;

	public Estado() { }

	public Estado(Integer idEstado, String nombre, Integer pais) {
		super();
		this.idEstado = idEstado;
		this.nombre = nombre;
		this.pais = pais;
	}

	public Integer getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getPais() {
		return pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}
}
