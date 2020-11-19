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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Senia;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.SeniaRepository;

@Service
public class SeniaServiceImp implements SeniaService{

private String basePath = "./target/classes/static/videos/senias/";
	
	@Autowired 
	private SeniaRepository repoSenia;
	
	
	@Override
	public List<Senia> getSeniasByFiltro() {
		return repoSenia.findAll();
	}

	@Override
	public Senia getSenia(Integer id) {
		Optional<Senia> o = repoSenia.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Senia createSenia(Senia senia) throws FileNotFoundException, IOException {
		byte[] videoByte = Base64.getDecoder().decode(senia.getGif().substring(senia.getGif().indexOf(",") + 1));
		senia.setGif(null);
		senia = repoSenia.save(senia);
		
	    String fileName = senia.getIdSenias().toString() + ".mp4";
		String directory = "videos/frases/" + fileName;
		senia.setGif(directory);
		senia = repoSenia.save(senia);
		
        new FileOutputStream(basePath + fileName).write(videoByte);
        return senia;
	}

	@Override
	public Senia updateSenia(Senia senia) {
		if (this.getSenia(senia.getIdSenias()) != null) { 
			return repoSenia.save(senia);
		} else {
		return null;
		}
	}

	@Override
	public Senia deleteSenia(Integer id) {
		Senia senia = this.getSenia(id);
		if (senia != null) {
			String fileName = senia.getIdSenias().toString() + ".mp4";
			File video = new File(basePath + fileName);
			video.delete();
		}
		repoSenia.delete(senia);
		return senia;
	}

}
