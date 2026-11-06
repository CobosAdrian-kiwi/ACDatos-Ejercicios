package dam.acdat.ud2Ficheros.ActEvaluable.Parte4;

/*
Crea un programa que serialice en un fichero en
formato XML un objeto de la clase Empleado utilizada
para los ejercicios anteriores. El nombre del tag o
etiqueta que engloba todo el documento debe ser empleado.
 */

import dam.acdat.ud2Ficheros.ActEvaluable.Empleado;

import com.thoughtworks.xstream.XStream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class SerializacionXML {
    public static void main(String[] args) {

        Empleado empleado1 = new Empleado(1, "1111111A", "Kiwi", 100.0F, true);

        XStream xstream = new XStream();
        xstream.alias("empleado", Empleado.class);

        FileWriter fw = null;
        try {
            fw = new FileWriter(new File("resultxml.xml"));
            xstream.toXML(empleado1, fw);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
