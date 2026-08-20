import java.util.ArrayList;

public class Router {
    /*è la classe lista dove saranno visualizzate tutte le interfacce 
    presenti all'interno del router */

    private String nome;
    private ArrayList<Interfaccia> router;

    public Router(String nome) {
        this.nome = nome;
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

    public String setInterfaccia(int posizione, Interfaccia interfaccia) {
        if (posizione < 0 || posizione >= router.size())
            return "Posizione fuori dalla lista";
        if (router.get(posizione) != null)
            return "Posizione non disponibile";
        router.set(posizione, interfaccia);
        return "L'interfaccia è stata inserita correttamente";
    }

    public String removeInterfaccia(int posizione) {
        if (router.get(posizione) == null) {
            return "Nessuna interfaccia trovata";
        }
        router.remove(posizione);
        return "Interfaccia rimossa correttamente";
    }
    
    

}
