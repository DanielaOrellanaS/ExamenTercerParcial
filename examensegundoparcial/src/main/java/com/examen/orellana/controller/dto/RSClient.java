package com.examen.orellana.controller.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RSClient implements Serializable{
    private String cedula; 
    private String nombresCompletos; 
}
