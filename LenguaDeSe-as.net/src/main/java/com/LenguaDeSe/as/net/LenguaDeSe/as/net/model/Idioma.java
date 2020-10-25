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
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

@Entity
@Table(name="idioma")
public class Idioma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idIdioma")
	private Integer idIdioma;
	
	@Column(columnDefinition="TEXT")
	private String nombre;
	
	@Column(columnDefinition="CHAR(2)")
	private String abreviatura;
	
	@JoinTable(
        name = "idiomapaises",
        joinColumns = @JoinColumn(name = "IDIOMAS_ID", nullable = false),
        inverseJoinColumns = @JoinColumn(name="PAISES_ID", nullable = false)
    )
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Pais> paises;
	
	public Idioma() { }
	
	public Idioma(Integer idIdioma, String nombre, String abreviatura) {
		super();
		this.idIdioma = idIdioma;
		this.nombre = nombre;
		this.abreviatura = abreviatura;
	}
	
	public Integer getIdIdioma() {
		return idIdioma;
	}
	
	public void setIdIdioma(Integer idIdioma) {
		this.idIdioma = idIdioma;
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
