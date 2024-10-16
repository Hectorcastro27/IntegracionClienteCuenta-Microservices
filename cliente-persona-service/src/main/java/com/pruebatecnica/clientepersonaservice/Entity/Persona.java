package com.pruebatecnica.clientepersonaservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@MappedSuperclass
@Data
@Inheritance(strategy = InheritanceType.JOINED) // Estrategia de herencia
public abstract class Persona{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String genero;
    private int edad;
    private String identificacion;
    private String direccion;
    private String telefono;

}
