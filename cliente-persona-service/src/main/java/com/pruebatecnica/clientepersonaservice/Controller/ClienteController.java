package com.pruebatecnica.clientepersonaservice.Controller;

import ch.qos.logback.core.net.server.Client;
import com.pruebatecnica.clientepersonaservice.Entity.Cliente;
import com.pruebatecnica.clientepersonaservice.Entity.Persona;
import com.pruebatecnica.clientepersonaservice.Repository.ClienteRepository;
import com.pruebatecnica.clientepersonaservice.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> obtenerClientes(){
        return clienteRepository.findAll();
    }

    @PostMapping
    public  Cliente crearCliente(@RequestBody Cliente cliente){
            return clienteRepository.save(cliente);
    }

}
