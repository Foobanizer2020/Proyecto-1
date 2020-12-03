package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.*;
public interface UsuarioServices {
	public abstract List<Usuario> getUsuarios();
	public abstract ResponseEntity<Object> getUsuario(int id);
	public abstract ResponseEntity<Object> createUsuario(Usuario usuario);
	public abstract void updateUsuario(int id, Usuario usiario);
	public abstract void deleteUsuario(int id);

	public abstract ResponseEntity<Object> registrarUsuario(Usuario usuario);
	public abstract UserDetails loadUserByUsername(String email);
	public abstract boolean resetPassword(String email);
}
