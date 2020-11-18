package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Idioma;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.IdiomaRepository;


@Service
public class IdiomaServiceImp implements IdiomaService {
	@Autowired
	private IdiomaRepository repoIdioma;
	@Override

	public List<Idioma> getIdiomas() {
		return repoIdioma.findAll();
	}

	@Override
	public Idioma getIdioma(Integer id) {
		Optional<Idioma> o = repoIdioma.findById(id);
		if(o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Idioma createIdioma(Idioma idioma) {
		return repoIdioma.save(idioma);
	}

	@Override
	public Idioma updateIdioma(Idioma idioma) {
		if (this.getIdioma(idioma.getIdIdioma()) != null) { 
			return repoIdioma.save(idioma);
		} else {
			return null;
		}
	}

	@Override
	public Idioma deleteIdioma(Integer id) {
		Idioma Idioma = this.getIdioma(id);
		repoIdioma.delete(Idioma);
		return Idioma;
	}
}
