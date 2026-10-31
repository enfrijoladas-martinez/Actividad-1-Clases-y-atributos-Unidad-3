package com.api.cafeteria.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Estudiante {

    @Id
    @Column(length = 9)
    private String matricula;

    @Column(nullable = false, length = 80)
    private String nombre;

    @Column(nullable = false, length = 100)
    private String correo;

    protected Estudiante() {
    }

    public Estudiante(String matricula, String nombre, String correo) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getMatricula() { return matricula; }
    public String getNombre() { return nombre; }
    public String getCorreo() { return correo; }
}
