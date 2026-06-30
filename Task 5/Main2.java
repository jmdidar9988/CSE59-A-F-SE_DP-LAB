interface MessageSender{
    void sendMessage (String message);
}
class EmailSender implements MessageSender{
    @Override
    public void sendMessage(String message){
        System.out.println ("Sending email:" + message);

    }
}
class SMSSender implements MessageSender{
    @Override
    public void sendMessage(String message){
        System.out.println ("Sending SMS:" + message);

    }
}

class NotificationService {
    private MessageSender sender;
    public NotificationService (MessageSender sender){
        this.sender = sender;
    }
public void alertUser(String msg){
    sender.sendMessage(msg);
}
}

public class Main2 {
    public static void main (String[] args) {
        System.out.println ("Testing Email Injection");
        MessageSender emailSender = new EmailSender();
        NotificationService emailService = new NotificationService (emailSender);
        emailService.alertUser("Your account has been created");

    
        System.out.println ("\n Testing sms injetion");

        MessageSender smsSender = new SMSSender();
        NotificationService smsService = new NotificationService(smsSender);
        smsService.alertUser("Your 2FA is 378373");
}   
}
