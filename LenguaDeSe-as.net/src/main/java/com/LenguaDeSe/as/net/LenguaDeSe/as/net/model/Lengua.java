package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="lenguas")
public class Lengua {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idLenguas")
	private Integer idLengua;
	
	@Column(columnDefinition="TEXT")
	private String nombre;
	
	@Column(columnDefinition="VARCHAR(4)")
	private String abreviatura;
	
	@ManyToMany
	private List<Pais> paises;
	
	public Lengua () { }
	
	public Lengua(Integer idLengua, String nombre, String abreviatura, List<Pais> paises) {
		super();
		this.idLengua = idLengua;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
		this.paises = paises;
	}

	public Integer getIdLengua() {
		return idLengua;
	}

	public void setIdLengua(Integer idLengua) {
		this.idLengua = idLengua;
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

	public List<Pais> getPaises() {
		return paises;
	}

	public void setPaises(List<Pais> paises) {
		this.paises = paises;
	}
}
