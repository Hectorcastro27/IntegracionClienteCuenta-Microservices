package com.pruebatecnica.cuentamovimientoservice.Controller;


import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import com.pruebatecnica.cuentamovimientoservice.Entity.Movimiento;
import com.pruebatecnica.cuentamovimientoservice.Repository.CuentaRepository;
import com.pruebatecnica.cuentamovimientoservice.Repository.MovimientoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {
    private MovimientoRepository movimientoRepository;

    public MovimientoController(MovimientoRepository movimientoRepository){
        this.movimientoRepository = movimientoRepository;
    }

    @GetMapping
    public List<Movimiento> getAllMovimientos(){
        return movimientoRepository.findAll();
    }

    @PostMapping
    public Movimiento createMovimiento(@RequestBody Movimiento movimiento){
        return  movimientoRepository.save(movimiento);
    }

    @GetMapping("/{id}")
    public Movimiento getMovimientoById(@PathVariable Long id){
        System.out.println("200"+"Movimiento no encontrada");
        return  movimientoRepository.findById(id).orElseThrow(()->new RuntimeException("Movimiento no encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deleteMovimiento(@PathVariable Long id){
        movimientoRepository.deleteById(id);
    }
}
