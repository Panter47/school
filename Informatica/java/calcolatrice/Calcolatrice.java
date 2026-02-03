import javafx.application.Application;
import javafx.event.Event;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calcolatrice extends Application {

    private Button[] buttons;
    private String[] strings = {"1","2","3","x","4","5","6","+","7","8","9","/",".","0","=","-"};
    private TextField risultato;
    
    
    private String num1 = "";
    private String num2 = "";
    private String segno = "";
    private boolean nuovoCalcolo = true; 

    public void start(Stage stage) {
        
        buttons = new Button[16];
        BorderPane root = new BorderPane();
        Button btnChiudi = new Button("chiudi");
        risultato = new TextField();
        root.setTop(btnChiudi);
        GridPane tastiera = new GridPane();
        root.setCenter(tastiera);
        root.setBottom(risultato);
        tastiera.setHgap(4);
        tastiera.setVgap(4);
        for(short i=0;i<16;i++) {
            buttons[i] = new Button(strings[i]);
            int riga = i/4;
            int colonna = i%4;
            buttons[i].setOnAction(e -> clickBottone(e));
            tastiera.add(buttons[i], colonna, riga);
        }
        btnChiudi.setOnAction(e -> stage.close());

        stage.setScene(new Scene(root,400,400));
        stage.show();
    }

    private void clickBottone(Event e) {
        Button btn = (Button) e.getSource();
        String buttonText = btn.getText();
        
        if(buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("x") || buttonText.equals("/")) {
            segno = buttonText;
            risultato.appendText(buttonText);
        }
        else if(buttonText.equals("=")) {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            double risultatoCalcolo = 0;

            if(segno.equals("+")) {
                risultatoCalcolo = n1 + n2;
            } else if(segno.equals("-")) {
                risultatoCalcolo = n1 - n2;
            } else if(segno.equals("x")) {
                risultatoCalcolo = n1 * n2;
            } else if(segno.equals("/")) {
                if(n2 != 0) {
                    risultatoCalcolo = n1 / n2;
                } else {
                    risultato.setText("Errore: Divisione per zero");
                }
            }
            
            risultato.setText(String.valueOf(risultatoCalcolo));
            num1 = "";
            num2 = "";
            segno = "";
            nuovoCalcolo = true; 
        }
        else {
            if(nuovoCalcolo) {
                risultato.clear();
                nuovoCalcolo = false;
            }
            
            risultato.appendText(buttonText);
            if(segno.isEmpty()) {
                num1 += buttonText;
            } else {
                num2 += buttonText;
            }
        }
    }

    public static void main(String[] args) { 
        launch();
    }
}