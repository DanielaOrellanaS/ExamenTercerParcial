package com.examen.orellana.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RSTurno implements Serializable {
    private String cedula; 
    private String nombreCompleto;
}
