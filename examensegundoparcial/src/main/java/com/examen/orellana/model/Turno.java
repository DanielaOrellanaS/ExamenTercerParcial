package com.examen.orellana.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "turno")
public class Turno {

    @Id
    private String id; 

    private Integer numTurno; 
    private String cedulaCliente; 
    private String nombreCliente;
    private String codigoEjecutivo;
    private String nombreEjecutivo; 
    private LocalDateTime generacion; 
    private LocalDateTime inicioAtencion;
    private LocalDateTime finAtencion; 
    private Integer calificacion; 

    @Version 
    private Long version; 
}
