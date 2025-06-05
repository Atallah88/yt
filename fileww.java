import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class fileww extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String nm = request.getParameter("n");
        String ps = request.getParameter("p");
        String tel = request.getParameter("t");
        String age = request.getParameter("a");
        String email = request.getParameter("email");

        reg r = new reg();
        out.print(r.save(nm,ps,tel,age,email));

        out.print("Your Data are in The Files... Thank You.");
        out.print("<br><a href='index.html'>Home</a>");
    }
}
