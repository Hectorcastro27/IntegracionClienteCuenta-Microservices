package com.pruebatecnica.cuentamovimientoservice.Service;

import com.pruebatecnica.cuentamovimientoservice.Entity.Movimiento;
import com.pruebatecnica.cuentamovimientoservice.Repository.MovimientoRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MovimientoRepository movimientoRepository;

    public Movimiento registrarMovimiento(Movimiento movimiento,Long cuentaId){
        Movimiento savedMovimiento = movimientoRepository.save(movimiento);
        rabbitTemplate.convertAndSend("movimientos.exchange","movimiento.realizado",savedMovimiento);
        return savedMovimiento;
    }
}
