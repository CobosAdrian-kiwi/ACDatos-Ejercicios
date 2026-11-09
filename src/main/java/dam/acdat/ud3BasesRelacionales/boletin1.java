package dam.acdat.ud3BasesRelacionales;

import java.sql.*;
import java.util.Scanner;

public class boletin1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";



        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)){
            System.out.println("conexion establecida");
            System.out.println("Base de datos conectada: " + conexion.getCatalog());

            String sentencia = "SELECT * FROM libros ORDER BY id_libro";

            try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sentencia)){

                while (rs.next()){
                    Integer id = rs.getInt("id_libro");
                    String nombre = rs.getString("titulo");
                    Integer copias = rs.getInt("ejemplares_totales");
                    Integer copiasDisponibles = rs.getInt("ejemplares_disponibles");

                }
            }


        }catch (SQLException ex){
            System.out.println("Error al conectar con la base de datos");
            System.err.println(ex.getMessage());
        }




    }
}
