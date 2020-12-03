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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.*;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.UsuarioServices;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioCtrl {

	@Autowired
	private UsuarioServices usuarioServices;
	
	@GetMapping("")
	public List <Usuario> getUsuarios() {
		return usuarioServices.getUsuarios();
	}
	
	@GetMapping("{id}")
	public ResponseEntity <Object> getUsuario(@PathVariable int id) {
		return usuarioServices.getUsuario(id);
	}
	
	@PostMapping("")
	public ResponseEntity <Object> createUsuario(@Valid @RequestBody Usuario usuario) {
		usuarioServices.createUsuario(usuario);
		return null;
	}
	
	@PutMapping("{id}")
	public void updateUsuario(@Valid @RequestBody Usuario usuario, @PathVariable int id ) {
		usuarioServices.updateUsuario(id, usuario);
	}
	
	@DeleteMapping("{id}")
	public void deleteUsuario( @PathVariable int id ) {
		usuarioServices.deleteUsuario(id);
	}
}
