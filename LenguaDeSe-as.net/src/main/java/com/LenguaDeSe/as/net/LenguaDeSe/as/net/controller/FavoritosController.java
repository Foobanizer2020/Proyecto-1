package com.LenguaDeSe.as.net.LenguaDeSe.as.net.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.FavoritosData;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.FavoritosService;

@RestController
@RequestMapping("/api/favoritos")
public class FavoritosController {
	@Autowired
	private FavoritosService favoritosService; 
	
	@GetMapping
	public ResponseEntity<Object> getFavoritos(@RequestBody FavoritosData data) {
		HashMap<String, Object> favoritos = favoritosService.getFavoritos(data.getIdUsuario());
		if(favoritos == null) {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Usuario no encontrado.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(favoritos, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> addFavorito(@RequestBody FavoritosData data) {
		Object favorito;
		if(data.getTipo().equals(FavoritosData.FRASE)) {
			favorito = favoritosService.addFrase(data.getIdFavorito(), data.getIdUsuario());
		} else {
			favorito = favoritosService.addPalabra(data.getIdFavorito(), data.getIdUsuario());
		}
		HashMap<String, String> response = new HashMap<>();
		if(favorito == null) {
			response.put("status", "failure");
			response.put("message", "Usuario o frase/palabra no encontrado.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("status", "success");
		response.put("message", "Agregada frase/palabra id:" + data.getIdFavorito() + " en favoritos de usuario id:" + data.getIdUsuario());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deleteFavorito(@RequestBody FavoritosData data) {
		Object favorito;
		if(data.getTipo().equals(FavoritosData.FRASE)) {
			favorito = favoritosService.deleteFrase(data.getIdFavorito(), data.getIdUsuario());
		} else {
			favorito = favoritosService.deletePalabra(data.getIdFavorito(), data.getIdUsuario());
		}
		HashMap<String, String> response = new HashMap<>();
		if(favorito == null) {
			response.put("status", "failure");
			response.put("message", "Usuario o frase/palabra no encontrado.");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
		response.put("status", "success");
		response.put("message", "Eliminada frase/palabra id:" + data.getIdFavorito() + " de favoritos de usuario id:" + data.getIdUsuario());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
