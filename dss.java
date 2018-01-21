
import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class dss extends HttpServlet
{
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
    {
      response.setContentType("text/html");
      PrintWriter out=response.getWriter();

        String s1=request.getParameter("msg");

        if(!s1.equals(""))
        {
            try
            {
                s1=s1+"%";

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection co=DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE","ruban","wert");

                String query="select * from doctor where dname like ?";
                PreparedStatement st=co.prepareStatement(query);

                st.setString(1,s1);
                ResultSet rs=st.executeQuery();
                //String val="";
                String val1="";
                String val2="";
                String val3="";
                String val4="";
                String h="127";
                //out.println("<h2>DOCTORS AVALIABLE ARE</h2>");
                while(rs.next())
                {
                   //val=rs.getString("dise");
                   val1=rs.getString("dname");
                   val2=rs.getString("hosp");
                   val3=rs.getString("vish");
                   //val4=rs.getString("city");
                   out.println("<pre>");
                  // out.println("<h3>    DISEASE:"+val+"</h3>");
                   out.println("<h3>    DOCTOR NAME: "+val1+"</h3>");
                   //out.println("<h3>    HOSPITAL:"+val2+"</h3>");
                   //out.println("<h3>    VISITING HOURS:"+val3+"</h3>");
                   //out.println( "<h3>   YOUR TOKEN NUMBER :"+h+"</h3>");
                   
                  // out.println("<h3>    CITY:"+val4+"</h3>");
                   out.println("</pre>");
                }


                if(val1==""){

                    out.println("<h3>NON OF THE DOCTORS ARE AVALIABLE</h3>");
                }
                co.close();
             }
            catch(Exception e)
            {
                out.println("     "+e);
            }
        }
      out.close();
    }
}
