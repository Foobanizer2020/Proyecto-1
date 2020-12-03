package com.LenguaDeSe.as.net.LenguaDeSe.as.net.controller;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.config.JwtTokenProvider;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.AuthenticationBody;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Usuario;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.UsuarioRepository;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.service.UsuarioServices;

@RestController
@RequestMapping("/api/autenticacion")
public class AuthenticationController {
	
	@Autowired
	AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;
	
	@Autowired
	UsuarioRepository users;
	
	@Autowired
	UsuarioServices usuarios;
	
	@SuppressWarnings("rawtypes")
	@PostMapping("/login")
	public ResponseEntity login(@RequestBody AuthenticationBody datos) {
		try {
			String email = datos.getEmail();
			Usuario usuario = this.users.findByEmail(email);
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, datos.getPassword()));
			String token = jwtTokenProvider.createToken(email, usuario.getIdUsuario(), usuario.getTipo_usuario());
			
			Map<Object, Object> modelo = new HashMap<>();
            modelo.put("token", token);
            
			return ok(modelo);
		} catch (AuthenticationException e) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Credenciales inválidas. Verifica la información");
		}		
	}
	
    @SuppressWarnings("rawtypes")
    @PostMapping("/registro")
    public ResponseEntity register(@RequestBody Usuario usuario) {
    	usuario.setId_tipo_usuario(1);
        return usuarios.registrarUsuario(usuario);
    }
    
    @PostMapping("/recuperacion")
    public ResponseEntity<Object> restorePassword(@RequestBody AuthenticationBody data) {
    	Map<String, String> response = new HashMap<>();
    	if(usuarios.resetPassword(data.getEmail())) {
    		response.put("status", "success");
    		response.put("message", "Se restableció la contraseña y se envió un email");
    		return new ResponseEntity<>(response, HttpStatus.OK);
    	} 
		response.put("status", "failure");
		response.put("message", "Error al reestablecer la contraseña.");
		return new ResponseEntity<>(response, HttpStatus.valueOf(500));
    	
    }
}