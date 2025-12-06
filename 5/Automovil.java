package org.example;

import java.time.Year; // Se usa para obtener el año actual y calcular la antigüedad

public class Automovil {

    // Constante para el umbral de antigüedad
    // Definimos que un coche es "demasiado antiguo" si tiene más de 20 años.
    private static final int UMBRAL_ANTIGUEDAD_ENCENDIDO = 20;

    // 1. Atributos Privados
    // Requisito: La marca del vehículo, el año de fabricación y la velocidad máxima que puede alcanzar.
    private String marca;
    private int anoFabricacion;
    private int velocidadMaxima; // km/h

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public Automovil(String marca, int anoFabricacion, int velocidadMaxima) {
        this.marca = marca;
        // Asignación segura de valores positivos
        this.anoFabricacion = Math.max(1886, anoFabricacion); // Primer año posible de un auto
        this.velocidadMaxima = Math.max(0, velocidadMaxima);
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para marca
    public String getMarca() {
        return marca;
    }

    // Setter para marca
    public void setMarca(String marca) {
        this.marca = marca;
    }

    // Getter para anoFabricacion
    public int getAnoFabricacion() {
        return anoFabricacion;
    }

    // Setter para anoFabricacion
    public void setAnoFabricacion(int anoFabricacion) {
        this.anoFabricacion = Math.max(1886, anoFabricacion);
    }

    // Getter para velocidadMaxima
    public int getVelocidadMaxima() {
        return velocidadMaxima;
    }

    // Setter para velocidadMaxima
    public void setVelocidadMaxima(int velocidadMaxima) {
        this.velocidadMaxima = Math.max(0, velocidadMaxima);
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 2: Calcular la antigüedad del vehículo
    // Requisito: Un método que calcule la antigüedad del vehículo con respecto al año actual,
    // sin usar el año actual como atributo directo de la clase.
    public int calcularAntiguedad() {
        // Obtenemos el año actual
        int anoActual = Year.now().getValue();
        int antiguedad = anoActual - this.anoFabricacion;

        return antiguedad;
    }

    // Comportamiento 1: Simular el Encendido
    // Requisito: Un método que simule el Encendido del vehículo y retorne un mensaje indicando
    // si el encendido fue exitoso (por ejemplo, si el año de fabricación no es demasiado antiguo).
    public String simularEncendido() {
        int antiguedad = calcularAntiguedad();

        if (antiguedad <= UMBRAL_ANTIGUEDAD_ENCENDIDO) {
            // El encendido es exitoso si no excede el umbral de antigüedad
            return String.format("✅ Encendido exitoso del %s. Antigüedad: %d años. ¡Listo para conducir!",
                    this.marca, antiguedad);
        } else {
            // El encendido falla si el vehículo es demasiado antiguo
            return String.format("⛔ Fallo al encender el %s. Antigüedad: %d años (demasiado antiguo > %d).",
                    this.marca, antiguedad, UMBRAL_ANTIGUEDAD_ENCENDIDO);
        }
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return String.format("Automóvil [Marca: %s, Año: %d, Velocidad Máx: %d km/h]",
                marca, anoFabricacion, velocidadMaxima);
    }
}