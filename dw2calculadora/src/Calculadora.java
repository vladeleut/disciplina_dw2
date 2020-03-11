import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Calculadora extends HttpServlet{ 
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		PrintWriter out;
		out = resp.getWriter();
		
		double n1 = Double.parseDouble(req.getParameter("n1"));
		double n2 = Double.parseDouble(req.getParameter("n2"));
		String op = req.getParameter("op");
		//out.println("<H1>" + op + "</H1>");
		if(op.equals("+")) {
			out.println("<H1>" + n1 + " + " + n2 + " = " + (n1+n2) + "</H1>");
		}
		
		if(op.equals("-")) {
			out.println("<H1>" + n1 + " - " + n2 + " = " + (n1-n2) + "</H1>");
		}
		
		if(op.equals("x")) {
			out.println("<H1>" + n1 + " x " + n2 + " = " + (n1*n2) + "</H1>");
		}
		
		if(op.equals(":")) {
			out.println("<H1>" + n1 + " : " + n2 + " = " + (n1/n2) + "</H1>");
		}
		
		out.close();
	}

}
