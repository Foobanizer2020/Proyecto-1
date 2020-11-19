package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Categoria;

public interface CategoriaService {
	public abstract List<Categoria> getCategorias();
	public abstract Categoria getCategoria(Integer id);
	public abstract Categoria createCategoria(Categoria categoria);
	public abstract Categoria updateCategoria(Categoria categoria);
	public abstract Categoria deleteCategoria(Integer id);

}
