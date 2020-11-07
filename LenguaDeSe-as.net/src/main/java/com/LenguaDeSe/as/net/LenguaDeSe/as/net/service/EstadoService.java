package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Estado;

public interface EstadoService {
	public abstract List<Estado> getEstados(Integer idPais);
	public abstract Estado getEstado(Integer id);
	public abstract Estado createEstado(Estado estado);
	public abstract Estado updateEstado(Estado estado);
	public abstract Estado deleteEstado(Integer id);
}
