package org.example;

import java.time.Year;

public class MainVehiculos {
    public static void main(String[] args) {
        // 1. Vehículo "Nuevo" (antigüedad baja)
        Automovil autoModerno = new Automovil("Tesla Model 3", 2023, 225);

        System.out.println("--- 🏎️ Auto Moderno ---");
        System.out.println(autoModerno);

        // Prueba de Comportamiento 2: Antigüedad
        int antiguedadModerna = autoModerno.calcularAntiguedad();
        System.out.println("Antigüedad calculada: " + antiguedadModerna + " años.");

        // Prueba de Comportamiento 1: Encendido
        String mensajeEncendidoModerno = autoModerno.simularEncendido();
        System.out.println(mensajeEncendidoModerno); // Debe ser exitoso

        // 2. Vehículo "Clásico" (antigüedad alta)
        // Usamos un año que lo haga mayor al UMBRAL_ANTIGUEDAD_ENCENDIDO (20 años)
        int anoAntiguo = Year.now().getValue() - 25; // Fabricado hace 25 años
        Automovil autoClasico = new Automovil("Ford Mustang", anoAntiguo, 180);

        System.out.println("\n--- 🚘 Auto Clásico ---");
        System.out.println(autoClasico);

        // Prueba de Comportamiento 2: Antigüedad
        int antiguedadClasica = autoClasico.calcularAntiguedad();
        System.out.println("Antigüedad calculada: " + antiguedadClasica + " años."); // Debe ser 25

        // Prueba de Comportamiento 1: Encendido
        String mensajeEncendidoClasico = autoClasico.simularEncendido();
        System.out.println(mensajeEncendidoClasico); // Debe fallar
    }
}