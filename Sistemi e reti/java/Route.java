import java.util.Arrays;

public class Route {

    private int[] indirizzoDestinazione;
    private int CIDR;
    private int[] nextHop;
    private Interfaccia interfaccia;


    public Route(int[] indirizzoDestinazione, int CIDR, int[] nextHop, Interfaccia interfaccia) {

        if (indirizzoDestinazione.length != 4 || nextHop.length != 4) {
            throw new IllegalArgumentException("Gli indirizzi devono essere rappresentati come array di 4 interi.");
        }

        if (CIDR < 0 || CIDR > 32) {
            throw new IllegalArgumentException("Il valore CIDR deve essere compreso tra 0 e 32.");
        }

        this.indirizzoDestinazione = indirizzoDestinazione;
        this.CIDR = CIDR;
        this.nextHop = nextHop;
        this.interfaccia = interfaccia;
    }


    public int[] getIndirizzoDestinazione() {
        return indirizzoDestinazione;
    }


    public void setIndirizzoDestinazione(int[] indirizzoDestinazione) {
        this.indirizzoDestinazione = indirizzoDestinazione;
    }


    public int getCIDR() {
        return CIDR;
    }


    public void setCIDR(int cIDR) {
        CIDR = cIDR;
    }


    public int[] getNextHop() {
        return nextHop;
    }


    public void setNextHop(int[] nextHop) {
        this.nextHop = nextHop;
    }


    public Interfaccia getInterfaccia() {
        return interfaccia;
    }


    public void setInterfaccia(Interfaccia interfaccia) {
        this.interfaccia = interfaccia;
    }

    /**
     * Verifica se l'indirizzo fornito corrisponde alla route
     * @param indirizzo l'indirizzo da verificare
     * @return true se l'indirizzo corrisponde alla route, altrimenti false
     */

    public boolean matches(int[] indirizzo) {
        
        int mask = getCIDR();
        for (int i = 0; i < 4; i++) {
            if (mask <8) {
                int maskOtteto = (0xFF << (8 - mask)) & 0xFF;
                if ((indirizzo[i] & maskOtteto) == (getIndirizzoDestinazione()[i] & maskOtteto)) {
                    return true;
                }
                return false;
            }
            else{
                if (indirizzo[i] != getIndirizzoDestinazione()[i]) {
                    return false;
                }
                mask-=8;
            }
        }

        return true;
    }


    @Override
    public String toString() {
        return "Route indirizzoDestinazione=" + Arrays.toString(indirizzoDestinazione) + ", CIDR=" + CIDR
                + ", nextHop=" + Arrays.toString(nextHop) + ", interfaccia=" + interfaccia;
    }
}
