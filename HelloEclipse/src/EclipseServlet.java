import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EclipseServlet extends HttpServlet{
	
	//implemetar o m�todo de servi�o para quando chegar a requisi��o
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		PrintWriter out;
		out = resp.getWriter();
		String nome = req.getParameter("nome");
		out.println("<H1>Seja bem vindo � API de Servlets no Eclipse, " + nome + "!</H1>");
		out.close();
	}
	

}
