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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Estado;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.EstadoService;

@RestController
@RequestMapping("/api/estado")
public class EstadoCtrl {
	@Autowired
	private EstadoService servEstado;
	
	@GetMapping("/pais/{idPais}")
	public ResponseEntity<Object> getEstados(@PathVariable Integer idPais) {
		return new ResponseEntity<>(servEstado.getEstados(idPais), HttpStatus.OK);
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
	
	@PostMapping("")
	public ResponseEntity<Object> createEstado(@Valid @RequestBody Estado estado) {
		servEstado.createEstado(estado);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "created");
		response.put("message", "Estado guardado exitosamente.");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Object> updateEstado(@PathVariable Integer id, @Valid @RequestBody Estado estado) {
		estado.setIdEstado(id);
		estado = servEstado.updateEstado(estado);
		HashMap<String, String> response = new HashMap<>();
		if (estado != null) {
			response.put("status", "updated");
			response.put("message", "Estado actualizado exitosamente");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.put("status", "failure");
			response.put("message", "Estado no encontrado");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteEstado(@PathVariable Integer id) {
		servEstado.deleteEstado(id);
		HashMap<String, String> response = new HashMap<>();
		response.put("status", "deleted");
		response.put("message", "Estado eliminado exitosamente");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
