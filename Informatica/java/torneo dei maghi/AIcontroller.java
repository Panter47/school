import java.util.List;

public class AIcontroller {

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

    private static Spell getMigliorSpell(Mago mago, String tipo){
        Spell migliore = null;
        for (Spell s : mago.getSpellBook()){
            if (s.getTipo().equalsIgnoreCase(tipo) && mago.canCast(s)){
                if (migliore == null || s.getValoreBase() > migliore.getValoreBase())
                    migliore = s;
            }
        }
        return migliore;
    }

    private static Mago getBersaglio(List<Mago> avversari){
        Mago bersaglio = avversari.get(0);
        for (Mago m : avversari)
            if (m.getHp() < bersaglio.getHp()) bersaglio = m;
        return bersaglio;
    }

}