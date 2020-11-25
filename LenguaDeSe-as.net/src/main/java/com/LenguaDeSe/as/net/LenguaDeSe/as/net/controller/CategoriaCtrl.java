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

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Categoria;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.CategoriaService;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaCtrl {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping("")
	public ResponseEntity<Object> getCategoria() {
		return new ResponseEntity<>(categoriaService.getCategorias(), HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getCategoria(@PathVariable Integer id) {
		Categoria categoria = categoriaService.getCategoria(id);
		if (categoria != null) {
			return new ResponseEntity<>(categoria, HttpStatus.OK);
		} else {
			HashMap<String, String> response = new HashMap<>();
			response.put("status", "failure");
			response.put("message", "Categoria no encontrada");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	@PostMapping("")
	public ResponseEntity<Object> createCategoria(@Valid @RequestBody Categoria categoria){
		categoriaService.createCategoria(categoria);
			HashMap<String,String> response = new HashMap<>();
			response.put("status","success");
			response.put("message","Categoria creada exitosamente");
			return new ResponseEntity<>(response,HttpStatus.CREATED);
		}
	@PutMapping("{id}")
	public ResponseEntity<Object> updateCategoria(@Valid @RequestBody Categoria categoria){
		
		categoriaService.updateCategoria(categoria);
			
			HashMap<String,String> response = new HashMap<>();
			response.put("status","success");
			response.put("message","Categoria actuaizada exitosamente");
			return new ResponseEntity<>(response,HttpStatus.OK);
			
		}
	@DeleteMapping("{id}")
	public ResponseEntity<Object> deleteCategoria(@PathVariable Integer id) {
		categoriaService.deleteCategoria(id);
		
		HashMap<String,String> response = new HashMap<>();
		response.put("status","success");
		response.put("message","Categoria eliminada exitosamente");
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	

}

