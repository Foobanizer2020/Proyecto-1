package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Frase;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Palabra;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Usuario;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.FraseRepository;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.PalabraRepository;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.UsuarioRepository;

@Service
public class FavoritosServiceImp implements FavoritosService {

	@Autowired
	private UsuarioRepository repoUsuario;
	
	@Autowired
	private FraseRepository repoFrase;
	
	@Autowired
	private PalabraRepository repoPalabra;
	
	@Override
	public HashMap<String, Object> getFavoritos(Integer idUsuario) {
		Optional<Usuario> o = repoUsuario.findById(idUsuario);
		if(!o.isPresent()) {
			return null;
		}
		Usuario usuario = o.get();
		HashMap<String, Object> favoritos = new HashMap<>();
		favoritos.put("frases", usuario.getFrasesFavoritas());
		favoritos.put("palabras", usuario.getPalabrasFavoritas());
		return favoritos;
	}

	@Override
	public Frase addFrase(Integer idFrase, Integer idUsuario) {
		Optional<Frase> o = repoFrase.findById(idFrase);
		Optional<Usuario> p = repoUsuario.findById(idUsuario);
		if(!o.isPresent() || !p.isPresent()) {
			return null;
		}
		Frase frase = o.get();
		Usuario usuario = p.get();
		ArrayList<Frase> favoritas = new ArrayList<>(usuario.getFrasesFavoritas());
		if(!favoritas.contains(frase)) {
			favoritas.add(frase);
			usuario.setFrasesFavoritas(favoritas);
			repoUsuario.save(usuario);
		}
		return frase;
	}

	@Override
	public Palabra addPalabra(Integer idPalabra, Integer idUsuario) {
		Optional<Palabra> o = repoPalabra.findById(idPalabra);
		Optional<Usuario> p = repoUsuario.findById(idUsuario);
		if(!o.isPresent() || !p.isPresent()) {
			return null;
		}
		Palabra palabra = o.get();
		Usuario usuario = p.get();
		ArrayList<Palabra> favoritas = new ArrayList<>(usuario.getPalabrasFavoritas());
		if(!favoritas.contains(palabra)) {
			favoritas.add(palabra);
			usuario.setPalabrasFavoritas(favoritas);
			repoUsuario.save(usuario);
		}
		return palabra;
	}

	@Override
	public Frase deleteFrase(Integer idFrase, Integer idUsuario) {
		Optional<Frase> o = repoFrase.findById(idFrase);
		Optional<Usuario> p = repoUsuario.findById(idUsuario);
		if(!o.isPresent() || !p.isPresent()) {
			return null;
		}
		Frase frase = o.get();
		Usuario usuario = p.get();
		ArrayList<Frase> favoritas = new ArrayList<Frase>(usuario.getFrasesFavoritas());
		favoritas.remove(frase);
		usuario.setFrasesFavoritas(favoritas);
		repoUsuario.save(usuario);
		return frase;
	}

	@Override
	public Palabra deletePalabra(Integer idPalabra, Integer idUsuario) {
		Optional<Palabra> o = repoPalabra.findById(idPalabra);
		Optional<Usuario> p = repoUsuario.findById(idUsuario);
		if(!o.isPresent() || !p.isPresent()) {
			return null;
		}
		Palabra palabra = o.get();
		Usuario usuario = p.get();
		ArrayList<Palabra> favoritas = new ArrayList<>(usuario.getPalabrasFavoritas());
		favoritas.remove(palabra);
		usuario.setPalabrasFavoritas(favoritas);
		repoUsuario.save(usuario);
		return palabra;
	}
}
