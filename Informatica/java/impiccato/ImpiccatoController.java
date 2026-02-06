import java.util.Optional;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;



public class ImpiccatoController {

    private boolean inizializzato = false;
    private StringBuilder parola;
    private StringBuilder trattini = new StringBuilder();
    private short errori=0;

    @FXML
    private Button btnChiudi;

    @FXML
    private ImageView imgImpiccato;

    @FXML
    private Label lblParolaDaScoprire;

    @FXML
    void btnChiudiEvent(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void keyEvent(KeyEvent event) {
        
        if(!inizializzato){
            trattini = new StringBuilder();
            parola = getWord();
            for(short i=0;i<parola.length();i++)
                trattini.append("_ ");
            lblParolaDaScoprire.setText(trattini.toString());
            inizializzato=true;
            imgImpiccato.setImage(new Image("immaginiImpiccato/0.png"));
            errori=0;
            
        }


        char carattere = event.getText().toLowerCase().charAt(0);

        boolean errore=true;
        for(short i=0;i<parola.length();i++){
            if(parola.charAt(i) == carattere){
                trattini.setCharAt(i*2, carattere);
                lblParolaDaScoprire.setText(trattini.toString());
                errore=false;
            }
            
        }
        if(errore){
                errori++;
                imgImpiccato.setImage(new Image("immaginiImpiccato/"+ errori + ".png"));
        }

        if(errori == 10){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Scarso");
            alert.setHeaderText("hai perso, la parola era: "+ parola);
            Optional<ButtonType> result = alert.showAndWait();
            inizializzato = false;
        }
        if(!trattini.toString().contains("_")){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Non sei cosi scarso");
            alert.setHeaderText("hai indovinato la parola");
            Optional<ButtonType> result = alert.showAndWait();
            inizializzato = false;
        }
    }

    public StringBuilder getWord() {
    String[] words = {
        "montagna", "bicicletta", "ombrello", "finestra", "gelato",
        "nuvola", "tappeto", "cuscino", "forchetta", "specchio",
        "lampada", "giardino", "valigia", "orologio", "scarpa",
        "pioggia", "quaderno", "candela", "bosco", "telefono"
    };
    Random random = new Random();
    String randomWord = words[random.nextInt(words.length)];
    return new StringBuilder(randomWord);
}
}
