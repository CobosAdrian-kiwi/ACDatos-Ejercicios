package dam.acdat.ud3BasesRelacionales;

import java.sql.*;

public class boletin1 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)){
            System.out.println("conexion establecida");
            System.out.println("Base de datos conectada: " + conexion.getCatalog());

            String sentencia = "SELECT * FROM libros ORDER BY id";

            try (Statement st = conexion.createStatement(); ResultSet set = st.executeQuery(sentencia)){

                while (set.next()){
                    Integer id = set.getInt('3');
                    String nombre = set.getString('1');
                    Integer copias = set.getInt("ejemplares_disponibles");

                    System.out.println("Identificador: " + id + " | Titulo: " + nombre + " | Disponible: " + copias);
                }
            }


        }catch (SQLException ex){
            System.out.println("Error al conectar con la base de datos");
            System.err.println(ex.getMessage());
        }


    }
}
