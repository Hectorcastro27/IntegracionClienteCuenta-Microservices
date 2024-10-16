package com.pruebatecnica.cuentamovimientoservice.Controller;


import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import com.pruebatecnica.cuentamovimientoservice.Repository.CuentaRepository;
import com.pruebatecnica.cuentamovimientoservice.Service.MessageProducer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    //private final MessageConsumer messageConsumer;
    private CuentaRepository cuentaRepository;
    private  MessageProducer messageProducer;

    public CuentaController(CuentaRepository cuentaRepository, MessageProducer messageProducer){
        this.cuentaRepository = cuentaRepository;
        this.messageProducer = messageProducer;
        //this.messageConsumer = messageConsumer;
    }

    @GetMapping
    public List<Cuenta> getAllCuentas(){
        return cuentaRepository.findAll();
    }

    @PostMapping
    public Cuenta createCuenta(@RequestBody Cuenta cuenta){
        return  cuentaRepository.save(cuenta);
    }

    @GetMapping("/{id}")
    public Cuenta getCuentaById(@PathVariable Long id){
        return  cuentaRepository.findById(id).orElseThrow(()->new RuntimeException("Cuenta no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable Long id){
          cuentaRepository.deleteById(id);
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1L);
        cuenta.setTipoCuenta("Ahorro");
        cuenta.setNumeeroCuenta("1234456643");
        messageProducer.sendMessage(cuenta.toString());
    }
/*
    @GetMapping("/read")
    public String readMessage() {
        return messageConsumer.receiveMessage("message");
    }

 */
}
