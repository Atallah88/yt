import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class cartt extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // الحصول على الجلسة
        HttpSession session = request.getSession();

        // قراءة البيانات من النموذج (من الصفحة السابقة)
        String[] ch = request.getParameterValues("ch"); // المنتجات التي اختارها المستخدم
        String size1 = request.getParameter("size1");
        String size2 = request.getParameter("size2");
        String size3 = request.getParameter("size3");

        String q1 = request.getParameter("q1");
        String q2 = request.getParameter("q2");
        String q3 = request.getParameter("q3");
        String q4 = request.getParameter("q4");
        String q5 = request.getParameter("q5");
        String q6 = request.getParameter("q6");
        String q7 = request.getParameter("q7");
        String q8 = request.getParameter("q8");
        String q9 = request.getParameter("q9");

        // تحديد الأسعار
        int price1 = 25, price2 = 30, price3 = 28; // أسعار الأحذية

        // حساب إجمالي المبلغ والكمية
        int totalPrice = 0;
        int totalQuantity = 0;

        // حساب الكميات لكل منتج
        if (q1 != null && !q1.isEmpty()) totalQuantity += Integer.parseInt(q1);
        if (q2 != null && !q2.isEmpty()) totalQuantity += Integer.parseInt(q2);
        if (q3 != null && !q3.isEmpty()) totalQuantity += Integer.parseInt(q3);
        if (q4 != null && !q4.isEmpty()) totalQuantity += Integer.parseInt(q4);
        if (q5 != null && !q5.isEmpty()) totalQuantity += Integer.parseInt(q5);
        if (q6 != null && !q6.isEmpty()) totalQuantity += Integer.parseInt(q6);
        if (q7 != null && !q7.isEmpty()) totalQuantity += Integer.parseInt(q7);
        if (q8 != null && !q8.isEmpty()) totalQuantity += Integer.parseInt(q8);
        if (q9 != null && !q9.isEmpty()) totalQuantity += Integer.parseInt(q9);

        // حساب إجمالي السعر
        totalPrice += (price1 * (q1 != null && !q1.isEmpty() ? Integer.parseInt(q1) : 0));
        totalPrice += (price2 * (q2 != null && !q2.isEmpty() ? Integer.parseInt(q2) : 0));
        totalPrice += (price3 * (q3 != null && !q3.isEmpty() ? Integer.parseInt(q3) : 0));

        // تخزين البيانات في الجلسة
        session.setAttribute("ch", ch);
        session.setAttribute("q1", q1);
        session.setAttribute("q2", q2);
        session.setAttribute("q3", q3);
        session.setAttribute("q4", q4);
        session.setAttribute("q5", q5);
        session.setAttribute("q6", q6);
        session.setAttribute("q7", q7);
        session.setAttribute("q8", q8);
        session.setAttribute("q9", q9);
        session.setAttribute("tot", totalPrice);

        // عرض محتويات عربة التسوق
        out.println("<h2>Your Cart</h2>");
        if (ch != null) {
            for (String item : ch) {
                out.println("<p>Product: " + item + "</p>");

                // عرض الكميات والأسعار الخاصة بكل منتج
                if ("Black Sneakers".equals(item)) {
                    out.println("<p>Size: " + size1 + " Quantity: " + q1 + " Price: " + (price1 * (q1 != null && !q1.isEmpty() ? Integer.parseInt(q1) : 0)) + " KD</p>");
                } else if ("White Sneakers".equals(item)) {
                    out.println("<p>Size: " + size2 + " Quantity: " + q2 + " Price: " + (price2 * (q2 != null && !q2.isEmpty() ? Integer.parseInt(q2) : 0)) + " KD</p>");
                } else if ("Red Sneakers".equals(item)) {
                    out.println("<p>Size: " + size3 + " Quantity: " + q3 + " Price: " + (price3 * (q3 != null && !q3.isEmpty() ? Integer.parseInt(q3) : 0)) + " KD</p>");
                }
            }
        }

        out.println("<br><strong>Total: </strong>" + totalPrice + " KD");
        out.println("<br>Enjoy Your Shopping!");
    }
}


