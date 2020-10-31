package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idUsuario")
	private Integer idUsuario;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column (name="tipo_usuario")
	private String  tipo_usuario;
	
	@ManyToOne
	@JoinColumn(name="pais")
	private Pais pais;
	
	@ManyToOne
	@JoinColumn(name="estado")
	private Estado estado;
	
	@ManyToOne
	@JoinColumn(name="idioma")
	private Idioma idioma;

	public Usuario() { }
	
	public Usuario(Integer idUsuario, String email, String password, String  tipo_usuario, Pais pais, Estado estado, Idioma idioma) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.password = password;
		this.tipo_usuario = tipo_usuario;
		this.pais = pais;
		this.estado = estado;
		this.idioma = idioma;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(String tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}
}
