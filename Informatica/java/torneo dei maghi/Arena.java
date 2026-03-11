import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private List<Mago> maghi;
    private Random rand;
    private int turno;

    public Arena(List<Mago> maghi) {
        this.maghi = maghi;
        this.rand = new Random();
        this.turno = 0;
    }


    public void playMach(){
        while (getAliveMago().size() > 1){
            turno++;
            playTurn();
        }
    }

    public void playTurn(){
        List<Mago> maghiAttivi = getAliveMago();
        ordinaPerVelocita(maghiAttivi);

        for (Mago mago : maghiAttivi){
            if (!mago.isAlive()) continue;
            if (getAliveMago().size() <= 1) break;
            AIcontroller.eseguiTurno(mago, maghi);
        }
    }

    private void ordinaPerVelocita(List<Mago> lista){
        for (int i = 0; i < lista.size() - 1; i++){
            for (int j = 0; j < lista.size() - 1 - i; j++){
                if (lista.get(j).getVelocità() < lista.get(j + 1).getVelocità()){
                    Mago temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
    }

    public List<Mago> getAliveMago(){
        List<Mago> vivi = new ArrayList<>();
        for (Mago m : maghi)
            if (m.isAlive()) vivi.add(m);
        return vivi;
    }

    public Mago getVincitore(){
        List<Mago> vivi = getAliveMago();
        if (vivi.size() == 1) return vivi.get(0);
        return null;
    }

}