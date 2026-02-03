//import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        CD cd1 = new CD("Bella", "Gims", 12, 70.26);
        CD cd2 = new CD("Pastore", "Stromae", 10, 59.15);
        CD cd3 = new CD("Viaggio", "Bellofigo", 15, 92.35);
        CD cd4 = new CD("Notte", "Tiziano Ferro", 11, 65.50);
        CD cd5 = new CD("Sogni", "Vasco Rossi", 14, 80.20);
        CD cd6 = new CD("Amore", "Laura Pausini", 13, 75.10);
        CD cd7 = new CD("Festa", "Jovanotti", 16, 88.40);
        CD cd8 = new CD("Cuore", "Eros Ramazzotti", 12, 72.30);
        CD cd9 = new CD("Libertà", "Måneskin", 10, 60.50);

    
        PortaCD portacd1 = new PortaCD(5);

        System.out.println(portacd1.setCD(0, cd1));
        System.out.println(portacd1.setCD(1, cd2));
        System.out.println(portacd1.setCD(1, cd3));
        System.out.println(portacd1.setCD(2, cd4));
        System.out.println(portacd1.setCD(3, cd5));
        System.out.println(portacd1.getCD(0));;
        System.out.println(portacd1);
        System.out.println("Il numero di CD presenti all'interno del contitore è " + portacd1.getN());
        System.out.println("Il CD con titolo Notte si trova nella poszione " + portacd1.cercaCDperTitolo("Notte"));
        System.out.println(portacd1.killCD(2));
        System.out.println("Il numero di CD presenti all'interno del contitore è " + portacd1.getN());
        System.out.println(portacd1);

        PortaCD portacd2 = new PortaCD(5);

        System.out.println(portacd2.setCD(0, cd1)); 
        System.out.println(portacd2.setCD(1, cd6));
        System.out.println(portacd2.setCD(2, cd7));
        System.out.println(portacd2.setCD(3, cd8));
        System.out.println(portacd2.setCD(4, cd9));

        System.out.println("Il numero di CD presenti in entrambi in portaCD è " + portacd1.confrontaCollezione(portacd2));

}
    
}
