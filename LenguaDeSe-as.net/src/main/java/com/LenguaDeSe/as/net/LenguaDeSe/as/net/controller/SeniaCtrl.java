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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Senia;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.SeniaService;

@RestController
@RequestMapping("api/senia")
public class SeniaCtrl {
	@Autowired
	private SeniaService seniaService;
	
	@GetMapping("")
	public ResponseEntity<Object> getSenias() {
		return new ResponseEntity<>(seniaService.getSeniasByFiltro(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getSenia(@PathVariable Integer id) {
		Senia senia = seniaService.getSenia(id); 
		if (senia != null) {
			return new ResponseEntity<>(senia, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Senia no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createSenia(@Valid @RequestBody Senia senia) {
		HashMap<String, String> response = new HashMap<>();
		try {
			seniaService.createSenia(senia);
		} catch (Exception e) {
			response.put("status", "failure");
			response.put("message", "Error al guardar la senia.");
			response.put("exception", e.getMessage());
			return new ResponseEntity<>(response, HttpStatus.valueOf(500));
		}
		response.put("status", "created");
		response.put("message", "Senia guardada exitosamente.");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateSenia(@PathVariable Integer id, @RequestBody Senia senia) {
		senia.setIdSenias(id);
		senia = seniaService.updateSenia(senia);
		HashMap<String, String> response = new HashMap<>();
		if (senia != null) {
			response.put("status", "updated");
			response.put("message", "Senia actualizada exitosamente");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("status", "failure");
			response.put("message", "Senia no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteSenia(@PathVariable Integer id) {
		seniaService.deleteSenia(id);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "deleted");
		response.put("message", "Senia eliminada exitosamente");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
