/**
 * @(#)ArrayListDemo.java
 *
 * @author zalberto
 * @version 1.00 2009/11/7
 */

import java.util.*;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> v = new ArrayList<String>(3); // 3 elementi di capacita iniziale

        System.out.println("n. elementi di v: " + v.size());
        v.add("primo"); // Inserisce in fondo
        v.add("secondo");
        v.add("quarto");
        v.add("quinto");
        v.add(2, "terzo"); // Inserisce in una posizione specifica

        // L'ArrayList si riDimensiona dinamicamente a partire da una dimensione iniziale
        // in base al numero di elementi inseriti
        System.out.println("n. elementi di v: " + v.size());

        // Rimuove il quarto elemento (stacca fisicamente l'elemento e ricalcola size)
        v.remove(3);
        
        // Sostituisce il valore al primo elemento (indice 0)
        v.set(0, "pippo");

        // Scorre e stampa tutto con ciclo a conteggio for
        for (int i=0; i < v.size(); i++)
            System.out.println("elemento " + i + ": " + v.get(i));
            
        /* Collections.sort ordina gli elementi di ArrayList in ordine ascendente. 
         * OKKIO, si può fare solo con int, float, string
        */
        Collections.sort(v);
        System.out.println("Lista ordinata con Collection.sort() :\n" + v);

        /* ... o discendente. */
        Collections.sort(v, Collections.reverseOrder());
        System.out.println("Lista ordinata decrescente con Collection.sort() :\n" + v);
        
            // Scorre e stampa tutto con ciclo foreach
        for(String s : v)
			System.out.println("elemento " + ": " + s);

        /* Estrae il primo elemento...
         * Se l'array non fosse stato dichiarato con tipizzazione <String>
         * Il compilatore segnalerebbe errore oppure bisognerebbe scrivere v.get(0).toString()
         */
        String primo = v.get(0);
        System.out.println("primo elemento di v: " + primo);
        System.out.println("ultimo elemento di v: " + v.get(v.size()-1)); // ...e l'ultimo
        String s = "terzo";
        System.out.print("L'elemento '" + s + "'");
        if (! v.contains(s))
        	System.out.print(" non");
        System.out.print(" appartiene all'array !");
        int i = v.indexOf("terzo");
        
        // Conversione array statico in ArrayList
        String nomi[] = {"John", "Karl", "Groucho", "Oscar"};
        ArrayList<String> v1 = new ArrayList<>(Arrays.asList(nomi));
        System.out.print(v1);
    }
}