package dam.acdat.ActEvaluable.Parte2;

import java.io.*;

public class LectorDataInputStream {
    public static void main(String[] args) {
        File DataOutputStreamResult = new File("DataOS-Result.txt");

        FileInputStream fis = null;
        DataInputStream dis = null;

        try {
            fis = new FileInputStream(DataOutputStreamResult);
            dis = new DataInputStream(fis);

            System.out.println("DATOS----------------");

            while (true){
                int cod = dis.readInt();
                String dni = dis.readUTF();
                String nombre = dis.readUTF();
                float salario = dis.readFloat();
                String fijoS = (dis.readBoolean() == true) ? "Si" : "No";

                System.out.println(
                        "Empleado "+cod + "\n"+
                        "Codigo: " + cod + "\n"+
                        "DNI: " + dni+ "\n"+
                        "Nombre: " + nombre+ "\n"+
                        "Salario: "+ salario+ "\n"+
                        "Es fijo: "+ fijoS+ "\n" +
                        "\n\n"
                );
            }

        }catch (EOFException ex){
            System.out.println("Fin del archivo alcanzado");
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
