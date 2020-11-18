package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Idioma;

public interface IdiomaService {
	public abstract List<Idioma> getIdiomas();
	public abstract Idioma getIdioma(Integer id);
	public abstract Idioma createIdioma(Idioma idioma);
	public abstract Idioma updateIdioma(Idioma idioma);
	public abstract Idioma deleteIdioma(Integer id);
}
