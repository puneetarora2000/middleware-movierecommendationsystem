package drools.email;

import java.util.Properties;
 
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.Message.RecipientType;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
 
public class SendMail {
 
    private String from;
    private String to;
    private String subject;
    private String text;
 
    public SendMail(String from, String to, String subject, String text){
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.text = text;
    }
 
    public void send(){
    	System.out.println("Sending email  - test");
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.port", "587");
        props.put("mail." + "smtp" + ".auth", "true");
        
        
        Session mailSession = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication("ggvishnu29@gmail.com", "xxxxxxxxxxxx");
            }
          });
        
        
        System.out.println("Sending email  - test1");
        //Session mailSession = Session.getDefaultInstance(props);
        Message simpleMessage = new MimeMessage(mailSession);
 
        System.out.println("Sending email  - test2");
        InternetAddress fromAddress = null;
        InternetAddress toAddress = null;
        try {
            fromAddress = new InternetAddress(from);
            toAddress = new InternetAddress(to);
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
 
        try {
            simpleMessage.setFrom(fromAddress);
            simpleMessage.setRecipient(RecipientType.TO, toAddress);
            simpleMessage.setSubject(subject);
            simpleMessage.setText(text);
            System.out.println("Sending email  - test3");
            //Transport.send(simpleMessage);
            String protocol = "smtp";
            Transport t = mailSession.getTransport(protocol);
            t.connect("ggvishnu29@gmail.com", "workhard1!");
            Transport.send(simpleMessage);
            //t.send(simpleMessage, "ggvishnu29@gmail.com");
            System.out.println("Sending email  - test4");
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
