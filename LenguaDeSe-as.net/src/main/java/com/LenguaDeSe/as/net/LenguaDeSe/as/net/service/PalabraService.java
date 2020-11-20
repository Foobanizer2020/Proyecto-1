package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Palabra;

public interface PalabraService {
	public abstract List<Palabra> getPalabras();
	public abstract Palabra getPalabra(Integer id);
	public abstract Palabra createPalabra(Palabra palabra);
	public abstract Palabra updatePalabra(Palabra palabra);
	public abstract Palabra deletePalabra(Integer id);
}
