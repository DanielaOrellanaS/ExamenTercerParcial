package com.examen.orellana.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.orellana.model.Turno;

@Repository
public interface TurnoRepository extends MongoRepository<Turno, String>{
    Optional<Turno> findByNumTurno(Integer numTurno);
}
