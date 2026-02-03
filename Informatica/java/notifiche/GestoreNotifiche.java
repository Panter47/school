import java.util.ArrayList;

public class GestoreNotifiche {
    public static void main(String[] args) {       
        Notifica notifica;
        
        notifica = new EmailNotifica();
        notifica.invia("invio email");
        
        notifica = new SmsNotifica();
        notifica.invia("invio sms");
        
        notifica = new PushNotifica();
        notifica.invia("invio push");
        
        notifica = new PostaNotifica();
        notifica.invia("invio posta");
        
        ArrayList<Notifica> canali = new ArrayList<>();
        canali.add(new EmailNotifica());
        canali.add(new SmsNotifica());
        canali.add(new PushNotifica());
        canali.add(new PostaNotifica());

        for (Notifica n : canali) {
            n.invia("Messaggio uguale per tutti");
        }


    }
    
}
