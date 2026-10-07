package com.dam.dtos.ejercicio4;

import java.util.Arrays;
import java.util.stream.Collectors;

public record ReservaDTO(String codigo, String cliente, String habitacion, Integer numeroNoches, Double precioTotal) {

    public static ReservaDTO from(Reserva reserva) {
        if (reserva == null) {
            return null;
        }
        return new ReservaDTO(
                reserva.getCodigo(),
                nombreCliente(reserva.getCliente()),
                descripcionHabitacion(reserva.getHabitacion()),
                reserva.getNumeroNoches(),
                precioTotal(reserva));
    }

    private static String nombreCliente(Cliente c) {
        return c == null ? null : unir(" ", c.getNombre(), c.getApellidos());
    }

    private static String descripcionHabitacion(Habitacion h) {
        return h == null ? null : unir(" - ", h.getNumero(), h.getTipo());
    }

    private static Double precioTotal(Reserva r) {
        if (r.getNumeroNoches() == null || r.getHabitacion() == null || r.getHabitacion().getPrecioNoche() == null) {
            return null;
        }
        return r.getNumeroNoches() * r.getHabitacion().getPrecioNoche();
    }

    private static String unir(String separador, String... partes) {
        String resultado = Arrays.stream(partes)
                .filter(s -> s != null && !s.isBlank())
                .map(String::trim)
                .collect(Collectors.joining(separador));
        return resultado.isEmpty() ? null : resultado;
    }
}
