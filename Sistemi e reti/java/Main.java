import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // creo le interfacce del router
        Interfaccia eth0 = new Interfaccia("eth0", new int[]{192, 168, 1, 1}, new int[]{255, 255, 255, 0});
        Interfaccia eth1 = new Interfaccia("eth1", new int[]{10, 0, 0, 1}, new int[]{255, 0, 0, 0});

        // creo la tabella di instradamento e aggiungo le route
        Tabella tdi = new Tabella();
        tdi.addRoute(new Route(new int[]{192, 168, 0, 0}, 16, new int[]{192, 168, 1, 254}, eth0));
        tdi.addRoute(new Route(new int[]{192, 168, 1, 0}, 24, new int[]{192, 168, 1, 254}, eth0));
        tdi.addRoute(new Route(new int[]{0, 0, 0, 0}, 0, new int[]{10, 0, 0, 254}, eth1));

        // creo il router e gli assegno le interfacce
        Router router = new Router("R1", tdi);
        router.addInterfaccia(eth0);
        router.addInterfaccia(eth1);

        System.out.println("=== TEST LOGICA DI INSTRADAMENTO ===\n");

        System.out.println("--- Test 1: IP dentro /24 ---");
        router.routePacket(new int[]{192, 168, 1, 5});

        System.out.println("\n--- Test 2: IP dentro /16 ma non /24 ---");
        router.routePacket(new int[]{192, 168, 5, 5});

        System.out.println("\n--- Test 3: IP che matcha solo la default route ---");
        router.routePacket(new int[]{8, 8, 8, 8});

        System.out.println("\n--- Test 4: rimozione route e nuovo test ---");
        ArrayList<Route> trovate = tdi.findRoute(new int[]{192, 168, 1, 5});
        tdi.removeRoute(trovate.get(0)); // rimuove la /24, la più specifica
        router.routePacket(new int[]{192, 168, 1, 5}); // ora deve scegliere la /16

        System.out.println("\n=== TEST PERSISTENZA (TDIStorage) ===\n");

        // rimetto la route /24 per avere una configurazione "piena" da salvare
        tdi.addRoute(new Route(new int[]{192, 168, 1, 0}, 24, new int[]{192, 168, 1, 254}, eth0));

        TDIStorage storage = new TDIStorage();
        String percorso = "config.txt";

        boolean salvataggioOk = storage.salva(router, percorso);
        System.out.println("Salvataggio riuscito: " + salvataggioOk);

        Router routerCaricato = storage.carica(percorso, "R1-ricaricato");

        if (routerCaricato == null) {
            System.out.println("Caricamento fallito.");
            return;
        }

        System.out.println("Caricamento riuscito, router ricreato: " + routerCaricato.getNome());

        System.out.println("\n--- Verifica dopo caricamento da file (deve dare lo stesso risultato del Test 1) ---");
        routerCaricato.routePacket(new int[]{192, 168, 1, 5});

        System.out.println("\n--- Verifica dopo caricamento da file (deve dare lo stesso risultato del Test 3) ---");
        routerCaricato.routePacket(new int[]{8, 8, 8, 8});
    }
}