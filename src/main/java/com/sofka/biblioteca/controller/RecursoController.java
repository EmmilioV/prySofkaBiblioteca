package com.sofka.biblioteca.controller;

import com.sofka.biblioteca.dto.RecursoDto;
import com.sofka.biblioteca.service.RecursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController()
public class RecursoController {

    @Autowired
    private RecursoService service;

    @PostMapping("/saveRecurso")
    public RecursoDto guardarRecurso(@RequestBody RecursoDto recursoDto){
        return service.save(recursoDto);
    }

    @RequestMapping("/getAll")
    public List<RecursoDto> obtenerRecursos(){
        return service.getAll();
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Object> obtenerRecurso(@PathVariable String id){
        Objects.requireNonNull(id);
        return service.getRecurso(id);
    }

    @RequestMapping("/{id}/disponibilidad")
    public ResponseEntity<String> consultarDisponibilidad(@PathVariable String id){
        Objects.requireNonNull(id);
        return service.isDisponible(id);
    }

    @RequestMapping("/{id}/prestar")
    public ResponseEntity<String> prestarRecurso(@PathVariable String id){
        Objects.requireNonNull(id);
        return service.prestar(id);
    }

    @RequestMapping("/{id}/devolver")
    public ResponseEntity<String> devolverRecurso(@PathVariable String id){
        Objects.requireNonNull(id);
        return service.devolver(id);
    }

    @PutMapping("/edit")
    public ResponseEntity<RecursoDto> actualizarRecurso(@RequestBody RecursoDto recursoDto){
        return service.updateRecurso(recursoDto);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> eliminarRecurso(@PathVariable String id){
        Objects.requireNonNull(id);
        return service.deleteRecurso(id);
    }
}
