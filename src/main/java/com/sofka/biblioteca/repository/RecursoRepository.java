package com.sofka.biblioteca.repository;

import com.sofka.biblioteca.model.Recurso;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RecursoRepository extends MongoRepository<Recurso, String> {
    List<Recurso> findAllByTipo(String tipo);
    List<Recurso> findAllByTematica(String tematica);
}
