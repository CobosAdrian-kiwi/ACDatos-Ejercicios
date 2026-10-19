package dam.acdat;

import java.io.File;

public class Ej3 {
    static long TamanoTotal = 0;

    public static void main(String[] args) {
        File ruta = new File(args.length > 0 ? args[0]: ".");

        System.out.println("Ficheros encontrados: ");
        buscadorRecursivo(ruta);

        System.out.println();
        System.out.println("Resumen: ");
        System.out.println("Tamaño total: "+ TamanoTotal + " Bytes");

    }

    public static void buscadorRecursivo (File ruta){

        File[] elementosTodos = ruta.listFiles();

        if (elementosTodos == null){
            return;
        }

        for (File fichero : elementosTodos){
            if (fichero.isDirectory()){
                buscadorRecursivo(fichero);
            }else if (fichero.isFile()
                    && (fichero.getName().endsWith(".tmp")
                    || fichero.getName().endsWith(".bak")
                    || fichero.getName().endsWith(".log"))){

                System.out.println(fichero.getName());
                System.out.println(fichero.getAbsolutePath());
                System.out.println(fichero.length() + " Bytes");
                System.out.println();

                TamanoTotal += fichero.length();
            }
        }
    }
}
