public class TestOrario {
    public static void main(String[] args) {
        Orario o1= new Orario(23,59,59);
        Orario o2=new Orario();
        
        System.out.println("Orario iniziale: " + o1.mostra());
        o1.tic();
        System.out.println("Dopo un tic: " + o1.mostra());
        o1.aggiungiMinuti(125);
        System.out.println("Dopo 125 minuti: "+o1.mostra());
        if(o1.ugualeA(o2)==true)
            System.out.println("Gli orari sono uguali");
        else
            System.out.println("gli orario sono diversi");

    }
}
