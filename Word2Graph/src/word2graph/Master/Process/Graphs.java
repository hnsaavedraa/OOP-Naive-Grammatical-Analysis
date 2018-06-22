package word2graph.Master.Process;

import java.io.*;
import java.util.*;


public class Graphs {

    public Graphs() throws IOException{
        String TextoDelArchivo = LeerArchivo("Project Resource\\ListaGenerada.txt");
        ArrayList<String> ArrayNodos = nodos(TextoDelArchivo);
        String b = Declararconectores(TextoDelArchivo, ArrayNodos);
        String a =Declararnodos(ArrayNodos);
        Escritura(a,b);
    }


    //Recibe como parametro el String de la lsita de adyacencia y devuelve un array con los nodos
    public static ArrayList<String> nodos(String data) {
        ArrayList<String> nodos = new ArrayList<>();
        String data2 = data.replaceAll("\n", ";");

        StringTokenizer tokens = new StringTokenizer(data2, ";");
        while (tokens.hasMoreTokens()) {

            nodos.add(tokens.nextToken());
        }

        Set<String> s = new LinkedHashSet<String>(nodos);
        nodos.clear();
        nodos.addAll(s);

        return nodos;
    }

    //recibe el archivo .txt y lo convierte a String
    public static String LeerArchivo(String archivo) throws FileNotFoundException, IOException {
        String texto;
        String textostring = "";
        FileReader a = new FileReader(archivo);
        BufferedReader b = new BufferedReader(a);
        while ((texto = b.readLine()) != null) {
            textostring = textostring + texto + "\n";
        }
        b.close();
        return textostring;
    }

    //Recibe como parametro el array de los nodos y da como salida un String con los nodos en pseudocodigo
    public static String Declararnodos(ArrayList<String> nodo) {
        Map<Integer, String> nodos = new TreeMap<>();
        int count = 0;
        String declaracion = "";
        for (String n : nodo) {
            nodos.put(count, n);
            count++;
        }
        int[]r={255,0,0};
        int[]g={0,0,255};
        int[]b={0,255,0};
       int rgb=0;
        for (int i = 0; i < nodos.size(); i++) {
            double gf = Math.random() * 634.645 + 234.644;
            double h = Math.random() * -234.645 + 834.644;
          
if(rgb==3){
    rgb=0;
}
            String esqueleto = "<node id=\"" + i + "\" label=\"" + nodos.get(i) + "\"> " + "<viz:size value=\"20.0\"></viz:size> " + "<viz:position x=\"" + gf + "\" y=\"" + h + "\"></viz:position> " + "<viz:color r=\""+r[rgb]+"\" g=\""+g[rgb]+"\" b=\""+b[rgb]+"\"></viz:color> " + "</node>";
            declaracion = declaracion + esqueleto;
       rgb++;
        }
        return declaracion;
    }

    //recibe como parametro la lista de adyacencia como string y el array de nodos da como salida un String con los conectores en pseudocodigo
    public static String Declararconectores(String lista, ArrayList<String> nodo) {
        ArrayList<String> lineas = new ArrayList<>();
        ArrayList<String> independiente = new ArrayList<>();
        Map<String, Integer> nodos = new TreeMap<>();
        String declaracion = "";
        int count = 0;
        int count2 = 0;
        for (String n : nodo) {
            nodos.put(n, count);
            count++;
        }
        StringTokenizer tokens1 = new StringTokenizer(lista, "\n");
        while (tokens1.hasMoreTokens()) {

            lineas.add(tokens1.nextToken());
        }
        for (String w : lineas) {
            StringTokenizer tokens2 = new StringTokenizer(w, ";");
            while (tokens2.hasMoreTokens()) {
                independiente.add(tokens2.nextToken());
            }

            declaracion = declaracion + "<edge id=\"" + count2 + "\" source=\"" + nodos.get(independiente.get(0)) + "\" target=\"" + nodos.get(independiente.get(1)) + "\"></edge> ";
            count2++;
            independiente.clear();
        }
        return declaracion;
    }

    public static void Escritura(String nodo, String conector) {
        FileWriter fichero = null;
        try {

            fichero = new FileWriter("Graphs\\Grafo.gexf");

            fichero.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"
                    + "<gexf xmlns=\"http://www.gexf.net/1.3\" version=\"1.3\" xmlns:viz=\"http://www.gexf.net/1.3/viz\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.gexf.net/1.3 http://www.gexf.net/1.3/gexf.xsd\">\n"
                    + "  <meta lastmodifieddate=\"2017-05-15\">\n"
                    + "    <creator>Gephi 0.9</creator>\n"
                    + "    <description></description>\n"
                    + "  </meta>\n"
                    + "  <graph defaultedgetype=\"directed\" mode=\"static\">\n"
                    + "    <nodes>\n" + nodo
                    + "        </nodes>\n"
                    + "   <edges>\n" + conector
                    + "            </edges>\n"
                    + "  </graph>\n"
                    + "</gexf>\n"
                    + " ");

            fichero.close();

        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        }
    }
}