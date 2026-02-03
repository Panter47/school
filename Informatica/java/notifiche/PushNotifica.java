public class PushNotifica implements Notifica {
    @Override
    public boolean invia(String messaggio) {
        System.out.println("Invio notifica push con il messaggio: " + messaggio);
        return true;
    }
}
