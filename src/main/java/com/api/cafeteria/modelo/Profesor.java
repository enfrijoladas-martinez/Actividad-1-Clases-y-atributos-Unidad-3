package com.api.cafeteria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profesor {

    @Id
    @Column(length = 10)
    private String numeroEmpleado;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String correo;

    protected Profesor() {
    }

    public Profesor(String numeroEmpleado, String nombre, String correo) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNumeroEmpleado() { return numeroEmpleado; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
}
