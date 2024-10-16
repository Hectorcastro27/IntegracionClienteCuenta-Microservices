package com.pruebatecnica.cuentamovimientoservice.Repository;

import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
