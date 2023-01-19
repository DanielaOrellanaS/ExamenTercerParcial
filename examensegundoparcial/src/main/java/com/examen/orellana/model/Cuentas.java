package com.examen.orellana.model;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Cuentas {
    private String numeroCuenta; 
    private String tipoCuenta; 
    private BigDecimal saldoPromedio; 
}
