package com.LenguaDeSe.as.net.LenguaDeSe.as.net.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.LenguaDeSe.as.net.LenguaDeSe.as.net.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{
	@Query(value="SELECT * FROM estado WHERE pais = :paisId", nativeQuery=true)
	List<Estado> findByPaisId(Integer paisId);
}
