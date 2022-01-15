package com.sofka.biblioteca.dto;

import java.time.LocalDate;

public class RecursoDto {
    private String id;
    private String nombre;
    private LocalDate ultimaFechaPrestamo;
    private Boolean disponible;
    private String tipo;
    private String tematica;

    public RecursoDto() {
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
