package com.pruebatecnica.cuentamovimientoservice.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String numeeroCuenta;
    private String tipoCuenta;
    private Double saldoInicial;
    private Boolean estado;
}
