package com.examen.orellana.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examen.orellana.service.TurnoService;

@RequestMapping("/api/turno")
@RestController
public class TurnoController {
    private final TurnoService turnoService;

    public TurnoController(TurnoService turnoService) {
        this.turnoService = turnoService;
    } 
    
    @PostMapping 
    public ResponseEntity<RSTurno> generarTurno(
        @RequestBody RQTurno
    )
}
