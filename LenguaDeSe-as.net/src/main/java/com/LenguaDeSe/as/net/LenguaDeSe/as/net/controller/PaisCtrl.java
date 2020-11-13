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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Pais;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.PaisService;

@RestController
@RequestMapping("/api/pais")
public class PaisCtrl {
	@Autowired
	private PaisService servPais;
	
	@GetMapping("")
	public ResponseEntity<Object> getPaises() {
		return new ResponseEntity<>(servPais.getPaises(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getPais(@PathVariable Integer id) {
		Pais pais = servPais.getPais(id);
		if (pais != null) {
			return new ResponseEntity<>(pais, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Pais no encontrado");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	@PostMapping("")
	public ResponseEntity<Object> createPais(@Valid @RequestBody Pais pais){
		servPais.createPais(pais);
			
			HashMap<String,String> response = new HashMap<>();
			response.put("status","success");
			response.put("message","Pais creado exitosamente");
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		}
	@PutMapping("{id}")
	public ResponseEntity<Object> updatePais(@Valid @RequestBody Pais pais){
		
		servPais.updatePais(pais);
			
			HashMap<String,String> response = new HashMap<>();
			response.put("status","success");
			response.put("message","Pais actuaizado exitosamente");
			return new ResponseEntity<>(response,HttpStatus.OK);
		}
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deletPais(@PathVariable Pais pais){
		servPais.deletePais(pais);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Pais eliminado exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}
