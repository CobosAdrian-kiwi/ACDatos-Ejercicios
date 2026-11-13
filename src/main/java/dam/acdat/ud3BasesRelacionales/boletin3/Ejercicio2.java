package dam.acdat.ud3BasesRelacionales.boletin3;

/*

Ejercicio 2. Recorrer los socios en orden inverso
Desarrolla una aplicación que consulte los socios de la biblioteca, ordenados por id_socio.

La aplicación deberá:
1. Situarse en el último socio.
2. Recorrer todos los socios desde el último hasta el primero.
3. Mostrar el nombre, los apellidos y el correo electrónico de cada socio.
4. Indicar cuándo se encuentra en el primer registro.
Métodos: last(), previous(), isFirst().

 */

import java.sql.*;

public class Ejercicio2 {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)) {

            System.out.println("conexion establecida");

            //LIBROS
            String sentencia = "SELECT * FROM socios ORDER BY id_socio";


            try (Statement st = conexion.createStatement(
                    ResultSet.TYPE_SCROLL_INSENSITIVE, // 1. Tipo de desplazamiento
                    ResultSet.CONCUR_READ_ONLY         // 2. Modo de concurrencia (solo lectura)
            );
                 ResultSet rs = st.executeQuery(sentencia)) {

                boolean continua = true;
                rs.last();

                while(continua){
                    System.out.println("Nombre y apellidos: "+ rs.getString("nombre") + " " + rs.getString("apellidos") + " | Correo: " + rs.getString("email"));
                    if(rs.isFirst()){
                        continua = false;
                    }
                    rs.previous();
                }


            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
