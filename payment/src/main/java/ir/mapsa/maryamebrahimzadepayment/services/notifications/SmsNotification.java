package ir.mapsa.maryamebrahimzadepayment.services.notifications;

import org.springframework.stereotype.Service;

@Service
public class SmsNotification implements BaseNotification{

    @Override
    public void notifyUser(NotificationText text) {
        System.out.println("sms is send .. .  .\n " + text);
    }
}
