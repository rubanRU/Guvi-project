

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;



class cc{
 public static void main(String [] args){

		final String username = "rubanru36@gmail.com";
		final String password = "rubanrockkkk";

                final String from = "rubanru36@gmail.com";
                final String to = "krishnamanickavelu@gmail.com";

		Properties props = new Properties();

		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");



                Authenticator a=new Authenticator()
                {

                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }

                };

                Session session = Session.getInstance(props, a);


  try{
    Message message = new MimeMessage(session);
    message.setFrom(new InternetAddress(from));
    message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
    message.setSubject("Message Alert");


    BodyPart messageBodyPart1 = new MimeBodyPart();
    messageBodyPart1.setText("This is message body");


   // MimeBodyPart messageBodyPart2 = new MimeBodyPart();

   // String filename = "D:\\Uploads\\01.jpg";//change accordingly
    //DataSource source = new FileDataSource(filename);
   // messageBodyPart2.setDataHandler(new DataHandler(source));
    //messageBodyPart2.setFileName(filename);
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    //multipart.addBodyPart(messageBodyPart2);


    message.setContent(multipart);

    //7) send message
    Transport.send(message);

   System.out.println("message sent....");
   }catch (MessagingException ex) {ex.printStackTrace();}
 }
}
