package org.example;

public class MainReservas {
    public static void main(String[] args) {
        // Crear un nuevo vuelo con capacidad para 100 pasajeros
        Vuelo vueloNacional = new Vuelo("VN-205", 100);

        System.out.println("--- 🛫 Vuelo Inicial ---");
        System.out.println(vueloNacional); // Reservados: 0

        // 1. Prueba de Comportamiento 1: Realizar varias reservas
        System.out.println("\n--- Intentos de Reserva ---");
        vueloNacional.realizarReserva(); // Reservados: 1
        vueloNacional.realizarReserva(); // Reservados: 2

        // Simular un grupo grande de 48 reservas más
        for (int i = 0; i < 48; i++) {
            vueloNacional.realizarReserva();
        }
        // Total Reservados: 50

        // 2. Prueba de Comportamiento 2: Cálculo de Ocupación
        System.out.println("\n--- Cálculo de Ocupación Parcial ---");
        vueloNacional.calcularPorcentajeOcupacion();
        // Esperado: (50 / 100) * 100 = 50.00%


        // 3. Simular llenado del vuelo (50 reservas más para llegar a 100)
        System.out.println("\n--- Llenando el Vuelo ---");
        for (int i = 0; i < 50; i++) {
            vueloNacional.realizarReserva();
        }
        // Total Reservados: 100

        // 4. Intento de Reserva Fallida (Vuelo Lleno)
        System.out.println("\n--- Intento de Sobrereserva ---");
        vueloNacional.realizarReserva(); // Debe fallar

        // 5. Cálculo de Ocupación Final
        System.out.println("\n--- Cálculo de Ocupación Final ---");
        vueloNacional.calcularPorcentajeOcupacion();
        // Esperado: (100 / 100) * 100 = 100.00%
    }
}