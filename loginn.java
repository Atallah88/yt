import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class loginn extends HttpServlet {

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
    
response.setContentType("text/html;charset=UTF-8");
PrintWriter out = response.getWriter(); 
 
String name = request.getParameter("n");
String ps = request.getParameter("p");
    
FileReader fr = new FileReader("e://np.txt");

Scanner s = new Scanner(fr);

HttpSession ses = request.getSession();

boolean f = false;

while(s.hasNext()){
String n = s.next();
String p = s.next();
if(name.equals(n) && ps.equals(p)){
f = true;
ses.setAttribute("name", name);
}   
}
 if(f){
     response.sendRedirect("secureee");
//response.sendRedirect("welcome.html");    
}else{
out.print("<br><h1>incorrect information...</h1><br>");
RequestDispatcher rd = request.getRequestDispatcher("login.html");
rd.include(request, response);    
}
fr.close();
}
}
    