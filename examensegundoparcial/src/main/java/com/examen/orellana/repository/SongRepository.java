package com.examen.orellana.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.examen.orellana.model.Song;

@Repository
//La clase de la que estoy creando y el tipo de dato del ID 
public interface SongRepository extends MongoRepository<Song, String>{
    public Optional<Song> findByTitle(String song); 
}
