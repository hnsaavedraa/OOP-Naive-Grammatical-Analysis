package word2graph.Master.Process;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Juan Pulido on 20/05/2017.
 * Estudiante Universidad Nacional de Colombia
 * Ingeniería de Sistemas y Computación
 */

public class ListaAdyacencia {

    private ArrayList<String> salida;

    public ListaAdyacencia(ArrayList<String> palabrasListas) throws IOException{

       File nuevoArchivo=  new File("Project Resource\\ListaGenerada.txt");
       FileWriter escribir= new FileWriter(nuevoArchivo,true);
       salida= new ArrayList<>();
       this.arregloLista(palabrasListas);

       for(String temp: salida){
           escribir.write(temp+"\n");
       }

        escribir.close();
    }

    public void arregloLista(ArrayList<String> palabrasListas){

        for(int i = 0; i< palabrasListas.size();i++){
            salida.add(palabrasListas.get(i));
        }

    }

}
