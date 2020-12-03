package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

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
	
	@OneToOne(optional=true, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name="id_tipo_usuario", insertable=false, updatable=false)
	private TipoUsuario tipo_usuario;
	
	@Column(name="id_tipo_usuario")
	private Integer id_tipo_usuario;
	
	@Column(name="pais")
	private Integer pais;
	
	@Column(name="estado")
	private Integer estado;
	
	@Column(name="idioma")
	private Integer idioma;
	
	@ManyToMany
	private List<Frase> frasesFavoritas;
	
	@ManyToMany
	private List<Palabra> palabrasFavoritas;

	public Usuario() { }

	public Usuario(Integer idUsuario, String email, String password, TipoUsuario tipo_usuario, Integer id_tipo_usuario,
			Integer pais, Integer estado, Integer idioma) {
		super();
		this.idUsuario = idUsuario;
		this.email = email;
		this.password = password;
		this.tipo_usuario = tipo_usuario;
		this.id_tipo_usuario = id_tipo_usuario;
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

	public TipoUsuario getTipo_usuario() {
		return tipo_usuario;
	}

	public void setTipo_usuario(TipoUsuario tipo_usuario) {
		this.tipo_usuario = tipo_usuario;
	}

	public Integer getId_tipo_usuario() {
		return id_tipo_usuario;
	}

	public void setId_tipo_usuario(Integer id_tipo_usuario) {
		this.id_tipo_usuario = id_tipo_usuario;
	}

	public Integer getPais() {
		return pais;
	}

	public void setPais(Integer pais) {
		this.pais = pais;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Integer getIdioma() {
		return idioma;
	}

	public void setIdioma(Integer idioma) {
		this.idioma = idioma;
	}
	public List<Frase> getFrasesFavoritas() {
		return frasesFavoritas;
	}

	public void setFrasesFavoritas(List<Frase> frasesFavoritas) {
		this.frasesFavoritas = frasesFavoritas;
	}

	public List<Palabra> getPalabrasFavoritas() {
		return palabrasFavoritas;
	}

	public void setPalabrasFavoritas(List<Palabra> palabrasFavoritas) {
		this.palabrasFavoritas = palabrasFavoritas;
	}
}
