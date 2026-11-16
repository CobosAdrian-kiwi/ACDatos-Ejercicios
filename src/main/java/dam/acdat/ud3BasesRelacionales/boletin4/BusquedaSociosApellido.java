package dam.acdat.ud3BasesRelacionales.boletin4;

/*
Ejercicio 2. Búsqueda de socios por apellido
Desarrolla una aplicación que solicite al usuario un texto y muestre todos los socios cuyo apellido lo contenga.

Por ejemplo, si el usuario introduce García, deberán mostrarse los socios que tengan ese texto en sus apellidos.

Requisitos:
- Utilizar LIKE con un parámetro.
- Construir el valor del parámetro con % para permitir coincidencias parciales.
- Mostrar nombre, apellidos y correo electrónico.
Pista:
String sql = "SELECT * FROM socios WHERE apellidos LIKE ?";

ps.setString(1, "%" + apellido + "%");
 */

import java.sql.*;
import java.util.Scanner;

public class BusquedaSociosApellido {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        Scanner sc = new Scanner(System.in);

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)){
            String apellidoUsu;

            System.out.println("Introduce el apellido a buscar: ");
            apellidoUsu = sc.nextLine().trim();

            String sql = "SELECT * FROM socios WHERE apellidos LIKE ? ORDER BY id_socio";

            try (PreparedStatement pdst = conexion.prepareStatement(sql)){

                pdst.setString(1, ("%"+apellidoUsu+"%"));

                try (ResultSet rs = pdst.executeQuery()){
                    while (rs.next()){
                        String nombre = rs.getString("nombre");
                        String apellidos = rs.getString("apellidos");
                        String email = rs.getString("email");

                        System.out.println(nombre + " " + apellidos + " | email: " + email);
                    }
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
