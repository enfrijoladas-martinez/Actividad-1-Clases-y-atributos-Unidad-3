package com.api.cafeteria;

import com.api.cafeteria.modelo.Estudiante;
import com.api.cafeteria.modelo.Producto;
import com.api.cafeteria.modelo.Profesor;
import com.api.cafeteria.modelo.Venta;
import com.api.cafeteria.repositorio.EstudianteRepository;
import com.api.cafeteria.repositorio.ProductoRepository;
import com.api.cafeteria.repositorio.ProfesorRepository;
import com.api.cafeteria.repositorio.VentaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class DatosIniciales implements CommandLineRunner {

    private final ProductoRepository productos;
    private final VentaRepository ventas;
    private final EstudianteRepository estudiantes;
    private final ProfesorRepository profesores;

    public DatosIniciales(ProductoRepository productos, VentaRepository ventas,
                          EstudianteRepository estudiantes, ProfesorRepository profesores) {
        this.productos = productos;
        this.ventas = ventas;
        this.estudiantes = estudiantes;
        this.profesores = profesores;
    }

    @Override
    public void run(String... args) {
        if (productos.count() > 0) {
            return;
        }
        productos.saveAll(List.of(
                new Producto("Café americano", new BigDecimal("35.00"), Producto.Categoria.BEBIDA),
                new Producto("Torta de jamón", new BigDecimal("55.00"), Producto.Categoria.ALIMENTO),
                new Producto("Galletas de avena", new BigDecimal("20.00"), Producto.Categoria.SNACK),
                new Producto("Pay de queso", new BigDecimal("40.00"), Producto.Categoria.POSTRE)));

        estudiantes.saveAll(List.of(
                new Estudiante("202400123", "Ana García", "ana.garcia@universidad.mx"),
                new Estudiante("202400456", "Luis Pérez", "luis.perez@universidad.mx")));

        profesores.saveAll(List.of(
                new Profesor("E-1045", "Juan López", "juan.lopez@universidad.mx"),
                new Profesor("E-2210", "María Torres", "maria.torres@universidad.mx")));

        ventas.saveAll(List.of(
                new Venta(LocalDateTime.of(2026, 10, 30, 9, 15), new BigDecimal("90.00"), Venta.MetodoPago.EFECTIVO),
                new Venta(LocalDateTime.of(2026, 10, 30, 13, 40), new BigDecimal("40.00"), Venta.MetodoPago.TARJETA)));
    }
}
