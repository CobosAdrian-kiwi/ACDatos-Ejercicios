package dam.acdat.ActEvaluable.ParteFinal;

/*
********************************************************
Ejercicio 2. Conversión a fichero binario
********************************************************

A partir de los pedidos importados:
1. Genera un fichero pedidos.dat utilizando DataOutputStream.
2. Almacena todos los campos respetando sus tipos de datos.
*
* ----------------------------- vvv EMPIEZA POR AQUI vvv ---------------------------------------------------------
*
3. Desarrolla otra clase ejecutable que lea el fichero utilizando DataInputStream.
4. Recupera los pedidos y muestra por consola el código, el cliente y el importe total de cada pedido.
5. Calcula el número de pedidos urgentes recuperados.
Los datos utilizados en el último apartado deben proceder del fichero binario, no del fichero de texto inicial.
 */

import java.io.*;

public class LeerPedidosBinario {
    public static void main(String[] args) {
        File origenDat = new File("pedidos.dat");

        DataInputStream dis = null;

        int acumUrgentes = 0;
        try {
            //3. Usar DataInputStream
            dis = new DataInputStream(new FileInputStream(origenDat));

            System.out.println("DATOS: ");

            acumUrgentes = 0;

            while (true) {
                int cod = dis.readInt();
                String nombre = dis.readUTF();
                String producto = dis.readUTF();
                int cantidad = dis.readInt();
                double precio = dis.readDouble();
                boolean urgente = dis.readBoolean();

                //4. Recuperar e imprimir datos de Pedido
                System.out.println("Pedido: " + cod + " | Cliente: " + nombre + " | Total: " + (cantidad * precio));
                if (urgente) acumUrgentes++; //5. Calcular total urgentes

            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EOFException ex) {
            System.out.println("###### TOTAL DE URGENTES: " + acumUrgentes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
