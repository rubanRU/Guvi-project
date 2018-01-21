
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RDemo3 extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter e=resp.getWriter();
        String t= req.getParameter("id");
        String m=  req.getParameter("pass");
       try{

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","ruban","wert");

                String query="select * from miniproject where ID=? ";

                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, t);
                ResultSet rs=pstmt.executeQuery();
               // ResultSetMetaData r=rs.getMetaData()
                e.println("<hr>");
                e.println("<pre>");
                e.println("<h1 >                                     PATIENT DATABASE</h1>");
                e.println("</pre>");
                e.println("<hr>");
                e.println("<body style='background-color:lightblue;'>");
                e.println("<body style='font-color:blue;'>");
          
                while(rs.next()){
                  String H=  rs.getString("NAME");
                  e.println("<pre>");
                  e.println("<h2>    PATIENT NAME:"+H+"</h2>");
                  String H1=  rs.getString("ID");
                  e.println("<h2>    ID:"+H1+"</h2>");
                  String H2=  rs.getString("PASSWORD");
                  e.println("<h2>    PASSWORD:"+H2+"</h2>");
                  String H3=  rs.getString("GENDER");
                  e.println("<h2 >    GENDER:"+H3+"</h2>");
                  String H4=  rs.getString("STATUS");
                  e.println("<h2>    STATUS:"+H4+"</h2>");
                  String H5=  rs.getString("CITY");
                  e.println("<h2>    CITY:"+H5+"</h2>");
                  Cookie s=new Cookie("name",H);
                  Cookie v=new Cookie("ID", H1);
                   resp.addCookie(s);
                   resp.addCookie(v);
                    e.println("</pre>");
                }
                e.println("<body");
               e.println("background='tab.jpg'>");
              e.println("<pre>");
              e.println("<h3>                                          please verify the information and verify if u want to modify click modify else next</h3>");
              e.println("<pre>");
               e.println("<form action='inn.jsp'>");
              e.println("           <input type='submit' value='NEXT'>");
              e.println("</form>");
              e.println("<br>");
              e.println("<br>");

               e.println("<form action='innn.jsp'>");
              e.println("           <input type='submit' value='CLICK TO MODIFY PATIENT DETAILS'>");
              e.println("</form>");

              e.println("<br/>");

                
                con.setAutoCommit(true);
                con.close();
               test();


    }
       catch(Exception ee){

       }



    }
    void test(){

    }
}
