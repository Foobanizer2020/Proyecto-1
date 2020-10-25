package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="paises")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idPais", columnDefinition = "TINYINT")
	private Integer idPais;
	
	@Column(columnDefinition="TEXT")
	private String pais;
	
	@Column(columnDefinition="CHAR(2)")
	private String abraviatura;
	
	@ManyToMany(mappedBy = "paises")
    private List<Idioma> idiomas;

	// TODO: Implementar clases Lengua
	// private List<Lengua> lenguas;
	
	public Pais() { }
	
	public Pais(Integer idPais, String pais, String abraviatura) {
		super();
		this.idPais = idPais;
		this.pais = pais;
		this.abraviatura = abraviatura;
	}

	public Integer getIdPais() {
		return idPais;
	}

	public void setIdPais(Integer idPais) {
		this.idPais = idPais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getAbraviatura() {
		return abraviatura;
	}

	public void setAbraviatura(String abraviatura) {
		this.abraviatura = abraviatura;
	}
}
