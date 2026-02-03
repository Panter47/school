public class PostaNotifica implements Notifica {
    public boolean invia(String messaggio) {
        System.out.println("Invio non riuscito notifica via posta con il messaggio: " + messaggio);
        return false;
    }
}
