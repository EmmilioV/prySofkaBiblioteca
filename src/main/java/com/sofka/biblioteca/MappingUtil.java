package com.sofka.biblioteca;

import com.sofka.biblioteca.dto.RecursoDto;
import com.sofka.biblioteca.model.Recurso;

import java.util.Objects;

public class MappingUtil {

    public static Recurso MapperToRecurso(RecursoDto recursoDto){
        var recurso = new Recurso();
        if(!Objects.isNull(recursoDto.getId()))
            recurso.setId(recursoDto.getId());
        recurso.setNombre(recursoDto.getNombre());
        recurso.setUltimaFechaPrestamo(recursoDto.getUltimaFechaPrestamo());
        recurso.setDisponible(recursoDto.getDisponible());
        recurso.setTipo(recursoDto.getTipo());
        recurso.setTematica(recursoDto.getTematica());

        return recurso;
    }

    public static RecursoDto MapperToRecursoDto(Recurso recurso){
        var recursoDto = new RecursoDto();

        recursoDto.setId(recurso.getId());
        recursoDto.setNombre(recurso.getNombre());
        recursoDto.setUltimaFechaPrestamo(recurso.getUltimaFechaPrestamo());
        recursoDto.setDisponible(recurso.getDisponible());
        recursoDto.setTipo(recurso.getTipo());
        recursoDto.setTematica(recurso.getTematica());

        return recursoDto;
    }

}
