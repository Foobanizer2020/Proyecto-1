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
import javax.persistence.Table;

@Entity
@Table(name="fcategorias")
public class Fcategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idFcategoria", columnDefinition = "TINYINT")
	private Integer idFcategoria;
	
	@Column(columnDefinition="TEXT")
	private String nombre;
	
	public Fcategoria () {
		
	}

	public Fcategoria(Integer idFcategoria, String nombre) {
		super();
		this.idFcategoria = idFcategoria;
		this.nombre = nombre;
	}

	public Integer getIdFcategoria() {
		return idFcategoria;
	}

	public void setIdFcategoria(Integer idFcategoria) {
		this.idFcategoria = idFcategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
