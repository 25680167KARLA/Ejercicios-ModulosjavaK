package org.example;

public class ProcesadorCadena {

    // 1. Atributos Privados
    // Requisito: La cadena de texto actual, un identificador de módulo y la longitud máxima permitida para la cadena.
    private String cadenaTextoActual;
    private String identificadorModulo;
    private int longitudMaxima;

    // 2. Constructor
    // Requisito: Para inicializar los atributos.
    public ProcesadorCadena(String cadenaInicial, String identificadorModulo, int longitudMaxima) {
        this.identificadorModulo = identificadorModulo;
        this.longitudMaxima = Math.max(0, longitudMaxima); // Asegurar que sea al menos 0

        // La cadena inicial no debe exceder la longitud máxima
        if (cadenaInicial.length() > this.longitudMaxima) {
            this.cadenaTextoActual = cadenaInicial.substring(0, this.longitudMaxima);
            System.out.println("⚠️ Cadena truncada a longitud máxima de " + this.longitudMaxima);
        } else {
            this.cadenaTextoActual = cadenaInicial;
        }
    }

    // 3. Métodos Accesores (Getter y Setter por atributo)

    // Getter para cadenaTextoActual
    public String getCadenaTextoActual() {
        return cadenaTextoActual;
    }

    // Setter para cadenaTextoActual
    public void setCadenaTextoActual(String nuevaCadena) {
        if (nuevaCadena.length() <= this.longitudMaxima) {
            this.cadenaTextoActual = nuevaCadena;
        } else {
            System.out.println("❌ Error: La nueva cadena excede la longitud máxima (" + this.longitudMaxima + "). No se realizó el cambio.");
        }
    }

    // Getter para identificadorModulo
    public String getIdentificadorModulo() {
        return identificadorModulo;
    }

    // Setter para identificadorModulo
    public void setIdentificadorModulo(String identificadorModulo) {
        this.identificadorModulo = identificadorModulo;
    }

    // Getter para longitudMaxima
    public int getLongitudMaxima() {
        return longitudMaxima;
    }

    // Setter para longitudMaxima
    public void setLongitudMaxima(int longitudMaxima) {
        this.longitudMaxima = Math.max(0, longitudMaxima);
        // Si la cadena actual es más larga que la nueva longitud máxima, se trunca
        if (this.cadenaTextoActual.length() > this.longitudMaxima) {
            this.cadenaTextoActual = this.cadenaTextoActual.substring(0, this.longitudMaxima);
            System.out.println("⚠️ Advertencia: Cadena actual truncada tras reducir longitud máxima a " + this.longitudMaxima);
        }
    }


    // 4. Métodos de Comportamiento
    // Requisito: Dos métodos adicionales con lógica o cálculo relevante.

    // Comportamiento 1: Añadir un Prefijo
    // Requisito: Un método que reciba un Prefijo y devuelva la cadena de texto actual con dicho prefijo añadido al inicio.
    // Nota: El requisito pide "devuelva" la cadena, no que actualice el atributo interno.
    public String anadirPrefijo(String prefijo) {
        if (prefijo == null) {
            prefijo = "";
        }

        String cadenaConPrefijo = prefijo + this.cadenaTextoActual;

        System.out.println("➕ Prefijo añadido. Cadena resultante:");
        System.out.println("  \"" + cadenaConPrefijo + "\"");

        // Retorna la cadena resultante sin modificar la cadenaTextoActual del objeto
        return cadenaConPrefijo;
    }

    // Comportamiento 2: Contar Espacios en Blanco
    // Requisito: Un método que cuente y devuelva la cantidad de Espacios en Blanco presentes en la cadena de texto actual.
    public int contarEspaciosEnBlanco() {
        int contador = 0;
        // Recorre todos los caracteres de la cadena
        for (char caracter : this.cadenaTextoActual.toCharArray()) {
            if (caracter == ' ') {
                contador++;
            }
        }

        System.out.printf("🔢 La cadena tiene %d espacios en blanco.%n", contador);
        return contador;
    }

    // Método para mostrar información
    @Override
    public String toString() {
        return String.format("Procesador [ID: %s, Longitud Máx: %d, Cadena: \"%s\"]",
                identificadorModulo, longitudMaxima, cadenaTextoActual);
    }
}
