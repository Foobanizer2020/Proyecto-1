package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
public class Idioma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(columnDefinition="TEXT")
	private String nombre;
	
	@Column(columnDefinition="CHAR(2)")
	private String abreviatura;
	
	@JoinTable(
        name = "idiomapaises",
        joinColumns = @JoinColumn(name = "FK_IDIOMA", nullable = false),
        inverseJoinColumns = @JoinColumn(name="FK_PAIS", nullable = false)
    )
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Pais> paises;
	
	
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
