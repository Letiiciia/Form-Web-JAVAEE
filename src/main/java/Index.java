import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cadastro") 
public class Index extends HttpServlet{
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
		PrintWriter saida =  res.getWriter();
		saida.println("<html>");
		saida.println("<body>Ol� mundo Servlet</body>");
		saida.println("<html>");
	}

}
