package com.api.cafeteria.modelo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@JsonPropertyOrder({"folio", "fecha", "total", "metodoPago"})
public class Venta {

    public enum MetodoPago { EFECTIVO, TARJETA, TRANSFERENCIA }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folio;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private MetodoPago metodoPago;

    protected Venta() {
    }

    public Venta(LocalDateTime fecha, BigDecimal total, MetodoPago metodoPago) {
        this.fecha = fecha;
        this.total = total;
        this.metodoPago = metodoPago;
    }

    public Long getFolio() { return folio; }
    public LocalDateTime getFecha() { return fecha; }
    public BigDecimal getTotal() { return total; }
    public MetodoPago getMetodoPago() { return metodoPago; }
}
