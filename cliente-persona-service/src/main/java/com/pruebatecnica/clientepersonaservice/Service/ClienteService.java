package com.pruebatecnica.clientepersonaservice.Service;

import com.pruebatecnica.clientepersonaservice.Entity.Cliente;
import com.pruebatecnica.clientepersonaservice.Exceptions.ClienteNotFoundException;
import com.pruebatecnica.clientepersonaservice.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos(){
        return clienteRepository.findAll();
    }

    public Cliente obtenerPorId(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(()->new ClienteNotFoundException("Cliente no encontrado con ID"+id));
    }
}
