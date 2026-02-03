import java.util.ArrayList;

public class RegistroSpese {
    private ArrayList<Spesa> registro;

    public RegistroSpese(int dim) {
        this.registro = new ArrayList<Spesa>(dim);
    }

    public void aggiungiSpesa(Spesa spesa) {
        registro.add(spesa);
    }

    /**
     * restituisco la spesa complessiva
     * @return
     */
    public double spesaTot() {
        double tot=0;
        for(Spesa k : registro)
            tot+=k.getImporto();
        return tot;
    }

    /**
     * calcola la media delle spese
     * @return
     */
    public double spesaMedia() {
        int tot=0, i=0;
        for(Spesa k : registro) {
            tot+=k.getImporto();
            i++;
        }
        return tot/i;
    }
    /**
     * calcola la spesa massima
     * @return
     */
    public double spesaMax() {
        double max=0;
        for(Spesa k : registro) {
            if(k.getImporto()>max) 
                max=k.getImporto();
        }
        return max;
    }

    /**
     * calcola la spesa minima
     * @return
     */
    public double spesamin() {
        double min=1000000000;
        for (Spesa k : registro) {
            if(k.getImporto()<min) 
                min=k.getImporto();
        }
        return min;
    }

    /**
     * calcola la categoria con la media più alta
     * @return
     */
    public String catMediaMax() {
        double ali=0, a=0, trasp=0, t=0, svago=0, s=0, istru=0, i=0, altro=0, al=0;
        double mAli=0,mTrasp=0,mSvago=0,mIstru=0,mAltro=0;
        for(Spesa k : registro) {
            if(k.getCategoria().equals("alimentari")){
                ali+=k.getImporto();
                a++;
            }
            else if(k.getCategoria().equals("trasporto")) {
                trasp+=k.getImporto();
                t++;
            }
            else if(k.getCategoria().equals("svago")) {
                svago+=k.getImporto();
                s++;
            }
            else if(k.getCategoria().equals("istruzione")) {
                istru+=k.getImporto();
                i++;
            }
            else  {
                altro+=k.getImporto();
                al++;
            }
        }
        mAli=ali/a;
        mTrasp=trasp/t;
        mSvago=svago/s;
        mIstru=istru/i;
        mAltro=altro/al;
        if(mAli>mTrasp && mAli>mSvago && mAli>mIstru && mAli>mAltro)
            return"alimentari";
        else if(mAli<mTrasp && mTrasp>mSvago && mTrasp>mIstru && mTrasp>mAltro)
            return"trasporto";
        else if(mSvago>mAli && mTrasp<mSvago && mSvago>mIstru && mSvago>mAltro)
            return"svago";
        else if(mIstru>mAli && mTrasp<mIstru && mSvago<mIstru && mIstru>mAltro)
            return"istruzione";
        return "altro";
    }

    /**
     * calcola la categoria con la media più bassa
     * @return
     */
    public String catMediamin() {
        double ali=0, a=0, trasp=0, t=0, svago=0, s=0, istru=0, i=0, altro=0, al=0;
        double mAli=0,mTrasp=0,mSvago=0,mIstru=0,mAltro=0;
        for(Spesa k : registro) {
            if(k.getCategoria().equals("alimentari")){
                ali+=k.getImporto();
                a++;
            }
            else if(k.getCategoria().equals("trasporto")) {
                trasp+=k.getImporto();
                t++;
            }
            else if(k.getCategoria().equals("svago")) {
                svago+=k.getImporto();
                s++;
            }
            else if(k.getCategoria().equals("istruzione")) {
                istru+=k.getImporto();
                i++;
            }
            else  {
                altro+=k.getImporto();
                al++;
            }
        }
        mAli=ali/a;
        mTrasp=trasp/t;
        mSvago=svago/s;
        mIstru=istru/i;
        mAltro=altro/al;
        if(mAli<mTrasp && mAli<mSvago && mAli<mIstru && mAli<mAltro)
            return"alimentari";
        else if(mAli>mTrasp && mTrasp<mSvago && mTrasp<mIstru && mTrasp<mAltro)
            return"trasporto";
        else if(mSvago<mAli && mTrasp>mSvago && mSvago<mIstru && mSvago<mAltro)
            return"svago";
        else if(mIstru<mAli && mTrasp>mIstru && mSvago>mIstru && mIstru<mAltro)
            return"istruzione";
        return "altro";
    }
    

    /**
     * restituisce il metodo di pagamento con il totale più alto
     * @return
     */
    public String pagTotMax() {
        double contanti=0, carta=0,bonifico=0;

        for(Spesa k : registro) {
            if(k.getModPagamento().equals("contanti"))
                contanti+=k.getImporto();
            else if(k.getModPagamento().equals("carta"))
                carta+=k.getImporto();
            else 
                bonifico+=k.getImporto();
        }
        if(contanti>carta && contanti>bonifico)
            return "contanti";
        else if (carta>contanti && carta>bonifico)
            return "carta di credito";
        return "bonifico";
    }


    /**
     * restituisce il metodo di pagamento con il totale più basso
     * @return
     */
    public String pagTotMin() {
        double contanti=0, carta=0,bonifico=0;

        for(Spesa k : registro) {
            if(k.getModPagamento().equals("contanti"))
                contanti+=k.getImporto();
            else if(k.getModPagamento().equals("carta"))
                carta+=k.getImporto();
            else 
                bonifico+=k.getImporto();
        }
        if(contanti<carta && contanti<bonifico)
            return "contanti";
        else if (carta<contanti && carta<bonifico)
            return "carta di credito";
        return "bonifico";
    }


    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Spesa k : registro) {
            sb.append(k).append("\n");
        }
        return sb.toString();
    }

    
}

