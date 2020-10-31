package com.LenguaDeSe.as.net.LenguaDeSe.as.net.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.services.UsuarioServices;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.*;

@RestController
public class UsuarioCtrl {

	@Autowired
	private UsuarioServices usuarioServices;
	
	@GetMapping("/usuario")
	public List <Usuario> getUsuarios() {
		return usuarioServices.getUsuarios();
	}
	
	@GetMapping("/usuario/{id}")
	public ResponseEntity <Object> getUsuario(@PathVariable int id) {
		return usuarioServices.getUsuario(id);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity <Object> createUsuario(@Valid @RequestBody Usuario usuario) {
		ResponseEntity<Object> savedUsuario = usuarioServices.createUsuario(usuario);
		return null;
	}
	
	@PutMapping("/usuario/{id}")
	public void updateUsuario(@Valid @RequestBody Usuario usuario, @PathVariable int id ) {
		usuarioServices.updateUsuario(id, usuario);
	}
	
	@DeleteMapping("/usuario/{id}")
	public void deleteUsuario( @PathVariable int id ) {
		usuarioServices.deleteUsuario(id);
	}
	
}
