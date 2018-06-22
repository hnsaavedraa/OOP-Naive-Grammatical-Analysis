package word2graph.Master.Process;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Juan Pulido on 14/05/2017.
 * Estudiante Universidad Nacional de Colombia
 * Ingeniería de Sistemas y Computación
 */
public class Busquedas {


    private Gramatica gramatica;
    private ArrayList<String> palabrasMedias;
    private ArrayList<String> clasificMedias;
    private ArrayList<String> palabraslistas;
    private ArrayList<String> result;

    public Busquedas(Gramatica gramatica) {
        this.gramatica = gramatica;
        this.palabrasMedias = new ArrayList<>();
        this.clasificMedias = new ArrayList<>();
        this.palabraslistas = new ArrayList<>();
        this.result = new ArrayList<>();
    }

    public ArrayList<String> nombreConjuncionNombre(String oracion) {

        List<String> palabras = Arrays.asList(oracion.split(" "));

        ArrayList<Set> clasificaciones = palabras.stream().map(palabra -> gramatica.ObtenerClasificaciones(palabra)).collect(Collectors.toCollection(ArrayList::new));


        for (int i = 0; i < clasificaciones.size(); i++) {

            Set clasificacion = clasificaciones.get(i);

            if (clasificacion.contains("Nombre")) {
                palabrasMedias.add(palabras.get(i));
                clasificMedias.add("Nombre");
            }

            if (clasificacion.contains("Conjunciones")) {
                palabrasMedias.add(palabras.get(i));
                clasificMedias.add("Conjuncion");

            }
        }

        for (int i = clasificMedias.size() - 1; i > 0; i = i - 3) {

            if (clasificMedias.get(i).equals("Nombre")) {
                if (clasificMedias.get(i - 1).equals("Conjuncion")) {
                    if (clasificMedias.get(i - 2).equals("Nombre")) {
                        palabraslistas.add(palabrasMedias.get(i));
                        palabraslistas.add(palabrasMedias.get(i - 2));
                    }
                }
            }
        }


        Collections.reverse(palabraslistas);
        ArrayList<String> nodosLista = new ArrayList<>();
        Set<String> nodos = new LinkedHashSet<String>(palabraslistas);

        nodosLista.clear();
        nodosLista.addAll(nodos);

        for (int i = 0; i < palabraslistas.size(); i = i + 2) {

            if (!palabraslistas.get(i).equals(palabraslistas.get(i + 1))) {
                result.add(palabraslistas.get(i) + ";" + palabraslistas.get(i + 1));
            }

        }
        return result;
    }

    public ArrayList<String> getlistaLista() {

        Set<String> setTemp = new LinkedHashSet<String>(result);

        result.clear();
        result.addAll(setTemp);
        return result;

    }
}