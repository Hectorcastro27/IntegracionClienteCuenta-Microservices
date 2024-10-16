package com.pruebatecnica.clientepersonaservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="clientes")
public class Cliente extends Persona{
   @Column(unique = true) //Asegura que clienteId sea unico
    private String clienteId;

    private String password;
    private boolean estado;

}
