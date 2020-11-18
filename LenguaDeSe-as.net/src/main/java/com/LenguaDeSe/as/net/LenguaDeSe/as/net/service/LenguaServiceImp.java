package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Lengua;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.LenguaRepository;

@Service
public class LenguaServiceImp implements LenguaService {
	@Autowired
	private LenguaRepository repoLengua;

	@Override
	public List<Lengua> getLenguas() {
		return repoLengua.findAll();
	}

	@Override
	public Lengua getLengua(Integer id) {
		Optional<Lengua> o = repoLengua.findById(id);
		if(o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Lengua createLengua(Lengua lengua) {
		return repoLengua.save(lengua);
	}

	@Override
	public Lengua updateLengua(Lengua lengua) {
		if (this.getLengua(lengua.getIdLengua()) != null) { 
			return repoLengua.save(lengua);
		} else {
			return null;
		}
	}

	@Override
	public Lengua deleteLengua(Integer id) {
		Lengua lengua = this.getLengua(id);
		repoLengua.delete(lengua);
		return lengua;
	}
}
