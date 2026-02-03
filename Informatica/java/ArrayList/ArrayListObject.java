/**
 * @(#)ArrayListObject.java
 * Uso di ArrayList di oggetti
 * 
 * @author zalberto
 * @version 1.00 2009/11/7
 */

import java.util.*; 
  
public class ArrayListObject
{ 
    public static void main(String[] args) {
        ArrayListObject alo = new ArrayListObject();
        alo.demo();
    }
    
    public void demo() { 
        // ArrayList tipizzato con classe Punto
        ArrayList<Punto> array = new ArrayList<Punto>(5);
        array.add(new Punto(1, -12));
        array.add(new Punto(7, 7));
        array.add(new Punto(15, 1));
        array.add(new Punto(5, 18));
        array.add(new Punto(-3, 0));

		/* 	Un iteratore è un oggetto che fornisce funzionalità per iterare su tutti gli elementi di una collezione
			Il metodo iterator() di ogni collezione restituisce un oggetto iteratore
		*/
		System.out.println("\n\nScorre Lista Punti");
        Iterator<Punto> it = array.iterator();
		while(it.hasNext()) {
			Punto p = it.next();
			System.out.println(p.toString());
		}
		/*
			Rimozione di un elemento
			Per cercare e quindi rimuovere un elemento non è possibile utilizzare un ciclo for-each
			Si otterrebbe il seguente messaggio di errore: ConcurrentModificationException
		*/
		
		it = array.iterator();  // riavvolge l'iteratore all'inizio
		while(it.hasNext()) {
			Punto p = it.next();
			if(p.getX() == 5 && p.getY() == 18)
				it.remove();
		}
		
		System.out.println("\nScorre Lista Punti");
        it = array.iterator();
		while(it.hasNext()) {
			Punto p = it.next();
			System.out.println(p.toString());
		}
    }

    // inner class
    class Punto {
        private int x;
        private int y;
        public Punto(){}
        public Punto(int x, int y){
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
        public String toString(){
            return "x = " + x + "  y = " + y;
        }
    }
}