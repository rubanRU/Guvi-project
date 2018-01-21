
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class RDemo5 extends HttpServlet{

    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter s=resp.getWriter();

      String m= req.getParameter("na");
      int  y=Integer.parseInt(m);
      String n= req.getParameter("ch");
      String o= req.getParameter("n");

        try{

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","ruban","wert");
                String query="update miniproject set id=? where name=?";
                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1,n);
                pstmt.setString(2,o);
                pstmt.executeUpdate();
                con.setAutoCommit(true);
                con.close();
               s.println("<h1>registration sucess</h1>");
                s.println("<form action='fr.html'>");
              s.println("           <input type='submit' value='BACK TO LOGIN PAGE'>");
              s.println("</form>");

    }
        catch(Exception ee){

        }

}
}
