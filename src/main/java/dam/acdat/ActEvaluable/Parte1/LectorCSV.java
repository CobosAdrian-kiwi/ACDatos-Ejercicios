package dam.acdat.ActEvaluable.Parte1;

import java.io.*;

public class LectorCSV {
    public static void main(String[] args) {
        File fich = new File("CSV-Result.txt");

        FileReader fr = null;
        BufferedReader reader = null;

        try {
            fr = new FileReader(fich);
            reader = new BufferedReader(fr);

            String linea;
            while  ((linea = reader.readLine()) != null){
                String[] datos = linea.split(";");

                String fijo = (datos[4].contentEquals("1")) ? "Si" : "No";

                System.out.println(
                        "EMPLEADO "+ datos[0] + "---------------\n"+
                        "Código de empleado: "+ datos[0] + "\n"+
                        "DNI del empleado: "+ datos[1] + "\n" +
                        "Nombre del empleado: "+ datos[2] + "\n"+
                        "Salario del empleado: "+ datos[3] + "\n"+
                        "Es fijo: "+ fijo +"\n\n"
                );
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
