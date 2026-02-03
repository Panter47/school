public class SmsNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.out.println("Invio SMS con il messaggio: " + messaggio);
        return true;
    }
}
