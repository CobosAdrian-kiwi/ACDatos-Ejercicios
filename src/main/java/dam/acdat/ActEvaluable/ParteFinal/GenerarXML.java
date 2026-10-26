package dam.acdat.ActEvaluable.ParteFinal;

/*
********************************************************
Ejercicio 3. Generación de XML con XStream
********************************************************

Desarrolla una clase GenerarXML que:
1. Recupere los pedidos del fichero binario.
2. Almacene los pedidos recuperados en un array Pedido[].
3. Utilice XStream para generar el fichero pedidos.xml.
4. Configure los alias para que el elemento raíz se denomine pedidos y cada pedido aparezca dentro de una etiqueta pedido.
5. Compruebe que el XML generado contiene todos los pedidos y sus atributos.
El XML deberá presentar una estructura similar a la siguiente:
<pedidos>
    <pedido>
        <codigo>1001</codigo>
        <cliente>Ana López</cliente>
        <producto>Teclado</producto>
        <cantidad>2</cantidad>
        <precio>25.5</precio>
        <urgente>true</urgente>
    </pedido>
</pedidos>
 */

import com.thoughtworks.xstream.XStream;
import dam.acdat.ActEvaluable.Pedidos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GenerarXML {
    public static void main(String[] args) {
        File origen = new File("pedidos.dat");

        DataInputStream dis = null;
        XStream xstream = new XStream();
        xstream.alias("pedidos", Pedidos.class);

        FileWriter fw = null;

        List<Pedidos> pedidos = new ArrayList<>(List.of());

        try{
            dis = new DataInputStream(new FileInputStream(origen));
            fw = new FileWriter("pedidos.xml");



            while (true) {
                int codigo = dis.readInt();
                String nombre = dis.readUTF();
                String producto = dis.readUTF();
                int cantidad = dis.readInt();
                double precio = dis.readDouble();
                boolean urgente = dis.readBoolean();

                Pedidos nuevo = new Pedidos(codigo, nombre, producto, cantidad, precio, urgente);
                System.out.println("Se creó un nuevo pedido");

                pedidos.add(nuevo);
                System.out.println("Se añadió pedido a la lista");
            }



        }catch (EOFException ex) {

            xstream.toXML(pedidos, fw);
            System.out.println("Se creó correctamente el fichero xml");

        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                dis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
