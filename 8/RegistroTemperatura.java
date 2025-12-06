package org.example;

import java.time.LocalDate;

public class RegistroTemperatura {

    // Enumeración para la unidad de medida
    public enum Unidad {
        CELSIUS, FAHRENHEIT
    }

    // Constante para el umbral de temperatura extrema (40°C)
    private static final double LIMITE_EXTREMO_CELSIUS = 40.0;

    // 1. Atributos Privados
    // Requisito: valor, unidad de medida (Celsius o Fahrenheit) y la fecha de registro.
    private double valor;
    private Unidad unidad;
    private LocalDate fechaRegistro;

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public RegistroTemperatura(double valor, Unidad unidad, LocalDate fechaRegistro) {
        this.valor = valor;
        this.unidad = unidad;
        this.fechaRegistro = fechaRegistro;
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para valor
    public double getValor() {
        return valor;
    }

    // Setter para valor
    public void setValor(double valor) {
        this.valor = valor;
    }

    // Getter para unidad
    public Unidad getUnidad() {
        return unidad;
    }

    // Setter para unidad
    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

    // Getter para fechaRegistro
    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    // Setter para fechaRegistro
    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Convertir temperatura (C <-> F)
    // Requisito: Un método que convierta el valor de la temperatura de Celsius a Fahrenheit, o viceversa,
    // y actualice el valor y la unidad interna del objeto.
    public void convertirTemperatura() {
        double nuevoValor;
        Unidad nuevaUnidad;

        if (this.unidad == Unidad.CELSIUS) {
            // Convertir C a F: F = C * 9/5 + 32
            nuevoValor = (this.valor * 9.0 / 5.0) + 32.0;
            nuevaUnidad = Unidad.FAHRENHEIT;
            System.out.printf("🔄 Convertido de %.2f°C a %.2f°F%n", this.valor, nuevoValor);

        } else if (this.unidad == Unidad.FAHRENHEIT) {
            // Convertir F a C: C = (F - 32) * 5/9
            nuevoValor = (this.valor - 32.0) * 5.0 / 9.0;
            nuevaUnidad = Unidad.CELSIUS;
            System.out.printf("🔄 Convertido de %.2f°F a %.2f°C%n", this.valor, nuevoValor);

        } else {
            // Esto no debería suceder con la enumeración
            System.out.println("⚠️ Error de unidad de medida desconocida. No se realizó la conversión.");
            return;
        }

        // Actualizar los atributos internos del objeto
        this.valor = nuevoValor;
        this.unidad = nuevaUnidad;
    }

    // Comportamiento 2: Evaluar temperatura Extrema
    // Requisito: Un método que evalúe si la temperatura es considerada Extrema (por ejemplo, si supera un límite predefinido de 40°C).
    public boolean esTemperaturaExtrema() {
        double valorEnCelsius;

        // Si la unidad actual no es Celsius, la convertimos temporalmente para la comparación
        if (this.unidad == Unidad.FAHRENHEIT) {
            // C = (F - 32) * 5/9
            valorEnCelsius = (this.valor - 32.0) * 5.0 / 9.0;
        } else {
            valorEnCelsius = this.valor;
        }

        // Evaluación contra el límite de 40°C
        if (valorEnCelsius > LIMITE_EXTREMO_CELSIUS) {
            System.out.printf("🔥 ¡TEMPERATURA EXTREMA! %.2f°C supera el límite de %.0f°C.%n",
                    valorEnCelsius, LIMITE_EXTREMO_CELSIUS);
            return true;
        } else {
            System.out.printf("❄️ Temperatura normal. %.2f°C no supera el límite de %.0f°C.%n",
                    valorEnCelsius, LIMITE_EXTREMO_CELSIUS);
            return false;
        }
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return String.format("Registro [Fecha: %s, Valor: %.2f %s]",
                fechaRegistro, valor, unidad.toString());
    }
}