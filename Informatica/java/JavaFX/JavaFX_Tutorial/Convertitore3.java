import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class Convertitore3 extends Application {
    public void start(Stage stage) {

        TextField txt = new TextField("");
        TextField txt2 = new TextField("");
        txt.setPromptText("Inserisci euro");
        txt2.setPromptText("Inserisci dollari");
        Label lbl = new Label("euro -> dollaro");
        Label lbl2 = new Label("dollaro -> euro");
        Button btn = new Button("converti");
        Button btn2 = new Button("converti");
        Button btn3 = new Button("chiudi applicazione");

        btn.setOnAction(e -> lbl.setText("conversione: "+ Double.parseDouble(txt.getText())*1.17));
        btn2.setOnAction(e -> lbl2.setText("conversione: "+ Double.parseDouble(txt2.getText())*0.86));
        btn3.setOnAction(e -> stage.close());
        // VBox con spaziatura di 10 pixel tra i nodi
        
        BorderPane root = new BorderPane();
        root.setTop(btn3);
        GridPane grid = new GridPane();
        grid.setHgap(20);
        grid.setVgap(20);
        
        grid.add(txt,1,0);
        grid.add(txt2,1,1);
        grid.add(lbl, 0, 0);
        grid.add(lbl2, 0, 1);
        grid.add(btn, 2, 0);
        grid.add(btn2, 2, 1);
        root.setCenter(grid);
        grid.setPadding(new Insets(15));

        

        stage.setScene(new Scene(root, 500, 500));
        stage.show();
    }
    
    public static void main(String[] args) { launch(); }
}
