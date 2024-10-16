package com.pruebatecnica.cuentamovimientoservice.Exceptions;

public class CuentaNotFoundException extends RuntimeException{
    public CuentaNotFoundException(String mensaje){
        super(mensaje);
    }
}
