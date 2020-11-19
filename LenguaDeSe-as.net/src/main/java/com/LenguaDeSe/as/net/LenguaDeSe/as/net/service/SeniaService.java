package com.LenguaDeSe.as.net.LenguaDeSe.as.net.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Senia;

public interface SeniaService {
	public abstract List<Senia> getSeniasByFiltro();
	public abstract Senia getSenia(Integer id);
	public abstract Senia createSenia(Senia senia) throws FileNotFoundException, IOException;
	public abstract Senia updateSenia(Senia senia);
	public abstract Senia deleteSenia(Integer id);

}
