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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Palabra;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.PalabraService;

@RestController
@RequestMapping("/api/palabra")
public class PalabraCtrl {
	@Autowired
	private PalabraService servPalabra;
	
	@GetMapping("")
	public ResponseEntity<Object> getPalabras() {
		return new ResponseEntity<>(servPalabra.getPalabras(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getPalabra(@PathVariable Integer id) {
		Palabra Palabra = servPalabra.getPalabra(id);
		if (Palabra != null) {
			return new ResponseEntity<>(Palabra, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Palabra no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createPalabra(@Valid @RequestBody Palabra palabra) {
		servPalabra.createPalabra(palabra);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "created");
		response.put("message", "Palabra guardada exitosamente.");
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updatePalabra(@PathVariable Integer id, @Valid @RequestBody Palabra palabra) {
		palabra.setIdPalabra(id);
		palabra = servPalabra.updatePalabra(palabra);
		HashMap<String, String> response = new HashMap<>();
		if (palabra != null) {
			response.put("status", "updated");
			response.put("message", "Palabra actualizada exitosamente");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("status", "failure");
			response.put("message", "Palabra no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deletePalabra(@PathVariable Integer id) {
		servPalabra.deletePalabra(id);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "deleted");
		response.put("message", "Palabra eliminada exitosamente");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
