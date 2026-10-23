package dam.acdat.ActEvaluable.Parte4;

/*
Crea un programa que cree en memoria un array Empleado[]
empleados con varios empleados, y a partir de él un fichero
en formato XML con los datos de todos los empleados contenidos
 en el array. En el array debe haber objetos con diversos
 atributos con valor nulo. Si es necesario, haz los cambios
 apropiados en la clase Empleado para que sea posible. Verifica
que en el fichero de XML no aparece ningún valor para atributos
con valor nulo.
 */

import com.thoughtworks.xstream.XStream;
import dam.acdat.ActEvaluable.Empleados;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ArrayEmpleados {
    public static void main(String[] args) {

        Empleados[] empleados = new Empleados[4];

        empleados[0] = new Empleados(01, "1111111A", "Pepe", 1200.0F, true);
        empleados[1] = new Empleados(02, null, "Pepa", 1300.0F, true);
        empleados[2] = new Empleados(03, "3333333C", "Pepito", 800.0F, false);
        empleados[3] = new Empleados(04, "4444444D", null, 1200.0F, false);

        XStream xstream = new XStream();
        xstream.alias("empleados", Empleados.class);

        FileWriter fw = null;
        try{
            fw =  new FileWriter(new File("ArrayEmpleados.xml"));
            xstream.toXML(empleados, fw);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
