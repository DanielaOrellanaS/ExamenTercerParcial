package com.examen.orellana.controller.dto;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import com.examen.orellana.model.Cuentas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RQCliente implements Serializable{
    private String cedula; 
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento; 
    private String direccionPrincipal; 
    private String telefono; 
    private String correo; 
    private List<Cuentas> cuentas;
}
