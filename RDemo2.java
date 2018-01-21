
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

public class RDemo2 extends HttpServlet{

    @Override
    public  void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter s=resp.getWriter();
      String m=  req.getParameter("id");
      String n=  req.getParameter("pass");


        try{

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","ruban","wert");

                String query="select ID from miniproject where ID=? and PASSWORD=?";

                PreparedStatement pstmt=con.prepareStatement(query);
                pstmt.setString(1,m);
                pstmt.setString(2,n);

                ResultSet rs=pstmt.executeQuery();
                boolean check=false;
                if(rs.next()){
                    check=true;
                }
                else{

                    check=false;

                }
             if(check){
                 RequestDispatcher rd=req.getRequestDispatcher("/RDemo3");
                  rd.forward(req, resp);
             }
 else{
     RequestDispatcher rd=req.getRequestDispatcher("/fr.html");
                  rd.forward(req, resp);
 }

                con.setAutoCommit(true);
                con.close();

    }
        catch(Exception ee){

        }


}
}
