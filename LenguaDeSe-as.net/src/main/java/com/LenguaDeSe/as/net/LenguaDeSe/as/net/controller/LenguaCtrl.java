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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Lengua;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.LenguaService;

@RestController
@RequestMapping("/api/lengua")
public class LenguaCtrl {
	@Autowired
	private LenguaService servLengua;
	
	@GetMapping("")
	public ResponseEntity<Object> getLenguas() {
		return new ResponseEntity<>(servLengua.getLenguas(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getLengua(@PathVariable Integer id) {
		Lengua lengua = servLengua.getLengua(id);
		if (lengua != null) {
			return new ResponseEntity<>(lengua, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Lengua no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("")
	public ResponseEntity<Object> createLengua(@Valid @RequestBody Lengua lengua) {
		servLengua.createLengua(lengua);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "created");
		response.put("message", "Lengua guardada exitosamente.");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateLengua(@PathVariable Integer id, @Valid @RequestBody Lengua lengua) {
		lengua.setIdLengua(id);
		lengua = servLengua.updateLengua(lengua);
		HashMap<String, String> response = new HashMap<>();
		if (lengua != null) {
			response.put("status", "updated");
			response.put("message", "Lengua actualizada exitosamente");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("status", "failure");
			response.put("message", "Lengua no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteLengua(@PathVariable Integer id) {
		servLengua.deleteLengua(id);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "deleted");
		response.put("message", "Lengua eliminada exitosamente");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
