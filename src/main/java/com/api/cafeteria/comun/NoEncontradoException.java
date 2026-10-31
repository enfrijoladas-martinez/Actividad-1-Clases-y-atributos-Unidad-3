package com.api.cafeteria.comun;

public class NoEncontradoException extends RuntimeException {

    private final String codigo;

    public NoEncontradoException(String codigo, String mensaje) {
        super(mensaje);
        this.codigo = codigo;
    }

    public String getCodigo() { return codigo; }
}
