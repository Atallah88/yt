import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String[] ch = request.getParameterValues("ch");

        out.println("<html><head><title>Cart</title></head><body>");
        out.println("<h1>Your Cart</h1><hr>");

        int total = 0;

        if (ch != null) {
            for (String item : ch) {
                switch (item) {
                    case "Black Hoodie": {
                        String size = request.getParameter("c1");
                        String quantity = getQuantityForSize(request, size, "q1", "q2", "q3");
                        if (quantity != null && !quantity.isEmpty() && !quantity.equals("0")) {
                            int price = Integer.parseInt(quantity) * 10;
                            total += price;
                            out.println("<h3>Black Hoodie</h3>");
                            out.println("Size: " + size + "<br>");
                            out.println("Quantity: " + quantity + "<br>");
                            out.println("Price: " + price + " KD<br><hr>");
                        }
                        break;
                    }
                    case "White Hoodie": {
                        String size = request.getParameter("c2");
                        String quantity = getQuantityForSize(request, size, "q4", "q5", "q6");
                        if (quantity != null && !quantity.isEmpty() && !quantity.equals("0")) {
                            int price = Integer.parseInt(quantity) * 10;
                            total += price;
                            out.println("<h3>White Hoodie</h3>");
                            out.println("Size: " + size + "<br>");
                            out.println("Quantity: " + quantity + "<br>");
                            out.println("Price: " + price + " KD<br><hr>");
                        }
                        break;
                    }
                    case "White Pullover": {
                        String size = request.getParameter("c3");
                        String quantity = getQuantityForSize(request, size, "q7", "q8", "q9");
                        if (quantity != null && !quantity.isEmpty() && !quantity.equals("0")) {
                            int price = Integer.parseInt(quantity) * 12;
                            total += price;
                            out.println("<h3>White Pullover</h3>");
                            out.println("Size: " + size + "<br>");
                            out.println("Quantity: " + quantity + "<br>");
                            out.println("Price: " + price + " KD<br><hr>");
                        }
                        break;
                    }
                }
            }

            out.println("<h2>Total: " + total + " KD</h2>");
        } else {
            out.println("<p>No products selected.</p>");
        }

        out.println("</body></html>");
        out.print("<a href='index.html'>home</a>");
    }

    private String getQuantityForSize(HttpServletRequest request, String size, String smallQ, String mediumQ, String largeQ) {
        if (size == null) return null;
        switch (size) {
            case "small":
                return request.getParameter(smallQ);
            case "medium":
                return request.getParameter(mediumQ);
            case "large":
                return request.getParameter(largeQ);
            default:
                return null;
        }
    }
}
