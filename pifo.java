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


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 public class pifo extends HttpServlet{

    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      resp.setContentType("text/html");
      PrintWriter s=resp.getWriter();
      String m=  req.getParameter("y");
      String n=  req.getParameter("m");
       s.println("<body");
       //s.println("background='3.jpg'>");
       s.println("<style>");
      
       s.println("<pre>");
       s.println("</style>");
       s.println("</br>0");
       s.println("<h1>                                YOUR RESPONSE HAVE BEEN SENT TO OUR ADMIN  </h1>");
       s.println("<br>");
       s.println("<br>");
        s.println("<form action='fe.html'>");
              s.println("           <input type='submit' value='FEED BACK FORM'>");
              s.println("</form>");
      // s.println("<h1>                                         THANK YOU </h1>");
       s.println("</pre>");
        this.info(m,n );

    }
    void info(String o,String k){
                 final String username = "rubanru36@gmail.com";
		final String password = "rubanrockkkk";

                final String from = "rubanru36@gmail.com";
                final String to =   " rubanru36@gmail.com";
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
    messageBodyPart1.setText(o);


    MimeBodyPart messageBodyPart2 = new MimeBodyPart();

    String filename = k;//change accordingly
    DataSource source = new FileDataSource(filename);
    messageBodyPart2.setDataHandler(new DataHandler(source));
    messageBodyPart2.setFileName(filename);



    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(messageBodyPart1);
    multipart.addBodyPart(messageBodyPart2);


    message.setContent(multipart);


    Transport.send(message);


   }catch (MessagingException ex) {ex.printStackTrace();}

 }

    }


