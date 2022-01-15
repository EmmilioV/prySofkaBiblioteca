package com.sofka.biblioteca.service;

import com.sofka.biblioteca.MappingUtil;
import com.sofka.biblioteca.dto.RecursoDto;
import com.sofka.biblioteca.model.Recurso;
import com.sofka.biblioteca.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecursoService {

    @Autowired
    private RecursoRepository repository;

    public RecursoDto save(RecursoDto recursoDto){
        return MappingUtil.MapperToRecursoDto(repository.save(MappingUtil.MapperToRecurso(recursoDto)));
    }

    public List<RecursoDto> getAll(){
        List<RecursoDto> recursos = new ArrayList<>();

        for (Recurso recurso: repository.findAll()) {
            recursos.add(MappingUtil.MapperToRecursoDto(recurso));
        }

        return recursos;
    }

    public ResponseEntity<Object> getRecurso(String id){
        Recurso recurso = repository.findById(id).orElse(null);
        if(recurso == null)
        {
            return ResponseEntity.badRequest().body("No existe el recurso en la bd");
        }
            return ResponseEntity.ok().body(MappingUtil.MapperToRecursoDto(recurso));
    }

    public ResponseEntity<RecursoDto> updateRecurso(RecursoDto recursoDto){
        return ResponseEntity.ok()
                .body(MappingUtil.MapperToRecursoDto(repository.save(MappingUtil.MapperToRecurso(recursoDto))));
    }

    public ResponseEntity<String> deleteRecurso(String id){
        if(repository.findById(id).isEmpty())
        {
            return ResponseEntity.badRequest().body("No existe el recurso en la bd");
        }
        repository.deleteById(id);
        return ResponseEntity.ok().body(" recurso eliminado con exito");
    }
}
