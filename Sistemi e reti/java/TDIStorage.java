import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class TDIStorage {
    /**
     * salva su file la configurazione completa di un router (interfacce e route)
     * @param router il router di cui salvare la configurazione
     * @param percorso il percorso del file su cui scrivere
     * @return true se il salvataggio è andato a buon fine, false altrimenti
     */
    public boolean salva(Router router, String percorso) {
        if (router == null || percorso == null) {
            return false;
        }

        try {
            PrintWriter writer = new PrintWriter(new FileWriter(percorso));

            writer.println("# INTERFACCE");
            for (Interfaccia iface : router.getRouter()) {
                writer.println(iface.getNome() + ";"
                        + toStringIp(iface.getIndirizzo()) + ";"
                        + toStringIp(iface.getMaschera()));
            }

            writer.println("# ROUTES");
            for (Route r : router.getTabella().getRoutes()) {
                writer.println(toStringIp(r.getIndirizzoDestinazione()) + ";"
                        + r.getCIDR() + ";"
                        + toStringIp(r.getNextHop()) + ";"
                        + r.getInterfaccia().getNome());
            }

            writer.close();
            return true;

        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio: " + e.getMessage());
            return false;
        }
    }

    /**
     * carica da file la configurazione di un router (interfacce e route)
     * @param percorso il percorso del file da cui leggere
     * @param nomeRouter il nome da assegnare al router ricostruito
     * @return il router ricostruito, oppure null se il caricamento fallisce
     */
    public Router carica(String percorso, String nomeRouter) {
        if (percorso == null) {
            return null;
        }

        HashMap<String, Interfaccia> interfacceMap = new HashMap<String, Interfaccia>();
        Tabella tabella = new Tabella();
        Router router = new Router(nomeRouter, tabella);

        try {
            BufferedReader reader = new BufferedReader(new FileReader(percorso));

            String riga;
            boolean sezioneInterfacce = false;
            boolean sezioneRoutes = false;

            while ((riga = reader.readLine()) != null) {
                riga = riga.trim();

                if (riga.isEmpty()) {
                    continue;
                }

                if (riga.equals("# INTERFACCE")) {
                    sezioneInterfacce = true;
                    sezioneRoutes = false;
                    continue;
                }

                if (riga.equals("# ROUTES")) {
                    sezioneInterfacce = false;
                    sezioneRoutes = true;
                    continue;
                }

                String[] campi = riga.split(";");

                if (sezioneInterfacce) {
                    String nome = campi[0];
                    int[] indirizzo = parseIp(campi[1]);
                    int[] maschera = parseIp(campi[2]);

                    Interfaccia iface = new Interfaccia(nome, indirizzo, maschera);
                    interfacceMap.put(nome, iface);
                    router.addInterfaccia(iface);
                }

                if (sezioneRoutes) {
                    int[] rete = parseIp(campi[0]);
                    int cidr = Integer.parseInt(campi[1]);
                    int[] nextHop = parseIp(campi[2]);
                    String nomeInterfaccia = campi[3];

                    Interfaccia iface = interfacceMap.get(nomeInterfaccia);
                    if (iface == null) {
                        throw new IllegalArgumentException("Interfaccia non trovata nel file: " + nomeInterfaccia);
                    }

                    tabella.addRoute(new Route(rete, cidr, nextHop, iface));
                }
            }

            reader.close();
            return router;

        } catch (IOException e) {
            System.out.println("Errore durante il caricamento: " + e.getMessage());
            return null;
        }
    }

    /**
     * converte un array di 4 interi (IP o maschera) nella forma leggibile "x.x.x.x"
     * @param valori l'array da convertire
     * @return la stringa nel formato "x.x.x.x"
     */
    private String toStringIp(int[] valori) {
        return valori[0] + "." + valori[1] + "." + valori[2] + "." + valori[3];
    }

    /**
     * converte una stringa nella forma "x.x.x.x" in un array di 4 interi
     * @param s la stringa da convertire
     * @return l'array di 4 interi corrispondente
     */
    private int[] parseIp(String s) {
        String[] parti = s.split("\\.");

        if (parti.length != 4) {
            throw new IllegalArgumentException("Formato IP non valido: " + s);
        }

        int[] risultato = new int[4];
        for (int i = 0; i < 4; i++) {
            risultato[i] = Integer.parseInt(parti[i]);
        }
        return risultato;
    }
}