package com.LenguaDeSe.as.net.LenguaDeSe.as.net.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Estado;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoCtrl {
	@Autowired
	private EstadoService servEstado;
	
	@GetMapping("")
	public ResponseEntity<Object> getEstados() {
		return new ResponseEntity<>(servEstado.getEstados(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getEstado(@PathVariable Integer id) {
		Estado estado = servEstado.getEstado(id);
		if (estado != null) {
			return new ResponseEntity<>(estado, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Estado no encontrado");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
}
