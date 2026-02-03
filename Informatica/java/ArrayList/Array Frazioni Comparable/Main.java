import java.util.ArrayList;

/**
 * Test Frazione e sort
 * @author 4A Inf
 * @version 2019
 */
public class Main {
	public static void main(String[] args){
		ArrayList<Frazione> numeri = new ArrayList<Frazione>();
		
		// 5 frazioni con valori casuali
		for (int i = 0; i < 5; i++)
			numeri.add(new Frazione((int)(21*Math.random() - 10), (int)(21*Math.random() - 10)));
		// visualizzazione
		for (Frazione f: numeri)
			System.out.println(f+ " " + f.valore());
		
		System.out.println("***** SORT ******");
		// ordinamento
		numeri.sort(null);
		// visualizzazione
		for (Frazione f: numeri)
			System.out.println(f+ " " + f.valore());
	}
}
