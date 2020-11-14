package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Fcategoria;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.FcategoriaRepository;

@Service
public class FcategoriaServiceImp implements FcategoriaService  {
	
	@Autowired
	private FcategoriaRepository repoFcategoria;
	
	@Override
	public List<Fcategoria> getFcategorias() {
		return repoFcategoria.findAll();
	}

	@Override
	public Fcategoria getFcategoria(Integer id) {
		Optional<Fcategoria> o = repoFcategoria.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Fcategoria createFcategoria(Fcategoria fcategoria) {
		return repoFcategoria.save(fcategoria);
	}

	@Override
	public Fcategoria updateFcategoria(Fcategoria fcategoria) {
		if (this.getFcategoria(fcategoria.getIdFcategoria()) != null) { 
			return repoFcategoria.save(fcategoria);
		} else {
			return null;
		}
	}

	@Override
	public Fcategoria deleteFcategoria(Integer id) {
		Fcategoria fcategoria = this.getFcategoria(id);
		repoFcategoria.delete(fcategoria);
		return fcategoria;
	}	
}