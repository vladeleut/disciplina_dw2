import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HelloServlet extends HttpServlet{
	//public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{    
        String user;
        String surname;
        user = request.getParameter("usuario");
        surname = request.getParameter("sobrenome");
        //método de serviço
        PrintWriter out;
        out = response.getWriter();
        out.println("<h1>Seja bem-vindo a API de Servlets, " + user + " " + surname + "!</h1>");
        out.close();
    }
}