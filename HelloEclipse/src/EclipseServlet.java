import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EclipseServlet extends HttpServlet{
	
	//implemetar o método de serviço para quando chegar a requisição
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		PrintWriter out;
		out = resp.getWriter();
		String nome = req.getParameter("nome");
		out.println("<H1>Seja bem vindo à API de Servlets no Eclipse, " + nome + "!</H1>");
		out.close();
	}
	

}
