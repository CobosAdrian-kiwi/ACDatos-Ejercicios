package dam.acdat.ud3BasesRelacionales.boletin4;

/*
Ejercicio 4. Gestión de socios
Desarrolla una aplicación Java con el siguiente menú:
===== GESTIÓN DE SOCIOS =====

1. Buscar socio por email
2. Insertar nuevo socio
3. Modificar teléfono de un socio
4. Dar de baja a un socio
5. Listar socios activos
0. Salir
 */

import java.sql.*;
import java.util.Scanner;

public class MenuSocio {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        Scanner sc = new Scanner(System.in);

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)){

            int opcionUsu = 6;


            while (opcionUsu != 0){
                System.out.println("===== GESTIÓN DE SOCIOS =====\n" +
                        "\n" +
                        "1. Buscar socio por email\n" +
                        "2. Insertar nuevo socio\n" +
                        "3. Modificar teléfono de un socio\n" +
                        "4. Dar de baja a un socio\n" +
                        "5. Listar socios activos\n" +
                        "0. Salir");
                System.out.println("\nElige opcion: ");
                opcionUsu = sc.nextInt();

                switch (opcionUsu){
                    case 1:
                        System.out.println("Introduce el email a buscar: ");
                        String emailUsu = sc.nextLine();

                        BuscarEmail(conexion, emailUsu);
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 0:
                        break;
                    default:
                        System.err.println("Opción no válida vuelva a intentarlo");
                        break;
                }
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void BuscarEmail(Connection conexion, String emailUsu){
        String sql = "SELECT * FROM socios WHERE email = ?";

        try (PreparedStatement pdst = conexion.prepareStatement(sql)){

            pdst.setString(1, ("'" + emailUsu + "'"));

            try (ResultSet rs = pdst.executeQuery()){
                while (rs.next()){
                    String nombre = rs.getString("nombre");
                    String apellidos = rs.getString("apellidos");
                    String email = rs.getString("email");

                    System.out.println(nombre + apellidos + " | " + email);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
