package miniforum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForumServlet extends HttpServlet{
	
	String filename;
	String bgcol;
	String arquivoContador;
	Integer contagem;
	
	public void init() throws ServletException{
		filename = getServletConfig().getInitParameter("filename");
		bgcol = getServletConfig().getInitParameter("bgcol");
		arquivoContador = getServletConfig().getInitParameter("arquivoContador");
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

		//leitura dos pars
		String email = req.getParameter("email");
		String msg = req.getParameter("mensagem");
		
		//execução
		FileWriter file = new FileWriter(filename, true);
		BufferedWriter buffer = new BufferedWriter(file);
		buffer.append(email+";"+ msg +"\r\n");
		buffer.close();
		file.close();
		
		
		//Contagem de acessos
		FileReader contFileRead = new FileReader(arquivoContador);
		BufferedReader contBuffer = new BufferedReader(contFileRead);
		
		String linhaCont = contBuffer.readLine();
		contagem = Integer.parseInt(linhaCont);
		contBuffer.close();
		contFileRead.close();
		contagem += 1;
		
		FileWriter contFileWrite = new FileWriter(arquivoContador);
		BufferedWriter contBufferWriter = new BufferedWriter(contFileWrite);
		contBufferWriter.append(new Integer(contagem).toString());
		contBufferWriter.close();
		contFileWrite.close();
		
		//cria resposta
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html><html><head><title>Forum</title><meta charset=\"utf-8\"></head><body style=\"background-color:"+bgcol+";\">");
		out.println("<h1>Prezado(a) "+ email +", a mensagem: \""+ msg +"\" foi gravada com sucesso!</h1>");
		out.println("<h1>Contagem de acessos: "+contagem+"</h1></body></html>");
		out.println("<form action=\"index.html\"><br><div class=\"col text-center\"><input type=\"submit\" class=\"btn btn-success\" name=\"submit\" value=\"voltar\"></div></form>");
	}

}
