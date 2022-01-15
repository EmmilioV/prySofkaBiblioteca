package com.sofka.biblioteca.service;

import com.sofka.biblioteca.MappingUtil;
import com.sofka.biblioteca.dto.RecursoDto;
import com.sofka.biblioteca.model.Recurso;
import com.sofka.biblioteca.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    public ResponseEntity<String> isDisponible(String id){
        Recurso recurso = repository.findById(id).orElse( null);

        if(doesNotExists(recurso))
            return ResponseEntity.badRequest().body("No existe el recurso en la bd");

        if(!recurso.getDisponible())
            return ResponseEntity.ok().body("El recurso no está disponible, la fecha de prestamo actual del ultimo ejemplar es: " + recurso.getUltimaFechaPrestamo());

        return ResponseEntity.ok().body("El recurso está disponible");
    }

    public ResponseEntity<String> prestar(String id){
        Recurso recurso = repository.findById(id).orElse( null);

        if(doesNotExists(recurso))
            return ResponseEntity.badRequest().body("No existe el recurso en la bd");

        if(!recurso.getDisponible())
            return ResponseEntity.ok().body("El recurso no está disponible para ser prestado, la fecha de prestamo actual del ultimo ejemplar es: " + recurso.getUltimaFechaPrestamo());

        recurso.setDisponible(false);
        recurso.setUltimaFechaPrestamo(LocalDate.now());
        repository.save(recurso);
        return ResponseEntity.ok().body("El recurso ha sido prestado exitosamente");
    }

    public ResponseEntity<Object> getRecurso(String id){
        Recurso recurso = repository.findById(id).orElse(null);
        if(doesNotExists(recurso))
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

    private boolean doesNotExists(Recurso recurso) {
        return recurso == null;
    }
}
