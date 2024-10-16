package com.pruebatecnica.clientepersonaservice.Exceptions;

public class ClienteNotFoundException extends RuntimeException{
    public  ClienteNotFoundException(String mensaje){
        super(mensaje);
    }
}
