package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Pais;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.PaisRepository;

@Service
public class PaisServiceImp implements PaisService{

	@Autowired
	private PaisRepository repoPais;

	@Override
	public List<Pais> getPaises() {
		return repoPais.findAll();
	}

	@Override
	public Pais getPais(Integer id) {
		Optional<Pais> o = repoPais.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Pais createPais(Pais pais) {
		return repoPais.save(pais);
	}

	@Override
	public Pais updatePais(Pais pais) {
		if (this.getPais(pais.getIdPais()) != null) { 
			return repoPais.save(pais);
		} else {
			return null;
		}
	}

	@Override
	public Pais deletePais(Pais pais) {
		pais = this.getPais(pais.getIdPais());
		repoPais.delete(pais);
		return pais;
	}	
}
