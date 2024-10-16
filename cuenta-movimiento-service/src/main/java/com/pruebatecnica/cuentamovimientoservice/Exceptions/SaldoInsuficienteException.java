package com.pruebatecnica.cuentamovimientoservice.Exceptions;

public class SaldoInsuficienteException extends  RuntimeException{
    public SaldoInsuficienteException(String mensaje){
        super(mensaje);
    }
}
