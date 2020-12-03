package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

public class FavoritosData {
	public static String FRASE = "FAVORITO.FRASE";
	public static String PALABRA = "FAVORITO.PALABRA";
	
	private Integer idUsuario;
	private Integer idFavorito;
	private String tipo;
	
	public FavoritosData() {}
	
	public FavoritosData(Integer idUsuario, Integer idFavorito) {
		super();
		this.idUsuario = idUsuario;
		this.idFavorito = idFavorito;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public Integer getIdFavorito() {
		return idFavorito;
	}
	
	public void setIdFavorito(Integer idFavorito) {
		this.idFavorito = idFavorito;
	}
}
