package com.examen.orellana.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RQTurno implements Serializable{
    private Integer numTurno; 
    private String cedulaCliente; 
    private String nombreCliente;
    private String codigoEjecutivo;
    private String nombreEjecutivo; 
    private Integer calificacion; 
}
