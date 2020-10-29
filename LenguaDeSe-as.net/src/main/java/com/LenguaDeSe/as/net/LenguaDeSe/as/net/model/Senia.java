package com.LenguaDeSe.as.net.LenguaDeSe.as.net.model;

import javax.persistence.*;

@Entity
public class Senia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idSenias")
    private Integer idSenias;

    @Column(name="gif",columnDefinition = "TEXT")
    private String gif;

    public Senia(){

    }

    public Senia(Integer idSenias,String gif){
        this.gif=gif;
        this.idSenias=idSenias;
    }

    public Integer getIdSenias() {
        return idSenias;
    }

    public String getGif() {
        return gif;
    }

    public void setGif(String gif) {
        this.gif = gif;
    }

    public void setIdSenias(Integer idSenias) {
        this.idSenias = idSenias;
    }
}
