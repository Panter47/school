import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ConvertitoreController {

    @FXML
    private Button btnDollari;

    @FXML
    private Button btnEuro;

    @FXML
    private Button btnchiudi;

    @FXML
    private TextField tfDollari;

    @FXML
    private TextField tfEuro;

    @FXML
    void btnChiudiEvent(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnDollariEvent(ActionEvent event) {
		
		try {
            double euro = Double.parseDouble(tfDollari.getText());
            double dollari = euro * 1.18;
            tfDollari.setText(String.format("%.2f", dollari));
        } catch (NumberFormatException e) {
            tfDollari.setText("Input non valido");
        }

    }

    @FXML
    void btnEuroEvent(ActionEvent event) {
		try {
            double dollari = Double.parseDouble(tfEuro.getText());
            double euro = dollari / 1.18;
            tfEuro.setText(String.format("%.2f", euro));
        } catch (NumberFormatException e) {
            tfEuro.setText("Input non valido");
        }
    }

}
