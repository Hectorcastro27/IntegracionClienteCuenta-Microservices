package com.pruebatecnica.clientepersonaservice.Controller;

import ch.qos.logback.core.net.server.Client;
import com.pruebatecnica.clientepersonaservice.Entity.Cliente;
import com.pruebatecnica.clientepersonaservice.Entity.Persona;
import com.pruebatecnica.clientepersonaservice.Exceptions.ClienteNotFoundException;
import com.pruebatecnica.clientepersonaservice.Repository.ClienteRepository;
import com.pruebatecnica.clientepersonaservice.Service.ClienteService;
import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import com.pruebatecnica.cuentamovimientoservice.Exceptions.CuentaNotFoundException;
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

    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Long id){
        return  clienteRepository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado con ID:"+id));
    }

    @PostMapping
    public  Cliente crearCliente(@RequestBody Cliente cliente){
            return clienteRepository.save(cliente);
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable Long id){
        if(!clienteRepository.existsById(id)){
            throw  new ClienteNotFoundException("Cliente no encontrdo con ID:"+id);
        }
        clienteRepository.deleteById(id);
    }

}
