package com.examen.orellana.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
@Document(collection = "cliente")
public class Cliente {
    @Id 
    private String id; 

    private String cedula; 
    private String nombres;
    private String apellidos;
    private String nombreCompleto;  
    private Date fechaNacimiento; 
    private String direccionPrincipal; 
    private String telefono; 
    private String correo; 
    private List<Cuentas> cuentas;

    @Version 
    private Long version; 
}
