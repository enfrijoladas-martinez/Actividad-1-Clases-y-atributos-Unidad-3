package com.api.cafeteria.controlador;

import com.api.cafeteria.comun.NoEncontradoException;
import com.api.cafeteria.modelo.Estudiante;
import com.api.cafeteria.repositorio.EstudianteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estudiantes")
public class EstudianteController {

    private final EstudianteRepository repositorio;

    public EstudianteController(EstudianteRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Estudiante> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{matricula}")
    public Estudiante consultar(@PathVariable String matricula) {
        return repositorio.findById(matricula)
                .orElseThrow(() -> new NoEncontradoException("ESTUDIANTE_NO_ENCONTRADO", "No existe el estudiante con matrícula: " + matricula));
    }
}
