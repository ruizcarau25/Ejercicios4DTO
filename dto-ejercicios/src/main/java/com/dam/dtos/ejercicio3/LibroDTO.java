package com.dam.dtos.ejercicio3;

import java.util.Arrays;
import java.util.stream.Collectors;

public record LibroDTO(String titulo, String isbn, String autor, Integer anioPublicacion) {


    public static LibroDTO from(Libro libro) {
        if (libro == null) {
            return null;
        }
        return new LibroDTO(
                libro.getTitulo(),
                libro.getIsbn(),
                nombreCompleto(libro.getAutor()),
                libro.getAnioPublicacion());
    }


    private static String nombreCompleto(Autor autor) {
        if (autor == null) {
            return null;
        }
        String resultado = Arrays.stream(new String[] {autor.getNombre(), autor.getApellido1(), autor.getApellido2()})
                .filter(s -> s != null && !s.isBlank())
                .map(String::trim)
                .collect(Collectors.joining(" "));
        return resultado.isEmpty() ? null : resultado;
    }
}
