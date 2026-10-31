package com.api.cafeteria.controlador;

import com.api.cafeteria.comun.NoEncontradoException;
import com.api.cafeteria.modelo.Profesor;
import com.api.cafeteria.repositorio.ProfesorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/profesores")
public class ProfesorController {

    private final ProfesorRepository repositorio;

    public ProfesorController(ProfesorRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Profesor> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{numeroEmpleado}")
    public Profesor consultar(@PathVariable String numeroEmpleado) {
        return repositorio.findById(numeroEmpleado)
                .orElseThrow(() -> new NoEncontradoException("PROFESOR_NO_ENCONTRADO", "No existe el profesor con número de empleado: " + numeroEmpleado));
    }
}
