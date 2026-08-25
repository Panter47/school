import java.util.ArrayList;

public class Tabella {
    /* sarà realizzata una table router tutte le condizioni per far si che si avenga veranno calcolate qui dentro */

    private ArrayList<Route> routes;

    public Tabella() {
        this.routes = new ArrayList<Route>();
    }

    /**
     * aggiunge una nuova route alla tabella e la ordina in base al CIDR in ordine decrescente
     * @param route la route da aggiungere alla tabella
     * @return true se la route è stata aggiunta correttamente, false altrimenti
     */

    public boolean addRoute(Route route) {
        if (route == null) {
            return false;
        }
        routes.add(route);
        for (short i=0; i<routes.size(); i++){
            for(short j=0; j<routes.size() - 1 - i; j++){
                if(routes.get(j).getCIDR() < routes.get(j + 1).getCIDR()){
                    Route temp = routes.get(j);
                    routes.set(j, routes.get(j + 1));
                    routes.set(j + 1, temp);
                }
            }
        }
        return true;
    }

    /**
     * rimuove una route dalla tabella
     * @param route la route da rimuovere
     * @return true se la route è stata rimossa correttamente, false altrimenti
     */
    public boolean removeRoute(Route route) {
        if (route == null) {
            return false;
        }
        return routes.remove(route);
    }


    /**
     * trova tutte le route che corrispondono all'indirizzo IP fornito
     * @param ip l'indirizzo IP da verificare
     * @return una lista di route che corrispondono all'indirizzo IP fornito
     */
    public ArrayList<Route> findRoute(int [] ip){
         if (ip.length != 4) {
            throw new IllegalArgumentException("Gli indirizzi devono essere rappresentati come array di 4 interi.");
        }

        ArrayList<Route> match = new ArrayList<>(); 

        for(Route r : routes){
            if (r.matches(ip))
                match.add(r);
        }
        return match;
    }
    
}
