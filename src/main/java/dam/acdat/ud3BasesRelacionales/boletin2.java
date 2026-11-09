package dam.acdat.ud3BasesRelacionales;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class boletin2 {
    public static void main(String[] args) {
        //Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "root";
        String pass = "usuario2026";

        Scanner sc = new Scanner(System.in);

        //Listas de tablas
        List<Libro> libros = new ArrayList<>(List.of()); //libros

        try (Connection conexion = DriverManager.getConnection(url, usuario, pass)){

            System.out.println("conexion establecida");

            //LIBROS
            String sentencia = "SELECT * FROM libros ORDER BY id_libro";


            try (Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sentencia)){

                while (rs.next()){
                    Integer id = rs.getInt("id_libro");
                    String titulo = rs.getString("titulo");
                    Long isbn = rs.getLong("isbn");
                    Integer anioPublicacion = rs.getInt("anio_publicacion");
                    Integer ejemplares = rs.getInt("ejemplares_totales");
                    Integer disponibles = rs.getInt("ejemplares_disponibles");
                    Integer editorial = rs.getInt("id_editorial");
                    if (rs.wasNull()){
                        editorial = null;
                    }

                    Libro libro = new Libro(id, titulo, isbn, anioPublicacion, ejemplares, disponibles, editorial);
                    libros.add(libro);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new RuntimeException(e);
        }

        //Menu de seleccion
        int opcionUsu = 9;
        Integer consultaLibroUsu;


        while (true){
            System.out.println("========= BIBLIOTECA =========");
            System.out.println("1. Listar el catálogo de libros\n" +
                    "2. Consultar un libro\n" +
                    "3. Mostrar los autores de un libro\n" +
                    "4. Listar los socios activos\n" +
                    "5. Consultar los préstamos pendientes\n" +
                    "6. Añadir una editorial de prueba\n" +
                    "7. Modificar la editorial de prueba\n" +
                    "8. Eliminar la editorial de prueba\n" +
                    "0. Salir");

            opcionUsu = sc.nextInt();

            switch (opcionUsu){
                case 1:
                    System.out.println("\n CATALOGO DE LIBROS:");
                    consultarLibros(libros);

                case 2:
                    System.out.println("\n Introduce el identificador del libro a consultar: ");
                    consultaLibroUsu = sc.nextInt();

                    boolean libroEncontrado = false;

                    for (Libro libro : libros) {
                        if (libro.getId() == consultaLibroUsu){
                            consultarLibros(libro);
                            libroEncontrado = true;
                            break;
                        }
                    }

                    if (!libroEncontrado){
                        System.out.println("No hay libros con el id introducido");
                    }
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opcion no válida");
            }
        }
    }

    private static void consultarLibros(List<Libro> libros){
        for (Libro libro : libros){
            System.out.println(libro.toString() + ((libro.getEditorial() != null) ? (" | Editorial: " + libro.getEditorial()) : " | Sin editorial"));
        }
    }

    private static void consultarLibros(Libro libro) {
        System.out.println(libro.getTitulo() + " | ISBN: "
                + libro.getIsbn() + " | Año de publicacion: " +  libro.getAnioPublicacion()+
                ((libro.getDisponibles() == 0) ? " | No hay disponibles" : (" | Disponibles: " + libro.getDisponibles())));
    }
}
