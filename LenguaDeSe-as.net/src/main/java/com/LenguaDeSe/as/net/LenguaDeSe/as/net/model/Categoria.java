package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.*;

@Entity
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCategoria")
    private Integer idCategoria;

    @Column(name = "nombre",columnDefinition = "TEXT")
    private String nombre;

    public Categoria(){

    }

    public Categoria(Integer idCategoria,String nombre){
        this.idCategoria=idCategoria;
        this.nombre=nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
