

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/juros-calc.html"})
public class jurosCalc extends HttpServlet {
    double taxa, tempo, capital;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       PrintWriter out = response.getWriter();
        try {
            taxa = (Double.parseDouble(request.getParameter("taxa"))) / 100;
        } catch (NumberFormatException | ArithmeticException e) {
            taxa = 0.0001;
        }
        try {
            tempo = Double.parseDouble(request.getParameter("tempo"));
        } catch (NumberFormatException | ArithmeticException f) {
            tempo = 12;
        }
        try {
            capital = Double.parseDouble(request.getParameter("capital"));
        } catch (NumberFormatException | ArithmeticException e) {
            capital = 1000;
        }
       
        response.setContentType("text/html;charset=UTF-8");
       
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JurosServlet</title>");
            out.println("</head>");
            out.println("<body>");

                       
            /*EXERCICIO C e D*/
            out.println("<table>");

            out.println("<tr>");
            out.println("<th> Taxa 0.5</th>");
            out.println("<th> Taxa 1.0</th>");
            out.println("<th> Taxa 1.5 </th>");
            out.println("</tr>");

            for (int i = 1; i <= tempo; i++) {
                out.println("<tr>");
                out.println("<td>" + capital * (1 + i* taxa - 0.005) + "</td>");
                out.println("<td>" + capital * (1 + i *taxa) + "</td>");
                out.println("<td>" + capital * (1 + i *taxa + 0.005) + "</td>");
                out.println("</tr>");

            }

            out.println("</table>");

            
            
            /*EXERCICIO C*/

                        
                        
                        
            out.println("</body>");
            out.println("</html>");
    }

    
}
