public class Orario {
    private int ore;
    private int minuti;
    private int secondi;
    
    
    public Orario(int ore, int minuti, int secondi) {
        setOre(ore);
        setMinuti(minuti);
        setSecondi(secondi);
    }

    public Orario(){
        ore=0;
        minuti=0;
        secondi=0;
    }
    
    public int getOre() {
        return ore;
    }

    public int getMinuti() {
        return minuti;
    }

    public int getSecondi() {
        return secondi;
    }

    public void setOre(int ore) {
        if( ore<24) 
            this.ore=ore;
        else 
            this.ore=0;
    }

    public void setMinuti(int minuti) {
        if( minuti<60) 
            this.minuti=minuti;
        else 
            this.minuti=0;
    }

    public void setSecondi(int secondi) {
        if( secondi<60) 
            this.secondi=secondi;
        else 
            this.secondi=0;
    }

    public void tic() {
        int sec=getSecondi();
        int min= getMinuti();
        int or=getOre();
        sec++;
        this.setSecondi(sec);
        if(sec>59) {
            min++;
            this.setMinuti(min);
            if(min>59) {
                or++;
                this.setOre(or);
            }
        }
    }

    public void aggiungiMinuti(int m) {
        m=m*60;
        for(int i=0; i<m;i++) {
            this.tic();
        }
        /*setOre((getOre()+ ((getOre() + m) / 60)) % 24);
        setMinuti(getMinuti() + ((getMinuti() + minuti) %60));*/
    }

    public String mostra() {
        return String.format("%02d:%02d:%02d", getOre(),getMinuti(),getSecondi());
    }

    public boolean ugualeA(Orario altro) {
        if(this.getOre()== altro.getOre() && this.getMinuti()==altro.getMinuti() && this.getSecondi()== altro.getSecondi())
            return true;
        return false;
    }
}