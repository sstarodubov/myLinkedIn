
package com.javabycode.springmvc.service;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Service;

@Service("emailService")
public class EmailService {

    static Properties mailServerProperties;
    static Session getMailSession;
    static MimeMessage generateMailMessage;

    public void send(String email, String password) throws AddressException, MessagingException {
        generateAndSendEmail(email, password);
        System.out.println("\n\n ===> Your Java Program has just sent an Email successfully. Check your email..");
    }

    public void generateAndSendEmail(String toEmail, String newPassword) throws AddressException, MessagingException {

        System.out.println("\n 1st ===> setup Mail Server Properties..");
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");
        System.out.println("Mail Server Properties have been setup successfully..");

        System.out.println("\n\n 2nd ===> get Mail Session..");
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
        generateMailMessage.addRecipient(Message.RecipientType.CC, new InternetAddress(toEmail));
        generateMailMessage.setSubject("Technical support.");
        String emailBody = "Your new password: " + newPassword + "<br> Regards, <br>MyLinkedIn Admin";
        generateMailMessage.setContent(emailBody, "text/html");
        System.out.println("Mail Session has been created successfully..");

        System.out.println("\n\n 3rd ===> Get Session and Send mail");
        Transport transport = getMailSession.getTransport("smtp");
        transport.connect("smtp.gmail.com", "javastarodubovsergei@gmail.com", "");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }
}