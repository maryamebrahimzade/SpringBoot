package ir.mapsa.maryamebrahimzadepayment.services.notifications;

import ir.mapsa.maryamebrahimzadepayment.models.Notify;

public class NotificationFactory {
    public static BaseNotification createNotification(Notify notify){
        if(notify==null){
            return null;
        }
        switch (notify) {
            case SMS:
                return new SmsNotification();
            case EMAIL:
                return new EmailNotification();
            default:
                throw new IllegalArgumentException("unknown notify");
        }
    }
}
