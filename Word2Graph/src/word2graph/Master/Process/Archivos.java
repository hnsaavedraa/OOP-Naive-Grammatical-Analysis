package word2graph.Master.Process;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Juan Pulido on 20/05/2017.
 * Estudiante Universidad Nacional de Colombia
 * Ingeniería de Sistemas y Computación
 */
public class Archivos {
    private File[] archivos;
    private String contenidoTexto;


    public Archivos(String directorio) throws IOException{
        this.archivos = new File(directorio).listFiles();
        this.contenidoTexto = "";
       leerArchivosenTexto(archivos,directorio);
    }


    public String leerArchivosenTexto(File[] archivos,String directorio) throws IOException {
        for (File archivo : archivos) {
            if (archivo.isDirectory()) {
                System.out.println("Directorio: " + archivo.getName());
                leerArchivosenTexto(archivo.listFiles(), directorio);
            } else {
                this.contenidoTexto += readFile(archivo.getName(), directorio);
            }
        }
        return contenidoTexto;
    }


    public static String readFile(String file,String directorio) throws IOException {
        String contenido = new String(Files.readAllBytes(Paths.get(directorio+"\\"+file)));
        return contenido;
    }

    public String getContenidoTexto() {
        return contenidoTexto;
    }


}
