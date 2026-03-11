import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    private static final Random rand = new Random();

    public static void main(String[] args){

        Spell palla_di_fuoco  = new Spell("Palla di Fuoco",   7, 12, "attacco");
        Spell fulmine         = new Spell("Fulmine",          5,  8, "attacco");
        Spell meteora         = new Spell("Meteora",         10, 18, "attacco");
        Spell cura_minore     = new Spell("Cura Minore",      4, 10, "cura");
        Spell cura_grande     = new Spell("Cura Grande",      8, 20, "cura");

        List<Mago> maghi = new ArrayList<>();

        String[][] datiMaghi = {
            {"Merlino",  "Merlino"},
            {"Morgana",  "Morgana"},
            {"Gandalf",  "Gandalf"},
            {"Saruman",  "Saruman"}
        };

        for (String[] dati : datiMaghi){
            int hp            = randomInt(40, 60);
            int mana          = randomInt(20, 40);
            int potenzaMagica = randomInt(5,  10);
            int difesa        = randomInt(3,   8);
            int velocità      = randomInt(1,  10);

            List<Spell> spellBook = new ArrayList<>();
            spellBook.add(palla_di_fuoco);
            spellBook.add(fulmine);
            spellBook.add(meteora);
            spellBook.add(cura_minore);
            spellBook.add(cura_grande);

            maghi.add(new Mago(dati[0], dati[1], hp, hp, mana, mana, potenzaMagica, difesa, velocità, spellBook));
        }

        Arena arena = new Arena(maghi);
        arena.playMach();
        System.out.println("Vincitore: " + arena.getVincitore().getAlieas());
    }

    private static int randomInt(int min, int max){
        return rand.nextInt(max - min + 1) + min;
    }

}