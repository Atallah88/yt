import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class pro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] ch = request.getParameterValues("ch");
        int tot1 = 0, tot2 = 0, tot3 = 0;

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head><title>Order Summary</title></head>");
        out.println("<body>");
        out.println("<h1>Order Summary</h1>");
        out.println("<hr>");

        if (ch != null) {
            for (String item : ch) {
                if (item.equals("Black Hoodie")) {
                    String c1 = request.getParameter("c1");
                    String q1 = request.getParameter("q1");
                    int q11 = Integer.parseInt(q1);
                    int price = 10 * q11;
                    tot1 = price;

                    out.println("<h2>Black Hoodie</h2>");
                    out.println("Size: " + c1 + "<br>");
                    out.println("Quantity: " + q1 + "<br>");
                    out.println("Price: " + price + " KD<br>");
                    out.println("<hr>");
                }

                if (item.equals("White Hoodie")) {
                    String c2 = request.getParameter("c2");
                    String q4 = request.getParameter("q4");
                    int q44 = Integer.parseInt(q4);
                    int price = 10 * q44;
                    tot2 = price;

                    out.println("<h2>White Hoodie</h2>");
                    out.println("Size: " + c2 + "<br>");
                    out.println("Quantity: " + q4 + "<br>");
                    out.println("Price: " + price + " KD<br>");
                    out.println("<hr>");
                }

                if (item.equals("White Pullover")) {
                    String c3 = request.getParameter("c3");
                    String q7 = request.getParameter("q7");
                    int q77 = Integer.parseInt(q7);
                    int price = 12 * q77;
                    tot3 = price;

                    out.println("<h2>White Pullover</h2>");
                    out.println("Size: " + c3 + "<br>");
                    out.println("Quantity: " + q7 + "<br>");
                    out.println("Price: " + price + " KD<br>");
                    out.println("<hr>");
                }
            }

            int total = tot1 + tot2 + tot3;
            out.println("<h2>Total: " + total + " KD</h2>");
        } else {
            out.println("<p>No items were selected.</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }
}

