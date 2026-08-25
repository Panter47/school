import java.util.ArrayList;

public class Router {
    /*è la classe lista dove saranno visualizzate tutte le interfacce 
    presenti all'interno del router */

    private String nome;
    private ArrayList<Interfaccia> router;
    private Tabella tabella;

    public Router(String nome, Tabella tabella) {
        this.nome = nome;
        this.tabella = tabella;
        this.router = new ArrayList<Interfaccia>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Interfaccia getInterfaccia(int posizione) {
        if (posizione < 0 || posizione >= router.size())
            return null;
        return router.get(posizione);
    }

    public boolean addInterfaccia(Interfaccia interfaccia) {
        if (interfaccia == null) {
            return false;
        }
        router.add(interfaccia);
        return true;
    }

    public boolean removeInterfaccia(Interfaccia interfaccia) {
        if (interfaccia == null) {
            return false;
        }
        return router.remove(interfaccia);
    }

    public Tabella getTabella() {
        return tabella;
    }

    public void setTabella(Tabella tabella) {
        this.tabella = tabella;
    }

    public routePacket(int [] ip){

         if (ip.length != 4) {
            throw new IllegalArgumentException("Gli indirizzi devono essere rappresentati come array di 4 interi.");
        }

        ArrayList<Route> match = tabella.findRoute(ip);

        System.out.println("la miglior interfaccia per l'instradamento è "+ match.get(0).getInterfaccia());

        System.out.println();

    }
    
    

}
