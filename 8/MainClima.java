package org.example;

import java.time.LocalDate;

public class MainClima {
    public static void main(String[] args) {
        // 1. Registro en Celsius, temperatura extrema (45.0°C)
        LocalDate hoy = LocalDate.now();
        RegistroTemperatura registroExtremo = new RegistroTemperatura(45.0, RegistroTemperatura.Unidad.CELSIUS, hoy);

        System.out.println("--- ☀️ Registro Extremo ---");
        System.out.println(registroExtremo);

        // Prueba de Comportamiento 2: Evaluación de Extremo (Debe ser TRUE)
        registroExtremo.esTemperaturaExtrema();

        // Prueba de Comportamiento 1: Conversión (C a F)
        System.out.println("\n--- Conversión de Unidad ---");
        registroExtremo.convertirTemperatura();
        // Esperado: 45.0 * 9/5 + 32 = 113.0°F

        // Estado después de la conversión
        System.out.println("Estado después de conversión: " + registroExtremo);

        // 2. Registro en Fahrenheit, temperatura normal (80.0°F)
        RegistroTemperatura registroNormal = new RegistroTemperatura(80.0, RegistroTemperatura.Unidad.FAHRENHEIT, hoy.minusDays(1));

        System.out.println("\n--- 🌤️ Registro Normal ---");
        System.out.println(registroNormal);

        // Prueba de Comportamiento 2: Evaluación de Extremo (80F es ~26.7C. Debe ser FALSE)
        registroNormal.esTemperaturaExtrema();

        // Prueba de Comportamiento 1: Conversión (F a C)
        System.out.println("\n--- Conversión de Unidad ---");
        registroNormal.convertirTemperatura();
        // Esperado: (80.0 - 32.0) * 5/9 = 26.67°C

        System.out.println("Estado después de conversión: " + registroNormal);
    }
}