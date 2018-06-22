package word2graph.Master.Process;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Juan Pulido on 29/04/2017.
 * Estudiante Universidad Nacional de Colombia
 * Ingeniería de Sistemas y Computación
 */
public class Gramatica {

    private Map<String, List> gramatica;
    private HashMap<String, Set> diccionario;

    public Gramatica() throws IOException {

        this.gramatica = new HashMap<>();

        List<String> archivos = Arrays.asList("Adjetivo", "Adverbio", "Apellido", "Articulos", "Conjunciones", "Nombre", "Prefijo", "Preposicion", "Pronombres", "Sustantivo", "Toponimo", "Verbo");
        archivos.forEach(filename -> gramatica.put(filename, convertidorArchivoLista(filename)));

        if (new File("Project Resource\\Diccionario.txt").exists()) {


            this.diccionario = new HashMap<>();
            Properties properties = new Properties();
            properties.load(new FileInputStream("Project Resource\\Diccionario.txt"));

            for (String key : properties.stringPropertyNames()) {

                String keyTemp = properties.get(key).toString();
                HashSet<String> setTemp = new HashSet<>();
                String[] helper = keyTemp.split("-");

                for (String temp : helper) {
                    setTemp.add(temp);
                }

                diccionario.put(key, setTemp);
            }

        } else {

            this.diccionario = new HashMap<>();

        }

    }


    public HashMap<String, Set> getDiccionario() {

        return diccionario;
    }

    public void clasificar(String palabra) {

        this.gramatica.forEach((clasificadorMorfologico, Lista) -> {
            if (Lista.contains(palabra)) {
                if (!this.diccionario.containsKey(palabra)) {
                    this.diccionario.put(palabra, new HashSet<>(Arrays.asList(clasificadorMorfologico)));
                } else {
                    this.diccionario.get(palabra).add(clasificadorMorfologico);
                }
            }
        });

        Properties propiedades = new Properties();


        for (Map.Entry<String, Set> entry : diccionario.entrySet()) {
            String fixValue = "";
            Set<String> usoDinamico = entry.getValue();
            for (String temp : usoDinamico) {
                fixValue += temp + "-";
            }
            propiedades.put(entry.getKey(), fixValue);
        }

        try {

            propiedades.store(new FileOutputStream("Project Resource\\Diccionario.txt"), null);

        } catch (IOException e) {

            e.printStackTrace();
        }

    }

    public Set ObtenerClasificaciones(String palabra) {

        if (this.getDiccionario().containsKey(palabra)) {

            Set clasificaciones = this.getDiccionario().get(palabra);

            return clasificaciones;

        } else {

            HashSet<String> result = new HashSet<>();
            result.add("Palabra no encontrada");
            return result;

        }
    }

    private List convertidorArchivoLista(String filename) {

        Stream<String> content = null;

        try {

            content = Files.lines(Paths.get("Gramática\\general\\" + filename + ".txt"));

        } catch (IOException e) {

            e.printStackTrace();

        }

        return content.collect(Collectors.toList());
    }

    public void generarDiccionario(String texto) {

        ArrayList<String> lineas = Utilidad.SeparadorOraciones(texto);

        lineas.forEach(oracion -> {
            List<String> palabras = Arrays.asList(oracion.trim().split(" "));
            palabras.forEach(palabra -> this.clasificar(palabra));
        });

    }


}
