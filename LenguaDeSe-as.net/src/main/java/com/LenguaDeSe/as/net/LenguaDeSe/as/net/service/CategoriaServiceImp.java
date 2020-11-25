package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Categoria;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.CategoriaRepository;



@Service
public class CategoriaServiceImp implements CategoriaService  {
	
	@Autowired
	private CategoriaRepository repoCategoria;
	
	@Override
	public List<Categoria> getCategorias() {
		return repoCategoria.findAll();
	}

	@Override
	public Categoria getCategoria(Integer id) {
		Optional<Categoria> o = repoCategoria.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Categoria createCategoria(Categoria categoria) {
		return repoCategoria.save(categoria);
	}

	@Override
	public Categoria updateCategoria(Categoria categoria) {
		if (this.getCategoria(categoria.getIdCategoria()) != null) { 
			return repoCategoria.save(categoria);
		} else {
			return null;
		}
	}

	@Override
	public Categoria deleteCategoria(Integer id) {
		Categoria categoria = this.getCategoria(id);
		repoCategoria.delete(categoria);
		return categoria;
	}
}
