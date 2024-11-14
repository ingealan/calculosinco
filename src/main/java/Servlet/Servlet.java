package Servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

//Necesitamos un path una llave o una key para acceder a el servlet
@WebServlet("/calcular")
public class Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Configurar la respuesta para mostrar HTML
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            // Crear la tabla HTML
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Tabla de Seno y Coseno</title>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n");
            out.println("</head>");
            out.println("<body>");

            out.println("<div class='container mt-5'>");
            out.println("<h2 class='text-center text-dark mb-4'>Valores de Seno y Coseno</h2>");
            out.println("<table class=\"table table-bordered table-dark text-light\">");
            out.println("<thead><tr><th>Ángulo (°)</th><th>Seno</th><th>Coseno</th></tr></thead>");
            out.println("<tbody>");

            for (int i = 0; i <= 360; i += 15) {
                double seno = Math.sin(Math.toRadians(i));
                double coseno = Math.cos(Math.toRadians(i));

                out.println("<tr>");
                out.println("<td>" + i + "</td>");
                out.println("<td>" + String.format("%.4f", seno) + "</td>");
                out.println("<td>" + String.format("%.4f", coseno) + "</td>");
                out.println("</tr>");
            }

            out.println("</tbody>");
            out.println("</table>");

            out.println("<div class='text-center'><a href='index.html' class='btn btn-dark'>Volver al Formulario</a></div>");
            out.println("</div>");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js\" integrity=\"sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r\" crossorigin=\"anonymous\"></script>\n");
            out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.min.js\" integrity=\"sha384-0pUGZvbkm6XF6gxjEnlmuGrJXVbNuzT9qBBavbLwCsOGabYfZo0T0to5eqruptLy\" crossorigin=\"anonymous\"></script>\n");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }
}