package com.pruebatecnica.cuentamovimientoservice.Repository;

import com.pruebatecnica.cuentamovimientoservice.Entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
    //Metodo para obtener movimientos por  cuenta y en un rango de fechas
    //List<Movimiento> findByCuentaIdAndFechaBetween(Long cuentaId, LocalDateTime fechaInicio, LocalDateTime fechaFin);

}

