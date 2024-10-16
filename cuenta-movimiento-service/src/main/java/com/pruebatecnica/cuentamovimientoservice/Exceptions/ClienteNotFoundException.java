package com.pruebatecnica.cuentamovimientoservice.Exceptions;

public class ClienteNotFoundException extends RuntimeException{
    public ClienteNotFoundException(String mensaje){
        super(mensaje);
    }
}
