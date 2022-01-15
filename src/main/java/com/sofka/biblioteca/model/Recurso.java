package com.sofka.biblioteca.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "recursos")
public class Recurso {

    @Id
    private String id;
    private String nombre;
    private LocalDate ultimaFechaPrestamo;
    private Boolean disponible;
    private String tipo;
    private String tematica;

    public Recurso(String nombre, LocalDate ultimaFechaPrestamo, Boolean disponible, String tipo, String tematica) {
        this.nombre = nombre;
        this.ultimaFechaPrestamo = ultimaFechaPrestamo;
        this.disponible = disponible;
        this.tipo = tipo;
        this.tematica = tematica;
    }

    public Recurso(String id, String nombre, LocalDate ultimaFechaPrestamo, Boolean disponible, String tipo, String tematica) {
        this.id = id;
        this.nombre = nombre;
        this.ultimaFechaPrestamo = ultimaFechaPrestamo;
        this.disponible = disponible;
        this.tipo = tipo;
        this.tematica = tematica;
    }

    public Recurso() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getUltimaFechaPrestamo() {
        return ultimaFechaPrestamo;
    }

    public void setUltimaFechaPrestamo(LocalDate ultimaFechaPrestamo) {
        this.ultimaFechaPrestamo = ultimaFechaPrestamo;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }
}
