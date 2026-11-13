package dam.acdat.ud3BasesRelacionales.boletin3;

/*

Ejercicio 1. Navegación básica por los libros
Desarrolla una aplicación Java que consulte todos los libros de la tabla libros, ordenados por id_libro, utilizando un ResultSet desplazable.

La aplicación deberá:
1. Mostrar el título del primer libro.
2. Mostrar el título del último libro.
3. Situarse en el quinto libro y mostrar su título.
4. Retroceder dos posiciones y mostrar el libro actual.
5. Mostrar el número de fila en el que se encuentra el cursor.
Métodos: first(), last(), absolute(), relative(), getRow().

 */

import dam.acdat.ud3BasesRelacionales.Libro;

import java.sql.*;

public class Ejericicio1 {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)) {

            System.out.println("conexion establecida");

            //LIBROS
            String sentencia = "SELECT * FROM libros ORDER BY id_libro";


            try (Statement st = conexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // 1. Tipo de desplazamiento
                    ResultSet.CONCUR_READ_ONLY         // 2. Modo de concurrencia (solo lectura)
            );
                 ResultSet rs = st.executeQuery(sentencia)) {

                if (rs.first()){
                    System.out.println("Primer libro: " + rs.getString("titulo"));
                }

                if (rs.last()){
                    System.out.println("Ultimo libro: " + rs.getString("titulo"));
                }

                rs.absolute(5);
                System.out.println("5to libro: " + rs.getString("titulo") + " | ID: " + rs.getInt("id_libro"));

                rs.relative(-2);
                System.out.println("Tras retroceder 2: " + rs.getString("titulo") + " | ID: " + rs.getInt("id_libro"));

                System.out.println("Puntero: " + rs.getRow());


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
