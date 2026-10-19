package dam.acdat.ActEvaluable.Parte1;

import dam.acdat.ActEvaluable.Empleados;

import java.io.*;

public class CreadorCSV {
    public static void main(String[] args) {
        File CSVParte1 = new File("CSV-Parte1.txt");
        char separador = ';';

        Empleados[] empleados = new Empleados[4];

        empleados[0] = new Empleados(01, "1111111A", "Pepe", 1200.0F, true);
        empleados[1] = new Empleados(02, null, "Pepa", 1300.0F, true);
        empleados[2] = new Empleados(03, "3333333C", "Pepito", 800.0F, false);
        empleados[3] = new Empleados(04, "4444444D", null, 1200.0F, false);


        FileWriter fw = null;
        BufferedWriter writer = null;

        try {

            fw = new FileWriter(new File("CSV-Result.txt"));
            writer = new BufferedWriter(fw);

            String linea;
            for (Empleados empleado : empleados){
                String cod = empleado.getCodEmpleadoString();
                String DNI = empleado.getDNI();
                String nombre = empleado.getNombre();
                String salario = empleado.getSalarioBrutString();
                int fijo = empleado.isFijo() ? 1 : 0;

                writer.write(cod+separador+DNI+separador+nombre+separador+salario+separador+fijo);
                writer.newLine();

            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                writer.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
