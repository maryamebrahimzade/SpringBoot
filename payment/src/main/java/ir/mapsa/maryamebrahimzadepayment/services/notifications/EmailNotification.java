package ir.mapsa.maryamebrahimzadepayment.services.notifications;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailNotification implements BaseNotification{
    @Override
    public void notifyUser(NotificationText text) {

//        Properties prop = new Properties();
//        prop.put("mail.smtp.auth", true);
//        prop.put("mail.smtp.starttls.enable", "true");
//        prop.put("mail.smtp.host", "smtp.gmail.com");
//
//        prop.put("mail.debug", "true");
//        prop.put("mail.smtp.ssl.enable", "true");
//
//        prop.put("mail.smtp.port", "465");
//
//
//        Session session = Session.getInstance(prop, new Authenticator() {
//            @Override
//            protected PasswordAuthentication getPasswordAuthentication() {
//                return new PasswordAuthentication("  usseerrrr ", "  passs wooord   ");
//            }
//        });
//
//        try {
//            Message message = new MimeMessage(session);
//            message.setFrom(new InternetAddress("info@mybank.com"));
//            message.setRecipients(
//                    Message.RecipientType.TO, InternetAddress.parse("ma.ebrahimzadeh@Gmail.com"));
//            message.setSubject("new Transaction: " + text.getAmount() + " " + text.getDate());
//
//
//            String msg = text.toString();
//
//            MimeBodyPart mimeBodyPart = new MimeBodyPart();
//            mimeBodyPart.setContent(msg, "text/html; charset=utf-8");
//
//            Multipart multipart = new MimeMultipart();
//            multipart.addBodyPart(mimeBodyPart);
//
//            message.setContent(multipart);
//            Transport.send(message);
//
//        } catch (MessagingException e) {
//
//            throw new RuntimeException(e);
//        }
    }

}
