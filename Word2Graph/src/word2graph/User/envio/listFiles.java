/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package word2graph.User.envio;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author jsg11
 */
public class listFiles {
    private File dir;
    private String files;
    private File[] ficheros;
    private ArrayList <String> contxt;
    public listFiles(String directorio){
        dir = new File(directorio); //carga "directorio"
        ficheros = dir.listFiles(); //arreglo de todos los archivos de directorio
        contxt= new ArrayList(); //almacenara los enlaces absolutos txt

    }
    public  ArrayList <String> directoriosTxt(){
                   for (int i = 0; i < ficheros.length; i++) {
                if(ficheros[i].isFile()){               //verifica si hay ficheros 
                    files = ficheros[i].getName();      //obtiene el nobre del archio
                    if(files.endsWith(".txt")||files.endsWith(".TXT")){ //busca txt
                        contxt.add(ficheros[i].getAbsolutePath()); //agrega elace asoluto de  archivos txt
                    }
                } 
            } 
                   return contxt;
    }
}
