package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Estado;
import com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository.EstadoRepository;

@Service
public class EstadoServiceImp implements EstadoService{

	@Autowired
	private EstadoRepository repoEstado;

	@Override
	public List<Estado> getEstados() {
		return repoEstado.findAll();
	}

	@Override
	public Estado getEstado(Integer id) {
		Optional<Estado> o = repoEstado.findById(id);
		if (o.isPresent()) {
			return o.get();
		} else {
			return null;
		}
	}

	@Override
	public Estado createEstado(Estado estado) {
		return repoEstado.save(estado);
	}

	@Override
	public Estado updateEstado(Estado estado) {
		if (this.getEstado(estado.getIdEstado()) != null) { 
			return repoEstado.save(estado);
		} else {
			return null;
		}
	}

	@Override
	public Estado deleteEstado(Estado estado) {
		estado = this.getEstado(estado.getIdEstado());
		repoEstado.delete(estado);
		return estado;
	}	
}
