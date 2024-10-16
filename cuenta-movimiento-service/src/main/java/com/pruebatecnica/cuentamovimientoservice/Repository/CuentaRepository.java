package com.pruebatecnica.cuentamovimientoservice.Repository;

import com.pruebatecnica.cuentamovimientoservice.Entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
    //metodo para obtener cuentas por ID del cliente
    //List<Cuenta> findByClienteId(Long clienteId);
}
