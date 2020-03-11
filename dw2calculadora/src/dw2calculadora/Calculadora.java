package dw2calculadora;

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
		
		float n1 = Float.parseFloat(req.getParameter("n1"));
		float n2 = Float.parseFloat(req.getParameter("n1"));
		String op = req.getParameter("op");
		
		if(op == "+") {
			out.println("<H1>" + n1 + " + " + n2 + "=" + (n1+n2) + "!</H1>");
		}
		
		if(op == "-") {
			out.println("<H1>" + n1 + " - " + n2 + "=" + (n1-n2) + "!</H1>");
		}
		
		if(op == "x") {
			out.println("<H1>" + n1 + " x " + n2 + "=" + (n1*n2) + "!</H1>");
		}
		
		if(op == ":") {
			out.println("<H1>" + n1 + " : " + n2 + "=" + (n1/n2) + "!</H1>");
		}
		
		out.close();
	}

}
