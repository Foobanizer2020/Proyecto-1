package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Frase;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.FraseRepository;

@Service
public class FraseServiceImp implements FraseService {

	private String basePath = "./target/classes/static/videos/frases/";
	
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
	public Frase createFrase(Frase frase) throws FileNotFoundException, IOException {
		byte[] videoByte = Base64.getDecoder().decode(frase.getGif().substring(frase.getGif().indexOf(",") + 1));
		frase.setGif(null);
		frase = repoFrase.save(frase);
		
	    String fileName = frase.getIdFrase().toString() + ".mp4";
		String directory = "videos/frases/" + fileName;
		frase.setGif(directory);
		frase = repoFrase.save(frase);
		
        new FileOutputStream(basePath + fileName).write(videoByte);
        return frase;
	}
		
	@Override
	public Frase updateFrase(Frase frase) {
		if (this.getFrase(frase.getIdFrase()) != null) { 
			return repoFrase.save(frase);
		} else {
			return null;
		}
	}

	@Override
	public Frase deleteFrase(Integer id) {
		Frase frase = this.getFrase(id);
		if (frase != null) {
			String fileName = frase.getIdFrase().toString() + ".mp4";
			File video = new File(basePath + fileName);
			video.delete();
		}
		repoFrase.delete(frase);
		return frase;
	}

}
