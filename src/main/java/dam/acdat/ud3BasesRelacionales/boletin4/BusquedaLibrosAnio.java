package dam.acdat.ud3BasesRelacionales.boletin4;

/*
Ejercicio 1. Búsqueda de libros por año
Desarrolla una aplicación Java que solicite al usuario un año de publicación y muestre todos los libros publicados después de ese año.

Requisitos:
- Solicitar el año mediante Scanner.
- Utilizar PreparedStatement.
- Mostrar título y año de publicación.
- Indicar si no se encuentran resultados.
 */

import java.sql.*;
import java.util.Scanner;

public class BusquedaLibrosAnio {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        Scanner sc = new Scanner(System.in);

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)){
            int anioUsu = 0;

            System.out.println("Introduce el año a buscar: ");
            anioUsu = sc.nextInt();

            String sql = "SELECT * FROM libros WHERE anio_publicacion > ? ORDER BY anio_publicacion";

            try (PreparedStatement pdst = conexion.prepareStatement(sql)){

                pdst.setInt(1, anioUsu);

                try (ResultSet rs = pdst.executeQuery()){
                    boolean hayresultados = false;
                    while (rs.next()){
                        hayresultados = true;
                        String titulo = rs.getString("titulo");
                        int anio = rs.getInt("anio_publicacion");

                        System.out.println(titulo + " | " + anio);
                    }

                    if (!hayresultados){
                        System.out.println("No hay libros de despues de ese año");
                    }

                }catch (SQLException e){
                    throw new RuntimeException(e);
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
