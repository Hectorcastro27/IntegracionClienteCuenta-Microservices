package com.pruebatecnica.cuentamovimientoservice.Controller;


import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import com.pruebatecnica.cuentamovimientoservice.Entity.Movimiento;
import com.pruebatecnica.cuentamovimientoservice.Exceptions.CuentaNotFoundException;
import com.pruebatecnica.cuentamovimientoservice.Exceptions.SaldoInsuficienteException;
import com.pruebatecnica.cuentamovimientoservice.Repository.CuentaRepository;
import com.pruebatecnica.cuentamovimientoservice.Repository.MovimientoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    private final CuentaRepository cuentaRepository;
    private MovimientoRepository movimientoRepository;

    public MovimientoController(MovimientoRepository movimientoRepository, CuentaRepository cuentaRepository){
        this.movimientoRepository = movimientoRepository;
        this.cuentaRepository = cuentaRepository;
    }

    @GetMapping
    public List<Movimiento> getAllMovimientos(){
        return movimientoRepository.findAll();
    }

    @PostMapping
    public Movimiento createMovimiento(@RequestBody Movimiento movimiento){
        Cuenta cuenta = cuentaRepository.findById(movimiento.getCuenta().getId()).
                orElseThrow(()-> new IllegalArgumentException("Cuenta no encontrada"));
        if(movimiento.getTipoMovimiento().equals("retiro")&& cuenta.getSaldoInicial()<movimiento.getValor()){
            throw  new SaldoInsuficienteException("Saldo no disponible para realizar el retiro");
        }
        //logica para actualizar el saldo
        cuenta.setSaldoInicial(cuenta.getSaldoInicial()-movimiento.getValor());
        cuentaRepository.save(cuenta);

        return  movimientoRepository.save(movimiento);
    }

    @GetMapping("/{id}")
    public Movimiento getMovimientoById(@PathVariable Long id){
        //System.out.println("200"+"Movimiento no encontrada");
        return  movimientoRepository.findById(id).orElseThrow(()->new RuntimeException("Movimiento no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deleteMovimiento(@PathVariable Long id){
        if(!movimientoRepository.existsById(id)){
            throw  new CuentaNotFoundException("Movimiento no encontrdo con ID:"+id);
        }
        movimientoRepository.deleteById(id);
    }
}
