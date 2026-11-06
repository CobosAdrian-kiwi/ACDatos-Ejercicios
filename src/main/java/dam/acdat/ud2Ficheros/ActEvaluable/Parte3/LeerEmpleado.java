package dam.acdat.ud2Ficheros.ActEvaluable.Parte3;

import dam.acdat.ud2Ficheros.ActEvaluable.Empleado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerEmpleado {
    public static void main(String[] args) {
        String rutaFichero = "empleados.dat";

        // Abrimos el flujo para leer objetos
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaFichero))) {

            System.out.println("--- LISTADO DE EMPLEADOS LEÍDOS DEL FICHERO ---");

            while (true) {
                // Leemos el objeto, hacemos un casting a (Empleados) y lo imprimimos
                Empleado emp = (Empleado) ois.readObject();
                System.out.println(emp); // Esto llamará automáticamente al método toString()
            }

        } catch (EOFException e) {
            // Esta excepción salta cuando llegamos al final del archivo (es un comportamiento normal aquí)
            System.out.println("\n--- Fin del fichero ---");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ocurrió un error durante la lectura: " + e.getMessage());
        }
    }
}