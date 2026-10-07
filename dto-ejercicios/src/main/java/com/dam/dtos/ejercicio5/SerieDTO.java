package com.dam.dtos.ejercicio5;

import java.util.List;

public record SerieDTO(String titulo, Integer temporadas, String creador, String categoria, String imagenPrincipal) {

    public static SerieDTO from(Serie serie) {
        if (serie == null) {
            return null;
        }
        return new SerieDTO(
                serie.getTitulo(),
                serie.getNumeroTemporadas(),
                nombreCreador(serie.getCreador()),
                serie.getCategoria() == null ? null : serie.getCategoria().getNombre(),
                primeraImagen(serie.getImagenes()));
    }

    private static String nombreCreador(Creador c) {
        if (c == null) {
            return null;
        }
        boolean hayNombre = c.getNombre() != null && !c.getNombre().isBlank();
        boolean hayApellidos = c.getApellidos() != null && !c.getApellidos().isBlank();
        if (hayNombre && hayApellidos) {
            return c.getNombre().trim() + " " + c.getApellidos().trim();
        }
        if (hayNombre) {
            return c.getNombre().trim();
        }
        return hayApellidos ? c.getApellidos().trim() : null;
    }

    private static String primeraImagen(List<String> imagenes) {
        return (imagenes == null || imagenes.isEmpty()) ? null : imagenes.get(0);
    }
}
