package org.senai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	public List<Pessoa> listaPessoa() {
		List<Pessoa> ls = new ArrayList<>();

		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("select nomecompleto, email from pessoas");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setNome(rs.getString("nomecompleto"));
				p.setEmail(rs.getString("email"));
				ls.add(p);
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}
}
