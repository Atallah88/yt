import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class secureee extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter(); 

HttpSession ses = request.getSession();

if(ses.getAttribute("name") != null){
response.sendRedirect("securer.jsp");
}else{
out.print("you are not logged in ");    
}

}
}