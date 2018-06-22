package word2graph.Master.Process;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Juan Pulido on 20/05/2017.
 * Estudiante Universidad Nacional de Colombia
 * Ingeniería de Sistemas y Computación
 */
public class ProcesoGramatical {

    public ProcesoGramatical() throws IOException{


        Gramatica gramatica = new Gramatica();

        Archivos archivos = new Archivos("Texts");
        String contenido = archivos.getContenidoTexto();

        gramatica.generarDiccionario(contenido);

        Busquedas busqueda = new Busquedas(gramatica);


        Utilidad.SeparadorOraciones(contenido).forEach(oracion -> {
            busqueda.nombreConjuncionNombre(oracion);
        });

        ListaAdyacencia test = new ListaAdyacencia(busqueda.getlistaLista());

    }
}
