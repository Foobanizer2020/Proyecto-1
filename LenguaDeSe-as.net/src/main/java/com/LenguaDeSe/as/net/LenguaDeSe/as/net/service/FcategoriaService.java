package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Fcategoria;

public interface FcategoriaService {
	public abstract List<Fcategoria> getFcategorias();
	public abstract Fcategoria getFcategoria(Integer id);
	public abstract Fcategoria createFcategoria(Fcategoria fcategoria);
	public abstract Fcategoria updateFcategoria(Fcategoria fcategoria);
	public abstract Fcategoria deleteFcategoria(Integer id);
}

