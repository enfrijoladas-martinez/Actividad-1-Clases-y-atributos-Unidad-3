package com.api.cafeteria.controlador;

import com.api.cafeteria.modelo.Estudiante;
import com.api.cafeteria.modelo.Producto;
import com.api.cafeteria.modelo.Profesor;
import com.api.cafeteria.modelo.Venta;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

@RestController
public class ModeloController {

    public record Atributo(String nombre, String tipo, boolean identificador, List<String> valoresPermitidos) {
    }

    public record Clase(String clase, List<Atributo> atributos) {
    }

    @GetMapping("/api/v1/modelo")
    public List<Clase> modelo() {
        return List.of(describir(Producto.class), describir(Venta.class),
                describir(Estudiante.class), describir(Profesor.class));
    }

    private Clase describir(Class<?> tipo) {
        List<Atributo> atributos = Arrays.stream(tipo.getDeclaredFields())
                .filter(campo -> !Modifier.isStatic(campo.getModifiers()))
                .map(this::atributo)
                .toList();
        return new Clase(tipo.getSimpleName(), atributos);
    }

    private Atributo atributo(Field campo) {
        Class<?> tipo = campo.getType();
        List<String> valores = tipo.isEnum()
                ? Arrays.stream(tipo.getEnumConstants()).map(Object::toString).toList()
                : List.of();
        return new Atributo(campo.getName(), tipo.getSimpleName(), campo.isAnnotationPresent(Id.class), valores);
    }
}
