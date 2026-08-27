import java.util.ArrayList;
import java.util.Arrays;

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

    public ArrayList<Interfaccia> getRouter() {
        return router;
    } 

    public void  routePacket(int [] ip){

         if (ip.length != 4) {
            throw new IllegalArgumentException("Gli indirizzi devono essere rappresentati come array di 4 interi.");
        }

        ArrayList<Route> match = tabella.findRoute(ip);

        if(match.isEmpty()){
            System.out.println("Nessuna route trovata per l'indirizzo " + Arrays.toString(ip));
        }

        System.out.println("Route scelta: " + match.get(0));

        if (match.size() > 1){
            System.out.println("Route di fallback disponibili:");
            for (int i=1; i<match.size(); i++) {
                System.out.println("  -  " + match.get(i));
            }
        }
        else
            System.out.println("Nessuna route di fallbak disponibile");
    }
}
