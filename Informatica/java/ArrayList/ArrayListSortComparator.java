/**
 * @(#)ArrayListComparable.java
 * Uso dell interfaccia Comparator per ordinare ArrayList di oggetti
 * 
 * @author zalberto
 * @version 2.00 2025/02/21
 */
import java.util.*; 

public class ArrayListSortComparator { 
    public static void main (String[] args) { 
        ArrayList<Studente> lista = new ArrayList<Studente>();
        lista.add(new Studente(11, "vittorio")); 
        lista.add(new Studente(31, "alberto")); 
        lista.add(new Studente(21, "pippo")); 
  
        System.out.println("Non ordinato");
        for (Studente s: lista) 
            System.out.println(s); 

        // Primo modo con classe statica Collections
        Collections.sort(lista, new OrdinaPerNome());
        System.out.println("\nOrdinato per nome");
        for (Studente s: lista)
            System.out.println(s);
        
        // Secondo modo equivalente direttamente dall'istanza di lista
        lista.sort(new OrdinaPerEta());
        System.out.println("\nOrdinato per età");
        for (Studente s: lista)
            System.out.println(s);

        // Terzo modo avanzato che fa uso delle Lambda expression
        lista.sort((s1, s2) -> Integer.compare(s1.eta, s2.eta));
        System.out.println("\nOrdinato per età");
        for (Studente s: lista)
            System.out.println(s);
    }
}

class Studente { 
    int eta; 
    String nome; 
  
    public Studente(int eta, String nome) { 
        this.eta = eta; 
        this.nome = nome; 
    }

    public String toString() { 
        return this.eta + " " + this.nome; 
    }
}

class OrdinaPerNome implements Comparator<Studente> { 
    public int compare(Studente a, Studente b) { 
        return a.nome.compareTo(b.nome);
    }
}

class OrdinaPerEta implements Comparator<Studente> { 
    public int compare(Studente a, Studente b) { 
        //return a.eta - b.eta;
        return Integer.compare(a.eta, b.eta); // equivalente a sopra
    }
}