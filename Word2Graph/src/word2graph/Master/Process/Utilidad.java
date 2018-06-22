package word2graph.Master.Process;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Juan Pulido on 29/04/2017.
 * Estudiante Universidad Nacional de Colombia
 * Ingeniería de Sistemas y Computación
 */

public class Utilidad {

    private ArrayList<String> orden= new ArrayList<>();

    public static ArrayList<String> SeparadorOraciones(String texto) {

        ArrayList<String> temp = new ArrayList<>();
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.US);
        iterator.setText(texto);
        int start = iterator.first();

        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            temp.add(texto.substring(start,end));
        }

        return temp;

    }

}
