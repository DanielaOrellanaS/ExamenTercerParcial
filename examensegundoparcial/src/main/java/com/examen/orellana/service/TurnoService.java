package com.examen.orellana.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.examen.orellana.errors.RSRuntimeException;
import com.examen.orellana.model.Cliente;
import com.examen.orellana.model.Ejecutivo;
import com.examen.orellana.model.Turno;
import com.examen.orellana.repository.ClienteRepository;
import com.examen.orellana.repository.EjecutivoRepository;
import com.examen.orellana.repository.TurnoRepository;
import com.examen.orellana.utils.RSCode;

@Service
public class TurnoService {
    private final TurnoRepository turnoRepository;
    private final ClienteRepository clienteRepository;
    private final EjecutivoRepository ejecutivoRepository;

    public TurnoService(TurnoRepository turnoRepository, ClienteRepository clienteRepository, EjecutivoRepository ejecutivoRepository) {
        this.turnoRepository = turnoRepository;
        this.clienteRepository = clienteRepository;
        this.ejecutivoRepository = ejecutivoRepository; 
    }

    public void crearTurno(String cedula, String nombreCompleto, Turno turno) {
        Optional<Cliente> optCliente = this.clienteRepository.findByCedula(cedula);
        Integer numTurno = 0;
        try {
            if (optCliente.isPresent()) {
                turno.setCedulaCliente(cedula);
                turno.setNombreCliente(nombreCompleto);
                if (turno.getNumTurno() >= numTurno) {
                    turno.setNumTurno(numTurno++);
                }
                this.turnoRepository.save(turno);
            } else {
                throw new RSRuntimeException("Cliente no encontrado", RSCode.NOT_FOUND);
            }
        } catch (Exception e) {
            throw new RSRuntimeException("Failure", RSCode.BAD_REQUEST);
        }
    }

    public Turno iniciarAtencion(Integer numTurno, String idEjecutivo, Turno turno) {
        try {
            Optional<Ejecutivo> optEjecutivo = this.ejecutivoRepository.findById(idEjecutivo);
            if (optEjecutivo.isPresent()) {
                Ejecutivo ejecutivo = optEjecutivo.get();
                turno.setInicioAtencion(LocalDateTime.now());
                turno.setCodigoEjecutivo(ejecutivo.getId());
                turno.setNombreEjecutivo(ejecutivo.getNombreCompleto());
            }
            this.turnoRepository.save(turno);
        } catch (Exception e) {
            throw new RSRuntimeException("Ejecutivo no encontrado", RSCode.NOT_FOUND);
        }
    }

    public void finAtencion(Integer numTurno) {
        Optional<Turno> objTurno = this.turnoRepository.findByNumTurno(numTurno);
        if (objTurno.isPresent()) {
            Turno turno = objTurno.get();
            turno.setFinAtencion(LocalDateTime.now());
        } else {
            throw new RSRuntimeException("Turno no encontrado", RSCode.NOT_FOUND);
        }
    }

}
