import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //método de serviço
        PrintWriter out;
        out = response.getWriter();
        out.println("<h1>Seja bem-vindo à API de Servlets</h1>");
        out.close();
    }
}