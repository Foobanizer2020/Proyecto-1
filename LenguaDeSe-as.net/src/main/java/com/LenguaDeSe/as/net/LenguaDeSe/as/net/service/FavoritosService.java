package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.HashMap;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Frase;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Palabra;

public interface FavoritosService {
	public abstract HashMap<String, Object> getFavoritos(Integer idUsuario);
	public abstract Frase addFrase(Integer idFrase, Integer idUsuario);
	public abstract Palabra addPalabra(Integer idPalabra, Integer idUsuario);
	public abstract Frase deleteFrase(Integer idFrase, Integer idUsuario);
	public abstract Palabra deletePalabra(Integer idPalabra, Integer idUsuario);
}
