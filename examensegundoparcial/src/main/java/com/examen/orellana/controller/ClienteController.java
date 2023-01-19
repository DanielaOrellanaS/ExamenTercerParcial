package com.examen.orellana.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.orellana.controller.dto.RSClient;
import com.examen.orellana.errors.RSRuntimeException;
import com.examen.orellana.model.Cliente;
import com.examen.orellana.service.ClienteService;

@RequestMapping("/api/cliente")
@RestController
public class ClienteController {
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    } 
    
@GetMapping(value = "/{cedula}")
public ResponseEntity<Cliente> obtenerCliente(@PathVariable("cedula") String cedula){
    try{
        Cliente cliente = this.clienteService.obtenerCliente(cedula);
        return ResponseEntity.ok().body(cliente);
    } catch (RSRuntimeException e) {
        return ResponseEntity.badRequest().build();
    } catch (Exception e) {
        return ResponseEntity.internalServerError().build();
    }
}
    
}
