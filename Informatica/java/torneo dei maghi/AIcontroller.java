import java.util.List;

public class AIcontroller {

    /**
     * Esegue il turno di un mago, decidendo se attaccare, curarsi o riposare.
     * @param mago il mago che deve eseguire il turno
     * @param maghi la lista di tutti i maghi presenti nell'arena
     */
    public static void eseguiTurno(Mago mago, List<Mago> maghi){
        List<Mago> avversari = new java.util.ArrayList<>();
        for (Mago m : maghi)
            if (m.isAlive() && m != mago) avversari.add(m);

        if (avversari.isEmpty()) return;

        Spell cura = getMigliorSpell(mago, "cura");
        Spell attacco = getMigliorSpell(mago, "attacco");

        double percentualeHp = (double) mago.getHp() / mago.getHpMax();

        if (percentualeHp < 0.30 && cura != null && mago.canCast(cura)){
            mago.cast(cura, mago);
            return;
        }

        if (attacco != null && mago.canCast(attacco)){
            Mago bersaglio = getBersaglio(avversari);
            mago.cast(attacco, bersaglio);
            return;
        }

        mago.rest();
    }

    /**
     * Restituisce la miglior spell di un certo tipo che il mago può lanciare, o null se non ne ha nessuna disponibile.
     * @param mago il mago per cui cercare la spell
     * @param tipo il tipo di spell da cercare ("attacco" o "cura")
     * @return la miglior spell di quel tipo che il mago può lanciare, o null se non ne ha nessuna disponibile
     */
    public static Spell getMigliorSpell(Mago mago, String tipo){
        Spell migliore = null;
        for (Spell s : mago.getSpellBook()){
            if (s.getTipo().equalsIgnoreCase(tipo) && mago.canCast(s)){
                if (migliore == null || s.getValoreBase() > migliore.getValoreBase())
                    migliore = s;
            }
        }
        return migliore;
    }

    /**
     * Restituisce il mago avversario con gli hp più bassi tra quelli ancora vivi.
     * @param avversari la lista dei maghi avversari ancora vivi
     * @return il mago avversario con gli hp più bassi
     */
    public static Mago getBersaglio(List<Mago> avversari){
        Mago bersaglio = avversari.get(0);
        for (Mago m : avversari)
            if (m.getHp() < bersaglio.getHp()) bersaglio = m;
        return bersaglio;
    }

}