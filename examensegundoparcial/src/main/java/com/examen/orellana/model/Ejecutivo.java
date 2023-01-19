package com.examen.orellana.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "ejecutivo")
public class Ejecutivo {
    @Id 
    private String id; 

    private String codigoCliente; 
    private String nombreCompleto; 
    private Integer numeroEscritorio; 

    @Version 
    private Long version; 
}
