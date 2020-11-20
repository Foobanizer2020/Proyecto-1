package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Palabra;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.PalabraRepository;


@Service
public class PalabraServiceImp implements PalabraService {
	@Autowired
	private PalabraRepository repoPalabra;
	@Override

	public List<Palabra> getPalabras() {
		return repoPalabra.findAll();
	}

	@Override
	public Palabra getPalabra(Integer id) {
		Optional<Palabra> o = repoPalabra.findById(id);
		if(o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Palabra createPalabra(Palabra palabra) {
		palabra.setIdPalabra(null);
		return repoPalabra.save(palabra);
	}

	@Override
	public Palabra updatePalabra(Palabra palabra) {
		if (this.getPalabra(palabra.getIdPalabra()) != null) { 
			return repoPalabra.save(palabra);
		} else {
			return null;
		}
	}

	@Override
	public Palabra deletePalabra(Integer id) {
		Palabra palabra = this.getPalabra(id);
		repoPalabra.delete(palabra);
		return palabra;
	}
}
