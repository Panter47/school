/**
 * Frazione
 * @author 4A Inf
 * @version 2019
 */
public class Frazione implements Comparable<Frazione>{
	/** numeratore della frazione */
	private int num;
	
	/** denominatore della frazione */
	private int den;

	/**
	 * istanzia una frazione con i valori ricevuti (denominatore != 0)
	 * @param num numeratore
	 * @param den denominatore
	 */
	public Frazione(int num, int den)
	{
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
		{
			this.den = den;	
			riduci();
		}
	}

	/**
	 * MCD (Euclide)
	 * @return MCD tfra a e b 
	* @param a primo valore
	* @param b secondo valore
	*/
	private int mcd(int a, int b) {
		if (b == 0)
			return a;  
		else
		return mcd(b, a % b); 
	}

	/**
	 * riduce la frazione ai minimi termini
	 */
	private void riduci()
	{
		int mcd = mcd(num, den);
		num = num / mcd;
		den = den / mcd;
		if (den < 0) {
			num = -num; 
			den = -den;
		}
	}
	
	/**
	 * valore della frazione num / den
	 */
	public double valore() {
		return (double)num / (double)den;
	}
	
	@Override
	public int compareTo(Frazione f) {
		if (this.valore() == f.valore())
			return 0;
		if (this.valore() > f.valore())
			return 1;
		return -1;
	}

	/**
	 * confronto fra frazioni
	 * @param f frazione da confrontare
	 * @return true se la frazione e' maggiore di quella ricevuta, false altrimenti
	 */
	public boolean maggiore(Frazione f)
	{
		return this.valore() > f.valore();
	}
	
	/**
	 * somma di frazioni
	 * @param f frazione addendo
	 * @return frazione somma
	 */
	public Frazione somma(Frazione f) 
	{
		Frazione somma = new Frazione(f.den*num + den*f.num, den*f.den);
		somma.riduci();
		return somma;
	}
	
	/**
	 * @return rappresentazione della frazione
	 */
	public String toString()
	{
		return "( " + num + "/" + den + " )";
	}
	
}
