package org.example;

public class MainTexto {
    public static void main(String[] args) {
        // Crear un objeto con una longitud máxima de 50 caracteres
        String textoInicial = "Esta es una cadena para probar el conteo.";
        ProcesadorCadena procesador1 = new ProcesadorCadena(textoInicial, "MOD-TXT-A", 50);

        System.out.println("--- 📝 Cadena Inicial ---");
        System.out.println(procesador1);

        // 1. Prueba de Comportamiento 2: Contar Espacios
        System.out.println("\n--- Conteo de Espacios ---");
        // Esperado: 6 espacios
        procesador1.contarEspaciosEnBlanco();


        // 2. Prueba de Comportamiento 1: Añadir Prefijo
        System.out.println("\n--- Aplicación de Prefijo ---");
        String prefijo = "[INFO] ";
        String resultado = procesador1.anadirPrefijo(prefijo);

        // Verificar que el atributo interno NO haya cambiado
        System.out.println("\nVerificación de Atributo Interno:");
        System.out.println(procesador1); // La cadena interna debe seguir siendo "Esta es una cadena para probar el conteo."


        // 3. Prueba de Límite de Longitud
        System.out.println("\n--- Prueba de Longitud Máxima ---");
        // Intentar establecer una cadena que excede el límite de 50
        String cadenaLarga = "Este es un mensaje muy largo para exceder el límite de 50 caracteres para la prueba.";
        procesador1.setCadenaTextoActual(cadenaLarga); // Debe fallar

        // Truncar una cadena larga en el constructor
        ProcesadorCadena procesador2 = new ProcesadorCadena(cadenaLarga, "MOD-TXT-B", 20);
        System.out.println("\n--- Cadena Truncada ---");
        System.out.println(procesador2); // Cadena debe ser "Este es un mensaje "
        procesador2.contarEspaciosEnBlanco(); // Esperado: 4 espacios
    }
}
