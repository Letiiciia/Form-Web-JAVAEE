package org.senai.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import org.senai.db.Conexao;
import org.senai.model.Pessoa;

public class PessoaDao {
	public boolean adicionar(Pessoa objP) {

		String lsTecnologia = "";
		for (String t : objP.getTecnologia()) {
			lsTecnologia += t + ",";
		}

		try {
			// Conexao c = new Conexao(); // instancia da classe Conexao
			Connection cont = Conexao.conectar(); // metodo de conexao ao banco

			String sql = "insert into pessoas (nomecompleto, telefone, datanascimento, email, sexo, tecnologia, escolaridade)"
					+ "values('" + objP.getNome() + "', '" + objP.getTelefone() + "', '" + objP.getDataNascimento()
					+ "', '" + objP.getEmail() + "', '" + objP.getSexo() + "', '" + lsTecnologia + "', ' ');";
			System.out.println(sql);
			PreparedStatement pst = cont.prepareStatement(sql);
			pst.execute();
			pst.close();
			cont.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
}
