import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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

    @FXML
    private void initialize() {

        colRete.setCellValueFactory(data -> new SimpleStringProperty(ipToString(data.getValue().getIndirizzoDestinazione())));
        colCIDR.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getCIDR())));
        colNextHop.setCellValueFactory(data -> new SimpleStringProperty(ipToString(data.getValue().getNextHop())));
        colInterfaccia.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getInterfaccia())));
        


    }

    private String ipToString(int[] valori) {
        return valori[0] + "." + valori[1] + "." + valori[2] + "." + valori[3];
    }


    @FXML
    void onAddInterfacciaClick(ActionEvent event) {

    }

    @FXML
    void onAddRouteClick(ActionEvent event) {

    }

    @FXML
    void onCaricaClick(ActionEvent event) {

    }

    @FXML
    void onChiudiClick(ActionEvent event) {

    }

    @FXML
    void onInvioClick(ActionEvent event) {

    }

    @FXML
    void onRimuoviInterfacciaClick(ActionEvent event) {

    }

    @FXML
    void onRimuoviRouteClick(ActionEvent event) {

    }

    @FXML
    void onSalvaClick(ActionEvent event) {

    }

}
