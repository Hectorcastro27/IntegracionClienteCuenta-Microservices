package com.pruebatecnica.clientepersonaservice.Service;

import com.pruebatecnica.cuentamovimientoservice.Entity.Movimiento;
import lombok.Data;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Data
public class MovimientoListener {

    @RabbitListener(queues = "movimientos.queue")
    public void recibirMovimiento(Movimiento movimineto){
      System.out.println("Movimiento recibido:"+movimineto);
    }
}
