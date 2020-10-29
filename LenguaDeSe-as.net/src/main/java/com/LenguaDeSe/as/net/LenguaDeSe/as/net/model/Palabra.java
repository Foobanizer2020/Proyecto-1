package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Palabra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPalabra")
    private Integer idPalabra;

    @Column(name="nombre",columnDefinition = "TEXT")
    private String nombre;

    @Column(name = "contextoSenia",columnDefinition = "TEXT")
    private String contextoSenia;

    @Column(name="definicion",columnDefinition = "TEXT")
    private String definicion;

    @ManyToOne
    @JoinColumn(name="categoria")
    private Categoria categoria;

    public Palabra(){

    }

    public Palabra(Integer idPalabra,String nombre,String contextoSenia,String definicion,Categoria categoria){
        this.categoria=categoria;
        this.contextoSenia=contextoSenia;
        this.definicion=definicion;
        this.nombre=nombre;
        this.idPalabra=idPalabra;
    }
    public Integer getIdPalabra() {
        return idPalabra;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContextoSenia() {
        return contextoSenia;
    }

    public String getDefinicion() {
        return definicion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setIdPalabra(Integer idPalabra) {
        this.idPalabra = idPalabra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContextoSenia(String contextoSenia) {
        this.contextoSenia = contextoSenia;
    }

    public void setDefinicion(String definicion) {
        this.definicion = definicion;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
