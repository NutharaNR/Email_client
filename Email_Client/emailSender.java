package Email_Client;

import javax.mail.*;
import java.util.*;
import javax.mail.internet.*;
import javax.mail.Message;


public class emailSender {

    public static void sendEmail(Email email){

        //code to set the server senttings and authentication process
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", true);
        prop.put("mail.smtp.host", "submit.uom.lk");
        prop.put("mail.smtp.port", "587");



        Session session = Session.getInstance(prop, new Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("nnrandrahennedi.20@uom.lk", <password>);
        }
        });


        // creating the message and initializing the details for sending the email
        Message message = new MimeMessage(session);
        try{
        InternetAddress internetAddress = new InternetAddress("nnrandrahennedi.20@uom.lk");
        message.setFrom(internetAddress);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email.getRecipient()));

        // creating the email body
        message.setSubject(email.getSubject());
        
        String content = email.getContent();
        
        MimeBodyPart emailBody= new MimeBodyPart();
        emailBody.setContent(content, "text/plain");
        
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(emailBody);
        
        message.setContent(multipart);
        
        // sending the email
        Transport.send(message);
        System.out.println("Email sent successfully");
        }

        catch(AddressException ae){
        System.out.println("Error" + ae);

        }
        catch(MessagingException me){
        System.out.println("Error"+ me);


        }
    

        

    }


    
}
