package dam.acdat;

import java.io.File;
import java.util.Date;

public class Ej2 {
    static File masReciente;
    static int contadorFicheros;
    static int contadorDirectorios;
    static boolean javaSolo = false;

    public static void main(String[] args) {
        File rutaF = new File(args.length > 0 ? args[0]: ".");

        if (args.length > 1) {
            if (args[1].contains(".java")) {
                javaSolo = true;
            }
        }

        buscarFicheros(rutaF);

        if (masReciente != null) {
            System.out.println("Archivo más reciente: " + masReciente.getName());
            System.out.println("Ruta: " + masReciente.getAbsolutePath());
            Date fecha = new Date(masReciente.lastModified());
            System.out.println("Fecha de ultima modificación: " + fecha);
            System.out.println();
        } else {
            System.out.println("No se encontraron archivos.");
        }

        System.out.println("RESUMEN:");
        System.out.println("Ficheros recorridos: " + contadorFicheros);
        System.out.println("Directorios recorridos: " + contadorDirectorios);
    }

    public static void buscarFicheros (File ruta){
        if (ruta == null) return;

        if (ruta.isDirectory()){
            File[] ficheros = ruta.listFiles();

            for (File fichero : ficheros){
                if (fichero.isDirectory()){
                    contadorDirectorios++;
                    buscarFicheros(fichero);
                }else{
                    if(!javaSolo) {
                        if (masReciente == null) {
                            masReciente = fichero;
                        }

                        if (fichero.lastModified() > masReciente.lastModified()) {
                            masReciente = fichero;
                        }

                    }else{
                        if (masReciente == null && fichero.getName().endsWith(".java")) {
                            masReciente = fichero;
                        }

                        if (masReciente != null) {
                            if (fichero.lastModified() > masReciente.lastModified()
                                    && fichero.getName().endsWith(".java")) {
                                masReciente = fichero;


                            }
                        }

                    }
                }
                contadorFicheros++;
            }
        }

        if (ruta.isFile()){
            contadorFicheros++;
            masReciente = ruta;
            return;
        }

    }
}
