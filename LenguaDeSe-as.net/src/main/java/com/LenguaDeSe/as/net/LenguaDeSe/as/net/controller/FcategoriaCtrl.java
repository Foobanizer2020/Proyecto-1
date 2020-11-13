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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Fcategoria;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.FcategoriaService;



@RestController
@RequestMapping("/api/fcategoria")
public class FcategoriaCtrl {
	
	@Autowired
	private FcategoriaService fcategoriaService;
	
	
	@GetMapping("")
	public ResponseEntity<Object> getFcategoria() {
		return new ResponseEntity<>(fcategoriaService.getFcategorias(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getFcategoria(@PathVariable Integer id) {
		Fcategoria fcategoria = fcategoriaService.getFcategoria(id);
		if (fcategoria != null) {
			return new ResponseEntity<>(fcategoria, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "fcategoria no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	@PostMapping("")
	public ResponseEntity<Object> createFcategoria(@Valid @RequestBody Fcategoria fcategoria){
		fcategoriaService.createFcategoria(fcategoria);
			HashMap<String,String> response = new HashMap<>();
			response.put("status","success");
			response.put("message","Fcategoria creada exitosamente");
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		}
	@PutMapping("{id}")
	public ResponseEntity<Object> updateFcategoria(@Valid @RequestBody Fcategoria fcategoria){
		
		fcategoriaService.updateFcategoria(fcategoria);
			
			HashMap<String,String> response = new HashMap<>();
			response.put("status","success");
			response.put("message","Fcategoria actuaizada exitosamente");
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		}
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteFcategoria(@PathVariable Integer id) {
		fcategoriaService.deleteFcategoria(id);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Fcategoria eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}