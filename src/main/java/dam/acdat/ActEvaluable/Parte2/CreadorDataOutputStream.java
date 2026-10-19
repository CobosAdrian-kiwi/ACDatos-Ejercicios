package dam.acdat.ActEvaluable.Parte2;

import dam.acdat.ActEvaluable.Empleados;

import java.io.*;

public class CreadorDataOutputStream {
    public static void main(String[] args) {
        File DataOutputStreamResult = new File("DataOS-Result.txt");

        FileOutputStream fos = null;
        DataOutputStream dos = null;

        Empleados[] empleados = new Empleados[4];

        empleados[0] = new Empleados(01, "1111111A", "Pepe", 1200.0F, true);
        empleados[1] = new Empleados(02, null, "Pepa", 1300.0F, true);
        empleados[2] = new Empleados(03, "3333333C", "Pepito", 800.0F, false);
        empleados[3] = new Empleados(04, "4444444D", null, 1200.0F, false);

        try {
            fos = new FileOutputStream(DataOutputStreamResult);
            dos = new DataOutputStream(fos);

            for (Empleados emp : empleados){
                dos.writeInt(emp.getCodEmpleado());
                dos.writeUTF(emp.getDNI() != null ? emp.getDNI() : "");
                dos.writeUTF(emp.getNombre() != null ? emp.getNombre() : "");
                dos.writeFloat(emp.getSalarioBruto());
                dos.writeBoolean(emp.isFijo());
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally{
            try {
                dos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}