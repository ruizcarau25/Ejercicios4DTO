package com.dam.dtos;

import com.dam.dtos.ejercicio3.*;
import com.dam.dtos.ejercicio4.*;
import com.dam.dtos.ejercicio5.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PruebasRunner implements CommandLineRunner {

    @Override
    public void run(String... args) {
        ejercicio3();
        ejercicio4();
        ejercicio5();
    }

    private void ejercicio3() {
        System.out.println("===== EJERCICIO 3: LIBROS =====");
        Autor completo = new Autor(1L, "Gabriel", "Garcia", "Marquez", "Colombiana");
        Autor sinApellido2 = new Autor(2L, "Homero", "Simpson", null, "Griega");

        System.out.println(LibroDTO.from(new Libro(1L, "Cien anios de soledad", "978-0307474728", 1967, 417, completo)));
        System.out.println(LibroDTO.from(new Libro(2L, "La Odisea", "978-8446012450", -700, 400, sinApellido2)));
        System.out.println(LibroDTO.from(new Libro(3L, "Libro anonimo", "000-0000000000", 1900, 100, null)));
        System.out.println(LibroDTO.from(null));
    }

    private void ejercicio4() {
        System.out.println("\n===== EJERCICIO 4: RESERVAS =====");
        Cliente cliente = new Cliente(1L, "Ana", "Lopez Ruiz", "ana@mail.com", "600111222");
        Habitacion hab = new Habitacion(1L, "204", "Doble", 80.0, 2);
        Habitacion habSinPrecio = new Habitacion(2L, "305", "Suite", null, 3);

        System.out.println(ReservaDTO.from(new Reserva(1L, "R-001", 3, cliente, hab)));
        System.out.println(ReservaDTO.from(new Reserva(2L, "R-002", 2, null, hab)));
        System.out.println(ReservaDTO.from(new Reserva(3L, "R-003", 2, cliente, null)));
        System.out.println(ReservaDTO.from(new Reserva(4L, "R-004", null, cliente, hab)));
        System.out.println(ReservaDTO.from(new Reserva(5L, "R-005", 4, cliente, habSinPrecio)));
        System.out.println(ReservaDTO.from(null));
    }

    private void ejercicio5() {
        System.out.println("\n===== EJERCICIO 5: SERIES =====");
        Creador creador = new Creador(1L, "Vince", "Gilligan", "EEUU");
        Categoria categoria = new Categoria(1L, "Drama", "Series dramaticas");

        System.out.println(SerieDTO.from(new Serie(1L, "Breaking Bad", "Sinopsis", 5, creador, categoria,
                List.of("http://img/1.jpg", "http://img/2.jpg"))));
        System.out.println(SerieDTO.from(new Serie(2L, "Serie sin categoria", "Sinopsis", 2, creador, null,
                List.of("http://img/3.jpg"))));
        System.out.println(SerieDTO.from(new Serie(3L, "Serie sin imagenes", "Sinopsis", 1, creador, categoria, null)));
        System.out.println(SerieDTO.from(new Serie(4L, "Serie imagenes vacias", "Sinopsis", 1, null, categoria,
                new ArrayList<>())));
        System.out.println(SerieDTO.from(null));
    }
}
