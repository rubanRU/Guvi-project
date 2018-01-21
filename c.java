import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class c extends HttpServlet
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

                String query="select * from medi where name like ?";
                PreparedStatement st=co.prepareStatement(query);

                st.setString(1,s1);
                ResultSet rs=st.executeQuery();
                String val="";
                String val1="";
                String val2="";
                String val3="";
               // String val4="";
                //out.println("<h2>DOCTORS AVALIABLE ARE</h2>");
                while(rs.next())
                {

                   val=rs.getString("name");
                   val1=rs.getString("medicine");
                   val2=rs.getString("co");
                   val3=rs.getString("na");
                   //val4=rs.getString("city");
                   out.println("<pre>");
                   out.println("<table>");
                   out.println("<tr>");
                       out.println("<td colspan='2'>");
                   out.println("<h3>    DISEASE:"+val+"</h3>");
                   out.println("<h3>    MEDICINE SUGGESTED: "+val1+"</h3>");
                   out.println("<h3>    SYMPTOMS:"+val2+"</h3>");
                   out.println("<h3>    PREVENTION:"+val3+"</h3>");
                    out.println("</td>");
                    out.println("</tr>");
                    out.println("</table>");
                  // out.println("<h3>    CITY:"+val4+"</h3>");
                   out.println("</pre>");
                }


                if(val==""){

                    out.println("<h3>NON OF THE MEDICINE"
                            + " ARE AVALIABLE</h3>");
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
