
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RDemo1 extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
       PrintWriter d=resp.getWriter();
    String a= req.getParameter("user");
    String b= req.getParameter("id");
    String c= req.getParameter("pass");
    String e= req.getParameter("gender");
    String f= req.getParameter("blo");
    String g= req.getParameter("status");
    String h= req.getParameter("city");
    try{

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","ruban","wert");
                String query="insert into miniproject values(?,?,?,?,?,?,?)";
                PreparedStatement p=con.prepareStatement(query);
                p.setString(1, a);
                p.setString(2, b);
                p.setString(3, c);
                p.setString(4, e);
                p.setString(5, f);
                p.setString(6, g);
                p.setString(7, h);

                p.executeUpdate();
                con.setAutoCommit(true);
                con.close();
}

    catch(Exception ee){
        d.println(""+ee);
    }

    d.println("<body");

        d.println("background='tab.jpg'>");
  d.println("<h1");
   d.println("text-align:'center'>");
    d.println("<h1>REGISTERED SUCESSFULLY</h1>");
     d.println("<form action='fr.html'>");
              d.println("           <input type='submit' value='BACK TO LOGIN PAGE'>");
              d.println("<form>");
    
    }
}
