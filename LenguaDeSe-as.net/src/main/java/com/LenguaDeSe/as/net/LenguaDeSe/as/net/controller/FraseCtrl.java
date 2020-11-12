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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Frase;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.FraseService;

@RestController
@RequestMapping("api/frase")
public class FraseCtrl {
	@Autowired
	private FraseService fraseService;
	
	@GetMapping("")
	public ResponseEntity<Object> getFrases() {
		return new ResponseEntity<>(fraseService.getFrasesByFiltro(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getFrase(@PathVariable Integer id) {
		Frase frase = fraseService.getFrase(id); 
		if (frase != null) {
			return new ResponseEntity<>(frase, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Frase no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createFrase(@Valid @RequestBody Frase frase) {
		fraseService.createFrase(frase);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "created");
		response.put("message", "Frase guardado exitosamente.");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateFrase(@PathVariable Integer id, @RequestBody Frase frase) {
		frase.setIdFrase(id);
		frase = fraseService.updateFrase(frase);
		HashMap<String, String> response = new HashMap<>();
		if (frase != null) {
			response.put("status", "updated");
			response.put("message", "Frase actualizada exitosamente");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("status", "failure");
			response.put("message", "Frase no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteFrase(@PathVariable Integer id) {
		fraseService.deleteFrase(id);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "deleted");
		response.put("message", "Estado eliminado exitosamente");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
