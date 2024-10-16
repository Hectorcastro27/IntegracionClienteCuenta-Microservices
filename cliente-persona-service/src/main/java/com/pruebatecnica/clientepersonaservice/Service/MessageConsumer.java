package com.pruebatecnica.clientepersonaservice.Service;

import com.pruebatecnica.cuentamovimientoservice.Config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {
    @RabbitListener(queues = RabbitConfig.QUEUE_NAME)
    public void receiveMessage(String message) {
        System.out.println("Mensaje recibido: " + message);
        // Aquí puedes agregar la lógica para procesar el mensaje
    }
}
