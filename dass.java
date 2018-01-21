
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
//import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class dass extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter e=resp.getWriter();
        String t= req.getParameter("o");
       try{

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","ruban","wert");

                String query="select * from doc where name=? ";

                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1, t);
                ResultSet rs=pstmt.executeQuery();
               //ResultSetMetaData r=rs.getMetaData()
               // e.println("<hr>");
                e.println("<pre>");
                e.println("<h1 >                                     DOCTORS INFORMATION</h1>");
                e.println("</pre>");
               // e.println("<hr>");
                e.println("<body");

                e.println("background='asd.jpg'>");
                //e.println("<body "background-size:'cover'>");
                e.println("<body style='font-color:blue;'>");
              
                while(rs.next()){
                  //String H=  rs.getString("name");
                  e.println("<pre>");
                  String H=  rs.getString("name");
                  e.println("<h2>    DOCTORS NAME:"+H+"</h2>");
                  String H1=  rs.getString("deg");
                  e.println("<h2>    DEGREE:"+H1+"</h2>");
                  String H2=  rs.getString("sp");
                  e.println("<h2>    SPECLIST:"+H2+"</h2>");
                  String H3=  rs.getString("ex");
                  e.println("<h2 >    EXPERIENCE:"+H3+"</h2>");
                  String H4=  rs.getString("vs");
                  e.println("<h2>    VISITING TIME:"+H4+"</h2>");
                  String H5=  rs.getString("ge");
                  e.println("<h2>    GENDER:"+H5+"</h2>");
                  String H6=  rs.getString("pl");
                  e.println("<h2>    PLACE HE LIVE:"+H6+"</h2>");
                  String H7=  rs.getString("pn");
                  e.println("<h2>    HOSPITAL PN NUMBER:"+H7+"</h2>");
                  String H8=  rs.getString("ad");
                  e.println("<h2>    ADDRESS:"+H8+"</h2>");
                  String H9=  rs.getString("ms");
                  e.println("<h2>    MEDICINE SUGGESTED:"+H9+"</h2>");
                  //Cookie s=new Cookie("name",H);
                  //Cookie v=new Cookie("ID", H1);
                   //resp.addCookie(s);
                  // resp.addCookie(v);
                    e.println("</pre>");
                }

              e.println("<pre>");
              e.println("<form action='iden.html' method='get'>");
              e.println("           <input type='submit' value='NEXT'>");
              e.println("<form>");



                con.setAutoCommit(true);
                con.close();


    }
       catch(Exception ee){

       }

}
}

