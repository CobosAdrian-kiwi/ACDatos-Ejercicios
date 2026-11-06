package dam.acdat.ud2Ficheros.ActEvaluable.ParteFinal;

/*
********************************************************
Ejercicio 2. Conversión a fichero binario
********************************************************

A partir de los pedidos importados:
1. Genera un fichero pedidos.dat utilizando DataOutputStream.
2. Almacena todos los campos respetando sus tipos de datos.
3. Desarrolla otra clase ejecutable que lea el fichero utilizando DataInputStream.
4. Recupera los pedidos y muestra por consola el código, el cliente y el importe total de cada pedido.
5. Calcula el número de pedidos urgentes recuperados.
Los datos utilizados en el último apartado deben proceder del fichero binario, no del fichero de texto inicial.
 */

import java.io.*;

public class EscribirPedidosBinario {
    public static void main(String[] args) {

        File origenDatos = new File("pedidos.txt");
        File pedidosDat = new File("pedidos.dat");

        DataOutputStream dos = null;
        BufferedReader br = null;

        try{
            dos = new DataOutputStream(new FileOutputStream(pedidosDat));
            br = new BufferedReader(new FileReader(origenDatos));

            String linea;
            while  ((linea = br.readLine()) != null){
                String[] datos = linea.split(";");

                dos.writeInt(Integer.parseInt(datos[0]));
                dos.writeUTF((String) datos[1]);
                dos.writeUTF((String) datos[2]);
                dos.writeInt(Integer.parseInt(datos[3]));
                dos.writeDouble(Double.parseDouble(datos[4]));
                dos.writeBoolean(Boolean.parseBoolean(datos[5]));
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
