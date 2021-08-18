package org.senai.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.senai.db.Conexao;



@WebServlet("/cadastroServlet")
public class CadastroServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String nome = req.getParameter("nome-completo");
		String telefone = req.getParameter("telefone");
		String dataNascimento = req.getParameter("dt-nascimento");
		String email = req.getParameter("email");
		String sexo = req.getParameter("sexo");
		String[] tecnologia = req.getParameterValues("tecnologia");
		String escolaridade = req.getParameter("escolaridade");

		PrintWriter saida = res.getWriter();
		saida.println("<html>");
		saida.println(nome);
		saida.println(telefone);
		saida.println(dataNascimento);
		saida.println(email);
		saida.println(sexo);

		String lsTecnologia = "";
		for (String t : tecnologia) {
			saida.println(t);
			lsTecnologia += t + ",";
		}
		saida.println(escolaridade);

		try {
			//Conexao c = new Conexao(); // instancia da classe Conexao
			Connection cont = Conexao.conectar(); //metodo de conexao ao banco
			
			if(cont != null) {
				saida.println("Conexão efetuada com sucesso");

				String sql = "insert into pessoas (nomecompleto, telefone, datanascimento, email, sexo, tecnologia, escolaridade)"
						+ "values('"+ nome +"', '"+ telefone +"', '"+ dataNascimento +"', '"+email+"', '"+sexo+"', '"+lsTecnologia+"', ' ');";
				System.out.println(sql);
				PreparedStatement pst = cont.prepareStatement(sql);
				pst.execute();
				pst.close();
				cont.close();
				saida.println("Registro gravado");
			}else {
				saida.println("Erro de conexão");
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		saida.println("</html>");
	}

}
