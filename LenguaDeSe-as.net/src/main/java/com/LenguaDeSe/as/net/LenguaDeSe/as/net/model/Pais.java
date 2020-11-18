package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	private String abreviatura;
	
	public Pais() { }
	
	public Pais(Integer idPais, String pais, String abreviatura) {
		super();
		this.idPais = idPais;
		this.pais = pais;
		this.abreviatura = abreviatura;
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

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
}
