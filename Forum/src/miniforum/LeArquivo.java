package miniforum;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LeArquivo extends HttpServlet {
	
	/*public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		File file = new File("C:\\apache-tomcat-9.0.30\\work\\arq\\arq.txt"); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html><html><head><title>Forum</title><meta charset=\"utf-8\"></head><body>");

		String msgs; 
		while ((msgs = br.readLine()) != null) {
			String[] partes = msgs.split(";");
			out.println("Usuário: "+ partes[0]+"; Mensagem: \""+ partes[1]+ msgs+"\"<br>");
		}
		  
		out.println("</body></html>");*/
	
	String filename;
	String bgcol;
	String arquivoContador;
	Integer contagem;
	
	public void init() throws ServletException{
		filename = getServletConfig().getInitParameter("filename");
		bgcol = getServletConfig().getInitParameter("bgcol");
		arquivoContador = getServletConfig().getInitParameter("arquivoContador");
		//obs: precisa inicializar o arquivo!
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		FileReader file = new FileReader(filename);
		BufferedReader buffer = new BufferedReader(file);
		
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
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE html><html><head>	<meta charset=\"utf-8\"><title></title><link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\"></head><body style=\"background-color:"+bgcol+";\">");
		out.println("<div class=\"container\"><table class=\"table table-bordered table-sm table-hover\"><thead class=\"thead-dark\"><tr><th>Email</th>	<th>Mensagem</th></tr></thead><h1>Contagem de acessos: "
					+contagem
					+"</h1><tbody>");
		
		String linha = buffer.readLine();
		while(linha != null) {
			String msg[] = linha.split(";");
			out.println("<tr><td>"+msg[0]+"</td><td>"+msg[1]+"</td></tr>");
			linha = buffer.readLine();
		}
		
		out.println("</tbody></table></body></html>");
		buffer.close();
		file.close();
		out.println("<form action=\"index.html\"><br><div class=\"col text-center\"><input type=\"submit\" class=\"btn btn-success\" name=\"submit\" value=\"voltar\"></div></form>");
		out.close();
		
		
		contBuffer.close();
	}
	  

}
