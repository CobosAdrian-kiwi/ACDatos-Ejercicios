package dam.acdat;
import java.io.File;
import java.util.Arrays;

public class Ej1 {
    public static void main(String[] args) {
        String ruta;

        if (args.length > 0){
            ruta = args[0];
        }else {
            ruta = ".";
        }

        File rutaF = new File(ruta);

        System.out.println("Ficheros encontrados: ");
        System.out.println();

        buscadorRecursivo(rutaF);


    }

    public static void buscadorRecursivo (File ruta){

        File[] elementosTodos = ruta.listFiles();

        if (elementosTodos == null){
            return;
        }

        for (File fichero : elementosTodos){
            if (fichero.isDirectory()){
                buscadorRecursivo(fichero);
            }else if (fichero.isFile() && fichero.getName().endsWith(".txt")){
                System.out.println(fichero.getName());
                System.out.println(fichero.getAbsolutePath());
                System.out.println(fichero.length());
                System.out.println();
            }
        }
    }
}