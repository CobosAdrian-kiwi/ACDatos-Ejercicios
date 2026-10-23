package dam.acdat.ActEvaluable.Parte4;

/*
Crea un programa que serialice en un fichero en
formato XML un objeto de la clase Empleado utilizada
para los ejercicios anteriores. El nombre del tag o
etiqueta que engloba todo el documento debe ser empleado.
 */

import dam.acdat.ActEvaluable.Empleados;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.security.NoTypePermission;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SerializacionXML {
    public static void main(String[] args) {

        Empleados empleado1 = new Empleados(1, "1111111A", "Kiwi", 100.0F, true);

        XStream xstream = new XStream();
        xstream.alias("producto", Empleados.class);

        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("resultxml.xml"));
            xstream.toXML(empleado1, fw);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
