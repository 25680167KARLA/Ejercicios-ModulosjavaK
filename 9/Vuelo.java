package org.example;

public class Vuelo {

    // 1. Atributos Privados
    // Requisito: código del vuelo, capacidad máxima de asientos y el número actual de asientos reservados.
    private String codigoVuelo;
    private int capacidadMaxima;
    private int asientosReservados;

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public Vuelo(String codigoVuelo, int capacidadMaxima) {
        this.codigoVuelo = codigoVuelo;
        // La capacidad máxima debe ser al menos 1
        this.capacidadMaxima = Math.max(1, capacidadMaxima);
        this.asientosReservados = 0; // Inicialmente, no hay asientos reservados
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para codigoVuelo
    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    // Setter para codigoVuelo
    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    // Getter para capacidadMaxima
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    // Setter para capacidadMaxima
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = Math.max(1, capacidadMaxima);
        // Si la nueva capacidad es menor que las reservas actuales, ajustamos las reservas
        if (this.asientosReservados > this.capacidadMaxima) {
            this.asientosReservados = this.capacidadMaxima;
        }
    }

    // Getter para asientosReservados
    public int getAsientosReservados() {
        return asientosReservados;
    }

    // Nota: No se incluye un Setter directo para asientosReservados.
    // El control del número de reservas se hace a través del método de Comportamiento 1.


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Intentar realizar una Reserva de un asiento
    // Requisito: Un método que intente realizar una Reserva de un asiento, incrementando el número de asientos
    // reservados solo si aún hay capacidad disponible.
    public boolean realizarReserva() {
        if (this.asientosReservados < this.capacidadMaxima) {
            this.asientosReservados++;
            int asientosDisponibles = this.capacidadMaxima - this.asientosReservados;
            System.out.printf("✅ Reserva exitosa en el vuelo %s. Asientos reservados: %d. Disponibles: %d%n",
                    this.codigoVuelo, this.asientosReservados, asientosDisponibles);
            return true;
        } else {
            System.out.printf("⛔ Reserva fallida en el vuelo %s. Vuelo completo (%d asientos reservados).%n",
                    this.codigoVuelo, this.asientosReservados);
            return false;
        }
    }

    // Comportamiento 2: Calcular el Porcentaje de Ocupación
    // Requisito: Un método que calcule y retorne el Porcentaje de Ocupación del vuelo.
    public double calcularPorcentajeOcupacion() {
        // Cálculo: (asientosReservados / capacidadMaxima) * 100
        double porcentaje = ((double) this.asientosReservados / this.capacidadMaxima) * 100.0;

        System.out.printf("📊 Porcentaje de ocupación para %s: %.2f%%%n", this.codigoVuelo, porcentaje);
        return porcentaje;
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return String.format("Vuelo [%s | Capacidad Total: %d, Reservados: %d]",
                codigoVuelo, capacidadMaxima, asientosReservados);
    }
}