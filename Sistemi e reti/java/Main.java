import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("routerSimulator.fxml"));
        Parent root = loader.load();

        stage.setTitle("Simulatore Grafico di Router");
        stage.setScene(new Scene(root));
        stage.show();
    }
}