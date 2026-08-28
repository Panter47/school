import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableRow;

public class RouterSimulatorController {

    @FXML
    private TextField IPInserito;

    @FXML
    private Button btnAggiungiInterfaccia;

    @FXML
    private Button btnAggiungiRoute;

    @FXML
    private Button btnInvio;

    @FXML
    private Button btnRimuoviInterfaccia;

    @FXML
    private Button btnRimuoviRoute;

    @FXML
    private TableColumn<Route, String> colCIDR;

    @FXML
    private TableColumn<Route, String> colInterfaccia;

    @FXML
    private TableColumn<Route, String> colNextHop;

    @FXML
    private TableColumn<Route, String> colRete;

    @FXML
    private TableView<Route> tableRoute;

    private Router router;
    private Tabella tabella;
    private ArrayList<Route> risultatoCorrente;

    /**
     * Inizializza il controller e imposta le proprietà delle colonne della tabella.
     * Viene anche creato un nuovo router e una nuova tabella.
     * Le route vengono aggiornate nella TableView.
     */
    @FXML
    private void initialize() {

        colRete.setCellValueFactory(data -> new SimpleStringProperty(ipToString(data.getValue().getIndirizzoDestinazione())));
        colCIDR.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getCIDR())));
        colNextHop.setCellValueFactory(data -> new SimpleStringProperty(ipToString(data.getValue().getNextHop())));
        colInterfaccia.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getInterfaccia().getNome()));

        btnRimuoviRoute.disableProperty().bind(tableRoute.getSelectionModel().selectedItemProperty().isNull());

        tableRoute.setRowFactory(tv -> new RigaRoute());

        this.tabella = new Tabella();
        this.router = new Router("R1", tabella);

        aggiornaTableView();
    }

    /**
     * Aggiorna la TableView con le route correnti nella tabella del router.
     */
    private void aggiornaTableView() {
        ObservableList<Route> dati = FXCollections.observableArrayList(tabella.getRoutes());
        tableRoute.setItems(dati);

    }


    /**
     * Converte un array di interi rappresentante un indirizzo IP in una stringa.
     * @param valori array di interi rappresentante l'indirizzo IP
     * @return stringa rappresentante l'indirizzo IP
     */
    private String ipToString(int[] valori) {
        return valori[0] + "." + valori[1] + "." + valori[2] + "." + valori[3];
    }


    /**
     * Parsa una stringa rappresentante un indirizzo IP in un array di interi.
     * @param s stringa rappresentante l'indirizzo IP
     * @return array di interi rappresentante l'indirizzo IP
     */
    private int[] parseIp(String s) {
        String[] parti = s.split("\\.");
        if (parti.length != 4) 
            throw new IllegalArgumentException("Formato IP non valido: " + s);

        int[] risultato = new int[4];
        for (int i = 0; i < 4; i++) 
            risultato[i] = Integer.parseInt(parti[i]);

        return risultato;
    }


    /**
     * Mostra un messaggio di alert all'utente.
     * @param testo il testo del messaggio da mostrare
     */
    private void mostraMessaggio(String testo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(testo);
        alert.showAndWait();
    }


    /**
     * Gestisce l'evento di click sul pulsante per aggiungere una nuova interfaccia.
     * Viene mostrata una finestra di dialogo per inserire i dati della nuova
     * interfaccia. Se i dati sono validi, la nuova interfaccia viene aggiunta al router.
     * @param event
     */
    @FXML
    void onAddInterfacciaClick(ActionEvent event) {

    Dialog<Interfaccia> dialog = new Dialog<>();
    dialog.setTitle("Aggiungi interfaccia");
    dialog.setHeaderText("Inserisci i dati della nuova interfaccia");

    ButtonType btnConferma = new ButtonType("Aggiungi", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(btnConferma, ButtonType.CANCEL);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);

    TextField campoNome = new TextField();
    campoNome.setPromptText("es. eth0");

    TextField campoIndirizzo = new TextField();
    campoIndirizzo.setPromptText("es. 192.168.1.1");

    TextField campoMaschera = new TextField();
    campoMaschera.setPromptText("es. 255.255.255.0");

    grid.add(new Label("Nome:"), 0, 0);
    grid.add(campoNome, 1, 0);
    grid.add(new Label("Indirizzo:"), 0, 1);
    grid.add(campoIndirizzo, 1, 1);
    grid.add(new Label("Maschera:"), 0, 2);
    grid.add(campoMaschera, 1, 2);

    dialog.getDialogPane().setContent(grid);

    dialog.setResultConverter(bottone -> {
        if (bottone == btnConferma) {
            try {
                String nome = campoNome.getText();
                int[] indirizzo = parseIp(campoIndirizzo.getText());
                int[] maschera = parseIp(campoMaschera.getText());

                if (nome.isEmpty()) {
                    mostraMessaggio("Il nome non può essere vuoto");
                    return null;
                }

                return new Interfaccia(nome, indirizzo, maschera);

            } catch (Exception e) {
                mostraMessaggio("Dati non validi: " + e.getMessage());
                return null;
            }
        }
        return null;
    });

    Optional<Interfaccia> risultato = dialog.showAndWait();
    risultato.ifPresent(nuovaInterfaccia -> {
        router.addInterfaccia(nuovaInterfaccia);
    });
    
    }


    /**
     * Gestisce l'evento di click sul pulsante per aggiungere una nuova route.
     * Viene mostrata una finestra di dialogo per inserire i dati della nuova
     * route. Se i dati sono validi, la nuova route viene aggiunta alla
     * tabella del router e la TableView viene aggiornata.
     * @param event
     */
    @FXML
    void onAddRouteClick(ActionEvent event) {
    if (router.getRouter().isEmpty()) {
        mostraMessaggio("Devi prima aggiungere almeno un'interfaccia");
        return;
    }

    Dialog<Route> dialog = new Dialog<>();
    dialog.setTitle("Aggiungi route");
    dialog.setHeaderText("Inserisci i dati della nuova route");

    ButtonType btnConferma = new ButtonType("Aggiungi", ButtonBar.ButtonData.OK_DONE);
    dialog.getDialogPane().getButtonTypes().addAll(btnConferma, ButtonType.CANCEL);

    GridPane grid = new GridPane();
    grid.setHgap(10);
    grid.setVgap(10);

    TextField campoRete = new TextField();
    campoRete.setPromptText("es. 192.168.1.0");

    TextField campoCidr = new TextField();
    campoCidr.setPromptText("es. 24");

    TextField campoNextHop = new TextField();
    campoNextHop.setPromptText("es. 192.168.1.254");

    ComboBox<Interfaccia> campoInterfaccia = new ComboBox<>();
    campoInterfaccia.getItems().addAll(router.getRouter());
    campoInterfaccia.getSelectionModel().selectFirst();

    grid.add(new Label("Rete destinazione:"), 0, 0);
    grid.add(campoRete, 1, 0);
    grid.add(new Label("CIDR:"), 0, 1);
    grid.add(campoCidr, 1, 1);
    grid.add(new Label("Next hop:"), 0, 2);
    grid.add(campoNextHop, 1, 2);
    grid.add(new Label("Interfaccia:"), 0, 3);
    grid.add(campoInterfaccia, 1, 3);

    dialog.getDialogPane().setContent(grid);

    dialog.setResultConverter(bottone -> {
        if (bottone == btnConferma) {
            try {
                int[] rete = parseIp(campoRete.getText());
                int cidr = Integer.parseInt(campoCidr.getText());
                int[] nextHop = parseIp(campoNextHop.getText());
                Interfaccia iface = campoInterfaccia.getValue();

                if (iface == null) {
                    mostraMessaggio("Devi selezionare un'interfaccia");
                    return null;
                }

                return new Route(rete, cidr, nextHop, iface);

            } catch (Exception e) {
                mostraMessaggio("Dati non validi: " + e.getMessage());
                return null;
            }
        }
        return null;
    });

    Optional<Route> risultato = dialog.showAndWait();
    risultato.ifPresent(nuovaRoute -> {
        tabella.addRoute(nuovaRoute);
        aggiornaTableView();
    });

    }


    /**
     * Gestisce l'evento di click sul pulsante per caricare una configurazione da file.
     * Viene mostrata una finestra di dialogo per selezionare il file da
     * caricare. Se il file è valido, la configurazione del router viene aggiornata.
     * @param event
     */
    @FXML
    void onCaricaClick(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Carica configurazione");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("file di testo", "*.txt"));

        File file = fileChooser.showOpenDialog(tableRoute.getScene().getWindow());

        if (file == null)
            return;

        TDIStorage storage = new TDIStorage();
        Router routerCaricato = storage.carica(file.getAbsolutePath(), file.getName());

        if (routerCaricato == null){
            mostraMessaggio("errore durante il caricamento del file");
            return;
        }

        this.router = routerCaricato;
        this.tabella = routerCaricato.getTabella();
        risultatoCorrente = null;
        aggiornaTableView();
    }


    /**
     * Gestisce l'evento di click sul pulsante per chiudere l'applicazione.
     * Viene chiusa l'applicazione.
     * @param event
     */
    @FXML
    void onChiudiClick(ActionEvent event) {
        System.exit(0);
    }

    /**
     * Gestisce l'evento di click sul pulsante per inviare un pacchetto.
     * Viene passato l'indirizzo IP inserito dall'utente e viene cercata
     * la route corrispondente nella tabella del router. Le route trovate 
     * vengono evidenziate nella TableView.
     * Se l'indirizzo IP non è valido, viene mostrato un messaggio di errore.
     * @param event
     */
    @FXML
    void onInvioClick(ActionEvent event) {
        int[] ip = parseIp(IPInserito.getText());

        risultatoCorrente = router.routePacket(ip);
        tableRoute.refresh();
    }


    /**
     * Gestisce l'evento di click sul pulsante per rimuovere un'interfaccia.
     * Viene mostrata una finestra di dialogo per selezionare l'interfaccia
     * da rimuovere. Se l'interfaccia selezionata non è utilizzata da nessuna route,
     * viene rimossa dal router. Altrimenti, viene mostrato un messaggio di errore.
     * @param event
     */
    @FXML
    void onRimuoviInterfacciaClick(ActionEvent event) {
    ArrayList<Interfaccia> disponibili = router.getRouter();

    if (disponibili.isEmpty()) {
        mostraMessaggio("Nessuna interfaccia da rimuovere");
        return;
    }

    ChoiceDialog<Interfaccia> dialog = new ChoiceDialog<>(disponibili.get(0), disponibili);
    dialog.setTitle("Rimuovi interfaccia");
    dialog.setHeaderText("Seleziona l'interfaccia da rimuovere");
    dialog.setContentText("Interfaccia:");

    Optional<Interfaccia> risultato = dialog.showAndWait();

    risultato.ifPresent(iface -> {
        if (interfacciaInUso(iface)) {
            mostraMessaggio("Impossibile rimuovere: l'interfaccia è usata da almeno una route");
        } else {
            router.removeInterfaccia(iface);
        }
    });

    }


    /**
     * Verifica se l'interfaccia fornita è in uso da almeno una route nella tabella del router.
     * @param iface l'interfaccia da verificare
     * @return true se l'interfaccia è in uso, false altrimenti
     */
    private boolean interfacciaInUso(Interfaccia iface) {
    for (Route r : tabella.getRoutes()) {
        if (r.getInterfaccia() == iface) {
            return true;
        }
    }
    return false;
}


    /**
     * Gestisce l'evento di click sul pulsante per rimuovere una route.
     * @param event
     */
    @FXML
    void onRimuoviRouteClick(ActionEvent event) {

        Route selezionata = tableRoute.getSelectionModel().getSelectedItem();

        if(selezionata != null){
            tabella.removeRoute(selezionata);
            risultatoCorrente = null;
            aggiornaTableView();
        }

    }


    /**
     * Gestisce l'evento di click sul pulsante per salvare la configurazione del router su file.
     * Viene mostrata una finestra di dialogo per selezionare il percorso e
     * il nome del file in cui salvare la configurazione. Se il salvataggio ha successo,
     * viene mostrato un messaggio di conferma, altrimenti un messaggio di errore.
     * @param event
     */
    @FXML
    void onSalvaClick(ActionEvent event) {
    
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Salva configurazione");
    fileChooser.getExtensionFilters().add(
        new FileChooser.ExtensionFilter("File di testo", "*.txt"));

    File file = fileChooser.showSaveDialog(tableRoute.getScene().getWindow());

    if (file == null) {
        return; // l'utente ha annullato
    }

    TDIStorage storage = new TDIStorage();
    boolean ok = storage.salva(router, file.getAbsolutePath());

    if (ok) {
        mostraMessaggio("Configurazione salvata correttamente");
    } else {
        mostraMessaggio("Errore durante il salvataggio");
    }

    }


    /**
     * RigaRoute è una classe interna che estende TableRow<Route> per personalizzare
     *  l'aspetto delle righe della TableView.
     * Le righe vengono colorate in base al risultato della ricerca delle route.
     * La prima route trovata viene colorata di verde, le altre di giallo.
     */
    private class RigaRoute extends TableRow<Route> {
    @Override
    protected void updateItem(Route route, boolean empty) {
        super.updateItem(route, empty);

        if (empty || route == null || risultatoCorrente == null || risultatoCorrente.isEmpty()) {
            setStyle("");
            return;
        }

        if (route == risultatoCorrente.get(0)) {
            setStyle("-fx-background-color: #b6f0b6;");
        } else if (risultatoCorrente.contains(route)) {
            setStyle("-fx-background-color: #fff3b0;");
        } else {
            setStyle("");
        }
    }
}

}
