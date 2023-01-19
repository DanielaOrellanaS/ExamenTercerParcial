package com.examen.orellana.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.orellana.model.Cliente;

@Repository
public interface ClienteRepository extends MongoRepository<Cliente, String>{
    Optional<Cliente> findByCedula(String cedula);
}
