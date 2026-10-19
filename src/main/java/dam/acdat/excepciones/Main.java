package dam.acdat.excepciones;


public class Main {
    public static void main(String[] args) {

        // 1. NullPointerException
        // Ocurre cuando se intenta acceder a un null
        String texto = null;
        int longitud = texto.length();


        // 2. ArrayIndexOutOfBoundsException
        // Ocurre cuando se intenta acceder a un índice que no existe
        int[] numeros = {10, 20, 30}; // Índices válidos: 0, 1, 2
        int valor = numeros[5];


        // 3. ArithmeticException
        // Ocurre cuando hay alguna operación aritmética que no se puede hacer (Ej. clásico: dividir entre 0).
        int a = 10;
        int b = 0;
        int resultado = a / b;


        // 4. NumberFormatException
        // Ocurre al intentar convertir un texto a un tipo de dato numérico.
        String cadena = "hola123";
        int numero = Integer.parseInt(cadena);


        // 5. ClassCastException
        // Ocurre al intentar castear un objeto a un tipo incompatible.
        Object objeto = "Texto de prueba";
        Integer numeroCasteado = (Integer) objeto;

    }
}