import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String loginV = "leticia@gmail.com";
		String senhaV = "0101";
		
		String senha = req.getParameter("senha");
		String login = req.getParameter("login");
		
		PrintWriter saida = res.getWriter();
		saida.println("<html>");
		
		if(login.equals(loginV) && senha.equals(senhaV)) {
			saida.println("Acesso Aprovado");
		}else {
			saida.println("Acesso Reprovado");
		}
		
		saida.println("</html>");
	}

}
