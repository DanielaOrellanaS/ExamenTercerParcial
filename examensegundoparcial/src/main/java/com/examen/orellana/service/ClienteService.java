package com.examen.orellana.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.orellana.errors.RSRuntimeException;
import com.examen.orellana.model.Cliente;
import com.examen.orellana.repository.ClienteRepository;
import com.examen.orellana.utils.RSCode;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public Cliente obtenerCliente(String cedula){
        Optional<Cliente> optCliente = this.clienteRepository.findByCedula(cedula);
        if(optCliente.isPresent()){
            Cliente cliente = optCliente.get();
            return cliente; 
        } else {
            throw new RSRuntimeException("Client no encontrado", RSCode.NOT_FOUND);
        }
    }

}
