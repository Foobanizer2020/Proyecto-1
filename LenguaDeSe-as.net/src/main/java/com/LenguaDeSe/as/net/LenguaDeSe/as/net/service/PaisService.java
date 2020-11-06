package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Pais;

public interface PaisService {
	public abstract List<Pais> getPaises();
	public abstract Pais getPais(Integer id);
	public abstract Pais createPais(Pais pais);
	public abstract Pais updatePais(Pais pais);
	public abstract Pais deletePais(Pais pais);
}
