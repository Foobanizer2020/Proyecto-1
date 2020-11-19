package com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
