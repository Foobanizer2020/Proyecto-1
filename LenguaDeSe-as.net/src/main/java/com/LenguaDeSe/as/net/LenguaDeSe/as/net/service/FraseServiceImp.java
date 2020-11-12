package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Frase;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.FraseRepository;

public class FraseServiceImp implements FraseService {

	@Autowired 
	private FraseRepository repoFrase;
	
	@Override
	public List<Frase> getFrasesByFiltro() {
		return repoFrase.findAll();
	}

	@Override
	public Frase getFrase(Integer id) {
		Optional<Frase> o = repoFrase.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Frase createFrase(Frase frase) {
		return repoFrase.save(frase);
	}

	@Override
	public Frase updateFrase(Integer id, Frase frase) {
		if (this.getFrase(frase.getIdFrase()) != null) { 
			return repoFrase.save(frase);
		} else {
			return null;
		}
	}

	@Override
	public Frase deleteFrase(Integer id) {
		Frase frase = this.getFrase(id);
		repoFrase.delete(frase);
		return frase;
	}

}
