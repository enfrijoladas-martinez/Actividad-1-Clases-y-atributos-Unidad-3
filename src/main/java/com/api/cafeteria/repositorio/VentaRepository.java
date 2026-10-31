package com.api.cafeteria.repositorio;

import com.api.cafeteria.modelo.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
