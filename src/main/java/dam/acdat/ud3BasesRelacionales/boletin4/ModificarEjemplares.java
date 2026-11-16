package dam.acdat.ud3BasesRelacionales.boletin4;

/*
Ejercicio 3. Modificar ejemplares de un libro
Desarrolla una aplicación Java que solicite:
- Identificador del libro.
- Nueva cantidad de ejemplares disponibles.
El programa deberá actualizar el campo ejemplares_disponibles de la tabla libros.

Requisitos:
- Utilizar PreparedStatement con UPDATE.
- Comprobar el número de filas modificadas.
- Mostrar un mensaje si no existe el libro.
- Respetar las restricciones de la tabla: los disponibles no pueden ser negativos ni superar los totales.
 */

import java.sql.*;
import java.util.Scanner;

public class ModificarEjemplares {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        Scanner sc = new Scanner(System.in);

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)){
            int idLibroUsu;

            System.out.println("Introduce el id del libro a cambiar el numero: ");
            idLibroUsu = sc.nextInt();

            String sql = "SELECT * FROM libros WHERE id_libro = ? ORDER BY id_libro";

            try (PreparedStatement pdst = conexion.prepareStatement(sql)){

                pdst.setInt(1, idLibroUsu);

                try (ResultSet rs = pdst.executeQuery()){
                    while (rs.next()){
                        String titulo = rs.getString("titulo");
                        int ejemplares_totales = rs.getInt("ejemplares_totales");
                        int ejemplares_disponibles = rs.getInt("ejemplares_disponibles");

                        System.out.println(titulo + " | totales:" + ejemplares_totales + " | disponibles: " + ejemplares_disponibles);

                        int disponibles;

                        System.out.println("Introduce el nuevo numero de disponibles: ");
                        disponibles = sc.nextInt();

                        String sql2 = "UPDATE libros SET ejemplares_disponibles = ? WHERE id_libro = ?";

                        try (PreparedStatement pdst2 = conexion.prepareStatement(sql2)){
                            pdst2.setInt(1, disponibles);
                            pdst2.setInt(2, idLibroUsu);


                            if (disponibles < ejemplares_totales && disponibles >= 0) {
                                int filas = pdst2.executeUpdate();
                                System.out.println("Filas cambiadas: " + filas);

                                System.out.println(titulo + " | totales:" + ejemplares_totales + " | disponibles: " + disponibles);
                            }else {
                                System.err.println("No se pueden poner los disponibles ni en negativo ni pueden ser mayores que los totales");
                            }

                        }


                    }

                }

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
