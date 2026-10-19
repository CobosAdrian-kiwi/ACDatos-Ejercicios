package dam.acdat;

import java.io.*;

public class Sesion6BuscaErrores {
    public static void main(String[] args) {
        String aBuscar = "ERROR";
        String ruta = "Texto-con-error.txt";

        File rutaF = new File(ruta);

        FileReader reader = null;

        try {
            reader = new FileReader(rutaF);
            int l;
            int contador = 0;
            int contadorCol = 0;
            StringBuilder linea = new StringBuilder("");

            while ((l = reader.read())!= -1){
                char caract = (char) l;

                if (caract != '\n'){
                    linea.append(caract);
                    contadorCol++;
                }else{
                    if (linea.toString().contains(aBuscar)){
                        System.out.println("l "+ contador + ": c "+(contadorCol - aBuscar.length()) +": "  +linea);
                    }
                    linea = new StringBuilder("");
                    contador++;
                    contadorCol = 0;
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
