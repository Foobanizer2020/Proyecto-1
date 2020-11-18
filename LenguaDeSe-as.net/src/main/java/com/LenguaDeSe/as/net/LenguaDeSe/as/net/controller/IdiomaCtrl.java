package com.LenguaDeSe.as.net.LenguaDeSe.as.net.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Idioma;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.IdiomaService;

@RestController
@RequestMapping("/api/idioma")
public class IdiomaCtrl {
	@Autowired
	private IdiomaService servIdioma;
	
	@GetMapping("")
	public ResponseEntity<Object> getIdiomas() {
		return new ResponseEntity<>(servIdioma.getIdiomas(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getIdioma(@PathVariable Integer id) {
		Idioma Idioma = servIdioma.getIdioma(id);
		if (Idioma != null) {
			return new ResponseEntity<>(Idioma, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Idioma no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createIdioma(@Valid @RequestBody Idioma idioma) {
		servIdioma.createIdioma(idioma);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "created");
		response.put("message", "Idioma guardada exitosamente.");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateIdioma(@PathVariable Integer id, @Valid @RequestBody Idioma idioma) {
		idioma.setIdIdioma(id);
		idioma = servIdioma.updateIdioma(idioma);
		HashMap<String, String> response = new HashMap<>();
		if (idioma != null) {
			response.put("status", "updated");
			response.put("message", "Idioma actualizada exitosamente");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("status", "failure");
			response.put("message", "Idioma no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteIdioma(@PathVariable Integer id) {
		servIdioma.deleteIdioma(id);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "deleted");
		response.put("message", "Idioma eliminada exitosamente");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
