package dam.acdat.ud3BasesRelacionales.boletin3;

/*
Ejercicio 3. Navegador de libros con menú
Desarrolla una aplicación Java que permita navegar por los libros de la biblioteca utilizando un ResultSet desplazable.

El programa mostrará el siguiente menú:
===== NAVEGADOR DE LIBROS =====

1. Mostrar primer libro
2. Mostrar último libro
3. Mostrar siguiente libro
4. Mostrar libro anterior
5. Ir a una posición concreta
6. Mostrar posición actual
0. Salir

Selecciona una opción:


Requisitos:
- Utilizar TYPE_SCROLL_INSENSITIVE y CONCUR_READ_ONLY.
- Mostrar el identificador, título y año de publicación del libro seleccionado.
- Controlar los intentos de desplazamiento fuera de los límites.
- Mantener abierto el ResultSet mientras se utiliza el menú.
- Cerrar correctamente todos los recursos al finalizar.
 */

import java.sql.*;
import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        Scanner sc = new Scanner(System.in);

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)) {

            System.out.println("conexion establecida");

            //LIBROS
            String sentencia = "SELECT * FROM libros ORDER BY id_libro";


            try (Statement st = conexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // 1. Tipo de desplazamiento
                    ResultSet.CONCUR_READ_ONLY         // 2. Modo de concurrencia (solo lectura)
            );
                 ResultSet rs = st.executeQuery(sentencia)) {

                int opcionUsu = 9;
                int posicionUsu = 0;

                while (opcionUsu != 0){

                    System.out.println("\n===== NAVEGADOR DE LIBROS =====\n" +
                            "\n" +
                            "1. Mostrar primer libro\n" +
                            "2. Mostrar último libro\n" +
                            "3. Mostrar siguiente libro\n" +
                            "4. Mostrar libro anterior\n" +
                            "5. Ir a una posición concreta\n" +
                            "6. Mostrar posición actual\n" +
                            "0. Salir\n" +
                            "\n" +
                            "Selecciona una opción:\n");

                    opcionUsu = sc.nextInt();

                    switch (opcionUsu){
                        case 1:
                            if (rs.first()){
                                System.out.println(rs.getString("titulo") + ", id: " + rs.getInt("id_libro") + ", año de publicacion" + rs.getLong("anio_publicacion"));
                            }
                            break;
                        case 2:
                            if (rs.last()){
                                System.out.println(rs.getString("titulo") + ", id: " + rs.getInt("id_libro") + ", año de publicacion" + rs.getLong("anio_publicacion"));
                            }
                            break;
                        case 3:
                            if (!rs.isLast()) {
                                if (rs.next()){
                                    System.out.println(rs.getString("titulo") + ", id: " + rs.getInt("id_libro") + ", año de publicacion" + rs.getLong("anio_publicacion"));
                                }
                            }else{
                                System.out.println("No puedes ir a una posicion siguiente porque ya estas en la última");
                            }
                            break;
                        case 4:
                            if (!rs.isFirst()) {
                                if (rs.previous()){
                                    System.out.println(rs.getString("titulo") + ", id: " + rs.getInt("id_libro") + ", año de publicacion" + rs.getLong("anio_publicacion"));
                                }
                            }else{
                                System.out.println("No puedes ir a una posicion anterior porque ya estas en la primera");
                            }
                            break;
                        case 5:
                            System.out.println("Introduce la posición a viajar: ");
                            posicionUsu = sc.nextInt();

                            if (rs.absolute(posicionUsu)){
                                System.out.println("Has viajado a la posicion: " + posicionUsu);
                                System.out.println(rs.getString("titulo") + ", id: " + rs.getInt("id_libro") + ", año de publicacion" + rs.getLong("anio_publicacion"));
                            }else {
                                System.out.println("No se ha podido viajara a la posicion " + posicionUsu);
                            }
                            break;
                        case 6:
                            System.out.println("Posicion actual: " + rs.getRow());
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("introduce una posicion válida");
                    }
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
