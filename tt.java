
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class tt extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       resp.setContentType("text/html");
        PrintWriter e=resp.getWriter();
        String t= req.getParameter("po");
        if( t.equals("XUAOQ")){
            RequestDispatcher rd=req.getRequestDispatcher("/mm.html");
             rd.forward(req, resp);
        }
      else {
            RequestDispatcher rd=req.getRequestDispatcher("/h.html");
             rd.forward(req, resp);
        }
    }

}