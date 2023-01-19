package com.examen.orellana.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EjecutivoRepository extends MongoRepository<EjecutivoRepository, String>{
    
}
