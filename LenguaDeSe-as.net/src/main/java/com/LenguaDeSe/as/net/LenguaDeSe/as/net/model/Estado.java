package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Estado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idEstado")
	private Integer idEstado;
	
	@Column(name="nombre", columnDefinition="TEXT")
	private String nombre;
	
	@ManyToOne
	@JoinColumn(name="pais")
	private Pais pais;

	public Estado() { }

	public Estado(Integer idEstado, String nombre, Pais pais) {
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

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}
}
