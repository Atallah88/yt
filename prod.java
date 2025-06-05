import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class prod extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)   
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter();

String ch = request.getParameter("ch"); 

HttpSession ses = request.getSession();

ses.setAttribute("ch", ch);

out.print(ch);

}
}
