package org.senai.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.senai.dao.PessoaDao;
import org.senai.model.Pessoa;



@WebServlet("/cadastroServlet")
public class CadastroServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		Pessoa objP = new Pessoa();
		
		objP.setNome(req.getParameter("nomecompleto"));
		objP.setTelefone(req.getParameter("telefone")); 
		objP.setDataNascimento(req.getParameter("datanascimento"));
		objP.setEmail(req.getParameter("email"));
		objP.setSexo(req.getParameter("sexo"));
		objP.setTecnologia(req.getParameterValues("tecnologia"));
		objP.setEscolaridade(req.getParameter("escolaridade"));

		PessoaDao objDao = new PessoaDao();
		objDao.adicionar(objP);
		if(objDao.adicionar(objP)) {
			res.sendRedirect("listarPessoas.jsp");
		}else {
			PrintWriter saida = res.getWriter();
			saida.println("<html>");
			saida.println("Erro ao gravar dados");
			saida.println("</html>");
		}
		
	}

}
