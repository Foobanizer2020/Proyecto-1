package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario = repoUsuario.findByEmail(email);
		// Si existe el usuario
		if(usuario != null) {
			List<GrantedAuthority> authorities = getUserAuthority(usuario.getTipo_usuario().getNombre_tipo_usuario());
			return buildUserForAuthentication(usuario, authorities);
		} else {
			throw new UsernameNotFoundException("Nombre de usuariuo no encontrado");
		}
	}

	

	private List<GrantedAuthority> getUserAuthority(String nombre_tipo_usuario) {
		Set<GrantedAuthority> roles = new HashSet<>();
		roles.add(new SimpleGrantedAuthority(nombre_tipo_usuario));
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles);
		
		return grantedAuthorities;
	}


	private UserDetails buildUserForAuthentication(Usuario usuario, List<GrantedAuthority> authorities) {
		return new org.springframework.security.core.userdetails.User(usuario.getEmail(), usuario.getPassword(), authorities);
	}
}