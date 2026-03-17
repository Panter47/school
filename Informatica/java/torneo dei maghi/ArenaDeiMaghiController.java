import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArenaDeiMaghiController {

    @FXML
    private Button btnAggiungiMago;

    @FXML
    private Button btnChiudi;

    @FXML
    private Button btnStart;

    @FXML
    private ScrollPane players;

    @FXML
    private FlowPane playersContainer;

    private List<Mago> maghi = new ArrayList<>();
    private static final Random rand = new Random();

    @FXML
    public void initialize(){
        maghi = creaMaghi();
        aggiornaGriglia();
    }

    //Crea i maghi di default 
    private List<Mago> creaMaghi(){
        List<Spell> spellBook = new ArrayList<>();
        spellBook.add(new Spell("Palla di Fuoco",  7, 12, "attacco"));
        spellBook.add(new Spell("Fulmine",         5,  8, "attacco"));
        spellBook.add(new Spell("Meteora",        10, 18, "attacco"));
        spellBook.add(new Spell("Cura Minore",     4, 10, "cura"));
        spellBook.add(new Spell("Cura Grande",     8, 20, "cura"));

        String[] nomi = {"Merlino", "Maga magò", "Gandalf", "Yen sid"};
        List<Mago> lista = new ArrayList<>();

        for (String nome : nomi){
            int hp            = randomInt(40, 60);
            int mana          = randomInt(20, 40);
            int potenzaMagica = randomInt(5,  10);
            int difesa        = randomInt(3,   8);
            int velocita      = randomInt(1,  10);

            lista.add(new Mago(nome, nome, hp, hp, mana, mana, potenzaMagica, difesa, velocita, new ArrayList<>(spellBook)));
        }
        return lista;
    }

    //Ridisegna tutte le carte nella FlowPane in base alla lista aggiornata dei maghi
    private void aggiornaGriglia(){
        playersContainer.getChildren().clear();
        for (Mago m : maghi)
            playersContainer.getChildren().add(creaCarta(m));
    }

    // Crea la carta visuale di un singolo mago 
    private VBox creaCarta(Mago m){
        VBox card = new VBox(8);
        card.setPadding(new Insets(14));
        card.setAlignment(Pos.TOP_CENTER);
        card.setPrefWidth(200);
        card.setPrefHeight(300);
        card.setStyle(
            "-fx-background-color: #1e1530;" +
            "-fx-border-color: #3a2a4a;" +
            "-fx-border-width: 1.5;" +
            "-fx-border-radius: 10;" +
            "-fx-background-radius: 10;"
        );

        // Immagine
        ImageView iv = new ImageView();
        iv.setFitWidth(100);
        iv.setFitHeight(100);
        iv.setPreserveRatio(true);
        try {
            iv.setImage(new Image(getClass().getResourceAsStream("/imm/" + getImmagine(m.getNome()))));
        } catch (Exception e){
            // immagine non trovata, si lascia vuota
        }

        // Nome
        Label lblNome = new Label(m.getNome());
        lblNome.setStyle("-fx-font-family: 'Comic Sans MS'; -fx-font-size: 15; -fx-font-weight: bold; -fx-text-fill: #e2b96f;");

        // Statistiche
        Label lblHp   = creaLabelStat("HP:             " + m.getHp()   + " / " + m.getHpMax(),   "#6fcc80");
        Label lblMana = creaLabelStat("Mana:       "    + m.getMana() + " / " + m.getManaMax(), "#6f9fcc");
        Label lblPm   = creaLabelStat("Pot. Magica: "  + m.getPotenzaMagica(),                   "#d4af37");
        Label lblDef  = creaLabelStat("Difesa:         " + m.getDifesa(),                         "#7ec8e3");
        Label lblVel  = creaLabelStat("Velocita:       " + m.getVelocità(),                       "#b8f080");

        card.getChildren().addAll(iv, lblNome, lblHp, lblMana, lblPm, lblDef, lblVel);
        return card;
    }

    private Label creaLabelStat(String testo, String colore){
        Label l = new Label(testo);
        l.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12; -fx-text-fill: " + colore + ";");
        return l;
    }

    @FXML
    void btnActionEventAdd(ActionEvent event){
        List<Spell> spellBook = new ArrayList<>();
        spellBook.add(new Spell("Palla di Fuoco",  7, 12, "attacco"));
        spellBook.add(new Spell("Fulmine",         5,  8, "attacco"));
        spellBook.add(new Spell("Meteora",        10, 18, "attacco"));
        spellBook.add(new Spell("Cura Minore",     4, 10, "cura"));
        spellBook.add(new Spell("Cura Grande",     8, 20, "cura"));

        String[] nomiExtra = {"Mago " + (maghi.size() + 1)};
        int hp            = randomInt(40, 60);
        int mana          = randomInt(20, 40);
        int potenzaMagica = randomInt(5,  10);
        int difesa        = randomInt(3,   8);
        int velocita      = randomInt(1,  10);

        Mago nuovo = new Mago(nomiExtra[0], nomiExtra[0], hp, hp, mana, mana, potenzaMagica, difesa, velocita, spellBook);
        maghi.add(nuovo);
        playersContainer.getChildren().add(creaCarta(nuovo));
    }

    //Bottone: Start per far inziare il combatimento
    @FXML
    void btnActionEventStart(ActionEvent event){
        if (maghi.size() < 2){
            mostraAlert("Errore", "Servono almeno 2 maghi per iniziare!");
            return;
        }

        //Reset HP e mana di tutti i maghi prima di ogni nuova partita
        for (Mago m : maghi){
            m.setHp(m.getHpMax());
            m.setMana(m.getManaMax());
        }

        Arena arena = new Arena(new ArrayList<>(maghi));
        arena.playMach();
        Mago vincitore = arena.getVincitore();
 
        if (vincitore != null)
            mostraVincitore(vincitore);
    }
    

    @FXML
    void btnChiudiEvent(ActionEvent event){
        System.exit(0);
    }

    //Mostra il vincitore con un Alert
    private void mostraVincitore(Mago v){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Vincitore!");
        alert.setHeaderText("Il vincitore e': " + v.getNome());
        alert.setContentText(
            "HP rimasti:     " + v.getHp()            + " / " + v.getHpMax()   + "\n" +
            "Mana rimasti:   " + v.getMana()          + " / " + v.getManaMax() + "\n" +
            "Pot. Magica:    " + v.getPotenzaMagica()                            + "\n" +
            "Difesa:         " + v.getDifesa()                                   + "\n" +
            "Velocita:       " + v.getVelocità()
        );
        alert.showAndWait();
    }

    private void mostraAlert(String titolo, String messaggio){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }

    //Per trovare l'immagine dei maghi di default
    private String getImmagine(String nome){
        if (nome.equalsIgnoreCase("Merlino"))  return "merlino.jpeg";
        if (nome.equalsIgnoreCase("Maga magò"))  return "maga_mago.jpeg";
        if (nome.equalsIgnoreCase("Gandalf"))  return "gandalf.jpeg";
        if (nome.equalsIgnoreCase("Yen sid"))  return "Yen_Sid.jpeg";
        return "";
    }

    //Funzione Random
    private static int randomInt(int min, int max){
        return rand.nextInt(max - min + 1) + min;
    }

}