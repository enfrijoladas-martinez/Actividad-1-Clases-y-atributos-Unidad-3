package com.api.cafeteria.controlador;

import com.api.cafeteria.comun.NoEncontradoException;
import com.api.cafeteria.modelo.Venta;
import com.api.cafeteria.repositorio.VentaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/ventas")
public class VentaController {

    private final VentaRepository repositorio;

    public VentaController(VentaRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Venta> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{folio}")
    public Venta consultar(@PathVariable Long folio) {
        return repositorio.findById(folio)
                .orElseThrow(() -> new NoEncontradoException("VENTA_NO_ENCONTRADA", "No existe la venta con folio: " + folio));
    }
}
