package dam.acdat.ActEvaluable.ParteFinal;

/*

********************************************************
Ejercicio 1. Lectura y procesamiento del fichero de texto
********************************************************

Desarrolla una clase ejecutable denominada ImportarPedidos que:
1. Compruebe mediante la clase File que existe el fichero pedidos.txt y que puede leerse.
2. Lea el fichero línea a línea utilizando BufferedReader.
3. Separe y convierta los datos a su objeto correspondiente.
4. Cree un objeto Pedido por cada línea y almacene los objetos en un ArrayList<Pedido>.
6. Muestre por consola todos los pedidos, incluyendo el importe total de cada uno.

Importante: Los campos numéricos y booleanos deben almacenarse en sus tipos correspondientes.
 */

import dam.acdat.ActEvaluable.Pedidos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ImportarPedidos {
    public static void main (String[] args) {
        File fich = new File("pedidos.txt");

        //1. Comprobacion
        boolean existe = fich.exists();
        boolean puedeLeer = fich.canRead();

        if (existe && puedeLeer){

            List<Pedidos> pedidos = new ArrayList<>(List.of());

            try {
                BufferedReader br = new BufferedReader(new FileReader(fich));


                String linea;
                while ((linea = br.readLine()) != null){ //2. Leer linea a linea

                    String[] datos = linea.split(";");

                    //3. Convertir a objeto de java correspondiente
                    int codPedido = Integer.parseInt(datos[0]);
                    String nombreCliente = datos[1];
                    String nombreProducto = datos[2];
                    int cantidad = Integer.parseInt(datos[3]);
                    double precio = Double.parseDouble(datos[4]);
                    boolean urgente = Boolean.parseBoolean(datos[5]);

                    //4. Crear nuevo objeto Producto
                    Pedidos nuevo = new Pedidos(codPedido, nombreCliente, nombreProducto, cantidad, precio, urgente);
                    System.out.println("Se ha creado un nuevo pedido: " + nuevo.getCodigo());

                    pedidos.add(nuevo);
                    System.out.println("Se ha añadido un producto a la lista");

                }

                //6 (5). Mostrar por consola todos los productos
                System.out.println("RESUMEN PEDIDOS: ");
                System.out.println();
                for (Pedidos pedido : pedidos){
                    System.out.println(pedido.toString());
                    System.out.println("Total precio: " + (pedido.getPrecio() * pedido.getUds()));
                    System.out.println();
                }


            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }else{
            System.err.println("El archivo no existe o no se puede leer");
        }
    }
}
