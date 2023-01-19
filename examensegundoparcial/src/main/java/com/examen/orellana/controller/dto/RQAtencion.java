package com.examen.orellana.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RQAtencion implements Serializable{
    private Integer numTurno; 
    private String codigoEjecutivo;
}
