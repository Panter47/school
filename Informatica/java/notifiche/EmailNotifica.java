public class EmailNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.out.println("Invio email con il messaggio: " + messaggio);
        return true;
    }
    
}
