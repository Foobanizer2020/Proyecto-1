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
@Table(name="paises")
public class Pais {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "TINYINT")
	private Integer id;
	
	@Column(columnDefinition="TEXT")
	private String pais;
	
	@Column(columnDefinition="CHAR(2)")
	private String abraviatura;
	
	@ManyToMany(mappedBy = "paises")
    private List<Idioma> idiomas;

	// TODO: Implementar clases Lengua y Estado
	// private List<Lengua> lenguas;
	// private List<Estado> estados;
	
	public Pais(Integer id, String pais, String abraviatura) {
		super();
		this.id = id;
		this.pais = pais;
		this.abraviatura = abraviatura;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
