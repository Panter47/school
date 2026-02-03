public class TestPC {

	public static void main(String[] args) {
		InventarioPC inv = new InventarioPC();
		
		Desktop d1 = new Desktop(16, 512, "Dell", "OptiPlex 7090", "Windows 11 Pro", "Mid Tower", "NVIDIA RTX 3060", "Realtek HD Audio");
		Desktop d2 = new Desktop(32, 1024, "HP", "Omen GT13", "Windows 11 Home", "Full Tower", "NVIDIA RTX 4090", "Sound Blaster Z");

		Palmare p1 = new Palmare(4, 128, "Samsung", "Galaxy Mini", "Android 13", 0.150, 14.0, 7.0, 0.8, 5.2, true, true, "eMMC");
		Palmare p2 = new Palmare(6, 256, "Apple", "iPhone SE", "iOS 17", 0.148, 13.8, 6.7, 0.7, 4.7, true, true, "NVMe");

		Notebook n1 = new Notebook(16, 512, "Lenovo", "ThinkPad X1", "Windows 11 Pro", 1.2, 32.0, 22.0, 1.5, 14.0, true, true, 8);
		Notebook n2 = new Notebook(8, 256, "Acer", "Aspire 5", "Linux Ubuntu 22.04", 1.7, 36.0, 24.0, 1.8, 15.6, true, false, 0);

		Server s1 = new Server(64, 4096, "IBM", "X3650", "Linux RedHat", "Rack", 24, true);
		Server s2 = new Server(128, 8192, "Dell", "PowerEdge R740", "Windows Server 2022", "Rack", 32, true);

		
		inv.aggiungiPC(d1);
		inv.aggiungiPC(d2);
		inv.aggiungiPC(p1);
		inv.aggiungiPC(p2);
		inv.aggiungiPC(n1);
		inv.aggiungiPC(n2);
		inv.aggiungiPC(s1);
		inv.aggiungiPC(s2);
		
		System.out.println("il pc con la ram più alta è: "+ inv.trovaPCConPiuRAM());
		System.out.println("la media della ram è: "+ inv.calcolaMediaRAM());
		System.out.println("pc con wifi: "+ inv.contaPortatiliConWifi());
		System.out.println("il numero di server con raid: "+ inv.contaServerConRaid());
		System.out.println("il notebook più leggero: "+ inv.trovaNotebookPiuLeggero());
		System.out.println(inv.cercaPortatili(200, true));
		
		

	}

}
