package dam.acdat.ActEvaluable.Parte2;

import java.io.*;

public class CreadorDOS_CSV {
    public static void main(String[] args) {
        File DataOutputStreamResult = new File("DataOS-Result.txt");
        char separador = '|';

        FileInputStream fis = null;
        DataInputStream dis = null;

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fis = new FileInputStream(DataOutputStreamResult);
            dis = new DataInputStream(fis);

            fw = new FileWriter(new File("CSV-DataOutputStream.txt"));
            bw = new BufferedWriter(fw);

            System.out.println("DATOS----------------");

            while (true) {
                int cod = dis.readInt();
                String dni = dis.readUTF();
                String nombre = dis.readUTF();
                float salario = dis.readFloat();
                Integer fijoI = (dis.readBoolean() == true) ? 1 : 0;

                bw.write(""+ cod + separador + dni + separador + nombre + separador + salario + separador + fijoI);
                bw.newLine();
            }
        }catch (EOFException ex){
            System.out.println("Fin de la creacion del CSV");
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try {
                fw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

