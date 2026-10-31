package com.api.cafeteria.controlador;

import com.api.cafeteria.comun.NoEncontradoException;
import com.api.cafeteria.modelo.Producto;
import com.api.cafeteria.repositorio.ProductoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    private final ProductoRepository repositorio;

    public ProductoController(ProductoRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping
    public List<Producto> listar() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public Producto consultar(@PathVariable Long id) {
        return repositorio.findById(id)
                .orElseThrow(() -> new NoEncontradoException("PRODUCTO_NO_ENCONTRADO", "No existe el producto con id: " + id));
    }
}
