package com.example.entity;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int numerosala;

    @NotNull
    private int numerobutacas;

    private String tipo;

    public Sala() {

    }

    public Sala(int numerosala, int numerobutacas, String tipo) {
        this.numerosala = numerosala;
        this.numerobutacas = numerobutacas;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumerosala() {
        return numerosala;
    }

    public void setNumerosala(int numerosala) {
        this.numerosala = numerosala;
    }

    public int getNumerobutacas() {
        return numerobutacas;
    }

    public void setNumerobutacas(int numerobutacas) {
        this.numerobutacas = numerobutacas;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
