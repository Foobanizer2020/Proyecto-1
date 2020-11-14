package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Frase;

public interface FraseService {
	public abstract List<Frase> getFrasesByFiltro();
	public abstract Frase getFrase(Integer id);
	public abstract Frase createFrase(Frase frase) throws FileNotFoundException, IOException;
	public abstract Frase updateFrase(Frase frase);
	public abstract Frase deleteFrase(Integer id);
}
