package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Lengua;

public interface LenguaService {
	public abstract List<Lengua> getLenguas();
	public abstract Lengua getLengua(Integer id);
	public abstract Lengua createLengua(Lengua lengua);
	public abstract Lengua updateLengua(Lengua lengua);
	public abstract Lengua deleteLengua(Integer id);
}
