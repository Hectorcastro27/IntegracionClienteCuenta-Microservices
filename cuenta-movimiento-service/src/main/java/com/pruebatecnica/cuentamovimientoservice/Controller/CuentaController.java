package com.pruebatecnica.cuentamovimientoservice.Controller;


import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import com.pruebatecnica.cuentamovimientoservice.Exceptions.CuentaNotFoundException;
import com.pruebatecnica.cuentamovimientoservice.Repository.CuentaRepository;
import com.pruebatecnica.cuentamovimientoservice.Service.MessageProducer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.SessionStatus;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
public class CuentaController {

    private CuentaRepository cuentaRepository;
    private  MessageProducer messageProducer;

    public CuentaController(CuentaRepository cuentaRepository, MessageProducer messageProducer){
        this.cuentaRepository = cuentaRepository;
        this.messageProducer = messageProducer;
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
        return  cuentaRepository.findById(id)
                .orElseThrow(()->new CuentaNotFoundException("Cuenta no encontrado con ID:"+id));
    }

    @DeleteMapping("/{id}")
    public void deleteCuenta(@PathVariable Long id){
        if(!cuentaRepository.existsById(id)){
            throw  new CuentaNotFoundException("Cuenta no encontrdo con ID:"+id);
        }
          cuentaRepository.deleteById(id);
    }

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) {
        //Cuenta cuenta = new Cuenta();
        //cuenta.setId(1L);
        //cuenta.setTipoCuenta("Ahorro");
        //cuenta.setNumeeroCuenta("1234456643");
        messageProducer.sendMessage(message);
        //messageProducer.sendMessage(cuenta.toString());
    }
}
