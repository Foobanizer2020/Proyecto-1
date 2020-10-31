package com.LenguaDeSe.as.net.LenguaDeSe.as.net.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Usuario;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.UsuarioRepository;

@Service
public class UsuarioServicesImp implements UsuarioServices {

	@Autowired
	private UsuarioRepository repoUsuario;
	
	public List<Usuario> getUsuarios(){
		return repoUsuario.findAll();
	}
	
	public ResponseEntity<Object> getUsuario(int id){
		return new ResponseEntity<>(repoUsuario.findById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<Object> createUsuario(Usuario usuario){
		return new ResponseEntity<>(repoUsuario.save(usuario), HttpStatus.OK);
	}
	
	public void updateUsuario(int id, Usuario usuario) {
		repoUsuario.save(usuario);
	}
	
	public void deleteUsuario(int id) {
		repoUsuario.deleteById(id);
	}
}