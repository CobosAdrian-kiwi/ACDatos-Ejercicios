package dam.acdat.ActEvaluable.Parte2;

import java.io.*;

public class CreadorDOS_CSV {
    public static void main(String[] args) {
        File DataOutputStreamResult = new File("DataOS-Result.txt");
        char separador = '|';

        FileInputStream fis = null;
        DataInputStream dis = null;

        FileOutputStream fos = null;
        DataOutputStream dos = null;

        try {
            fis = new FileInputStream(DataOutputStreamResult);
            dis = new DataInputStream(fis);

            fos = new FileOutputStream(new File("CSV-DataOutputStream.txt"));
            dos = new DataOutputStream(fos);

            System.out.println("DATOS----------------");

            while (true) {
                int cod = dis.readInt();
                String dni = dis.readUTF();
                String nombre = dis.readUTF();
                float salario = dis.readFloat();
                boolean fijo = dis.readBoolean();

                dos.writeInt((Integer) cod);
                dos.writeChar((char) separador);
                dos.writeUTF((String) dni);
                dos.writeChar((char) separador);
                dos.writeUTF((String) nombre);
                dos.writeChar((char) separador);
                dos.writeFloat((float) salario);
                dos.writeChar((char) separador);
                dos.writeBoolean((boolean) fijo);
                dos.writeBytes(System.lineSeparator());
            }
        }catch (EOFException ex){
            System.out.println("Fin de la creacion del CSV");
        }catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
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

