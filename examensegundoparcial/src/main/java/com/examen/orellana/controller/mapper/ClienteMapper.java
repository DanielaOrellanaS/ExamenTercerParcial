package com.examen.orellana.controller.mapper;

import com.examen.orellana.controller.dto.RSClient;
import com.examen.orellana.model.Cliente;

public class ClienteMapper {
    public static RSClient map(Cliente client){
        return RSClient.builder()
        .cedula(client.getCedula())
        .nombresCompletos(client.getNombreCompleto())
        .build();
    }
}
