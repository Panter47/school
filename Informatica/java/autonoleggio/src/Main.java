public class Main {

	public static void main(String[] args) {

		Furgone furgone = new Furgone("HA982BC", 2541, "FIAT", "ULISSE", 2000, 2025, 50, 4000);
		Vettura vettura = new Vettura("GG558GG", 2530, "FERRARI", "458 ITALIA", 4497, 2013, 40, 2);
		
		System.out.println("il costo del noleggio del furgone "+ furgone + " è: \n" + furgone.costoNoleggio(7, 195, 2) + "€");
		System.out.println("il costo del noleggio della vettura "+ vettura +" è: \n" + vettura.costoNoleggio(2, 40, 10) + "€");
		
		
	}

}
