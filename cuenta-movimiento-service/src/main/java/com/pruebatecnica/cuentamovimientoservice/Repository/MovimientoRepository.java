package com.pruebatecnica.cuentamovimientoservice.Repository;

import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import com.pruebatecnica.cuentamovimientoservice.Entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {

}
