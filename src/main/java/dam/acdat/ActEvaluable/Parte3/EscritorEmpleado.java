package dam.acdat.ActEvaluable.Parte3;

import dam.acdat.ActEvaluable.Empleado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EscritorEmpleado {
    public static void main(String[] args) {
        // 1. Creamos varios objetos Empleados de prueba
        Empleado e1 = new Empleado(1, "12345678A", "Ana Gómez", 25000.50f, true);
        Empleado e2 = new Empleado(2, "87654321B", "Carlos Pérez", 18500.00f, false);
        Empleado e3 = new Empleado(3, "11223344C", "Elena Ruiz", 32000.75f, true);

        String rutaFichero = "empleados.dat";

        // 2. Abrimos el flujo para escribir objetos (try-with-resources cierra el fichero automáticamente)
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {

            // 3. Escribimos los objetos uno a uno en el fichero
            oos.writeObject(e1);
            oos.writeObject(e2);
            oos.writeObject(e3);

            System.out.println("¡Objetos de empleados guardados con éxito en " + rutaFichero + "!");

        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
