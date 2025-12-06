package org.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creación de dos artículos de ejemplo
        // 1. Artículo "Nuevo" (publicado hace menos de 5 años)
        LocalDate fechaReciente = LocalDate.of(2023, 10, 15);
        ArticuloBibliografico articuloReciente = new ArticuloBibliografico("A001", "María Solís", fechaReciente);

        // 2. Artículo "Antiguo" (publicado hace más de 5 años)
        LocalDate fechaAntigua = LocalDate.of(2018, 5, 20);
        ArticuloBibliografico articuloAntiguo = new ArticuloBibliografico("A002", "Javier López", fechaAntigua);

        System.out.println("--- Prueba de Artículo Reciente (A001) ---");

        // 1. Verificar estado inicial
        System.out.println("Estado inicial (¿Prestado?): " + articuloReciente.isEstadoPrestamo()); // Debe ser false

        // 2. Comportamiento 2: Verificar aptitud por antigüedad
        articuloReciente.esAptoParaPrestamo(); // Debe ser apto

        // 3. Comportamiento 1: Simular reserva
        articuloReciente.simularReserva(); // Reserva exitosa

        // 4. Verificar estado después de reserva
        System.out.println("Estado final (¿Prestado?): " + articuloReciente.isEstadoPrestamo()); // Debe ser true

        // 5. Intentar reservar de nuevo
        articuloReciente.simularReserva(); // Debe fallar


        System.out.println("\n--- Prueba de Artículo Antiguo (A002) ---");

        // 1. Uso de Getters
        System.out.println("Autor del artículo A002: " + articuloAntiguo.getNombreAutor());

        // 2. Comportamiento 2: Verificar aptitud por antigüedad
        articuloAntiguo.esAptoParaPrestamo(); // Debe ser NO apto

        // 3. Uso de Setters
        articuloAntiguo.setNombreAutor("Javier López (Actualizado)");
        System.out.println("Autor actualizado: " + articuloAntiguo.getNombreAutor());

    }
}