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

    private void aggiornaTableView() {
        ObservableList<Route> dati = FXCollections.observableArrayList(tabella.getRoutes());
        tableRoute.setItems(dati);

    }

    private String ipToString(int[] valori) {
        return valori[0] + "." + valori[1] + "." + valori[2] + "." + valori[3];
    }

    private int[] parseIp(String s) {
        String[] parti = s.split("\\.");
        if (parti.length != 4) 
            throw new IllegalArgumentException("Formato IP non valido: " + s);

        int[] risultato = new int[4];
        for (int i = 0; i < 4; i++) 
            risultato[i] = Integer.parseInt(parti[i]);

        return risultato;
    }

    private void mostraMessaggio(String testo) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(testo);
        alert.showAndWait();
    }

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

    @FXML
    void onChiudiClick(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void onInvioClick(ActionEvent event) {
        int[] ip = parseIp(IPInserito.getText());

        risultatoCorrente = router.routePacket(ip);
        tableRoute.refresh();
    }

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

    private boolean interfacciaInUso(Interfaccia iface) {
    for (Route r : tabella.getRoutes()) {
        if (r.getInterfaccia() == iface) {
            return true;
        }
    }
    return false;
}

    @FXML
    void onRimuoviRouteClick(ActionEvent event) {

        Route selezionata = tableRoute.getSelectionModel().getSelectedItem();

        if(selezionata != null){
            tabella.removeRoute(selezionata);
            risultatoCorrente = null;
            aggiornaTableView();
        }

    }

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
