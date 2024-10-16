package com.pruebatecnica.clientepersonaservice.Exception;

public class ClienteNotFoundException extends RuntimeException{
    public  ClienteNotFoundException(String mensaje){
        super(mensaje);
    }
}
