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
		if(objP.getTecnologia() != null) {		
			for (String t : objP.getTecnologia()) {
				lsTecnologia += t + ",";
			}
		}
	

		try {
			// Conexao c = new Conexao(); // instancia da classe Conexao
			Connection cont = Conexao.conectar(); // metodo de conexao ao banco

			String sql = "insert into pessoas (nomecompleto, telefone, datanascimento, email, sexo, tecnologia, escolaridade, uf, senha)"
					+ "values(?,?,?,?,?,?,?,?,'123')";
			
			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setString(1, sql);
			pst.setString(1, objP.getNome());
			pst.setString(2, objP.getTelefone());
			pst.setString(3, objP.getDataNascimento());
			pst.setString(4, objP.getEmail());
			pst.setString(5, objP.getSexo());
			pst.setString(6, lsTecnologia);
			pst.setString(7, objP.getEscolaridade());
			pst.setString(8, objP.getUf());
			
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
			PreparedStatement pst = cont.prepareStatement("select * from pessoas order by id");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setNome(rs.getString("nomecompleto"));
				p.setEmail(rs.getString("email"));
				p.setId(rs.getInt("id"));
				ls.add(p);
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ls;
	}

	public Pessoa getPessoa(int id) {
		Pessoa p = new Pessoa();
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("select * from pessoas where id = ? ");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				p.setNome(rs.getString("nomecompleto"));
				p.setEmail(rs.getString("email"));
				p.setId(rs.getInt("id"));
				p.setTelefone(rs.getString("telefone"));
				p.setDataNascimento(rs.getString("datanascimento"));
				p.setTecnologia(rs.getString("tecnologia").split(","));
				p.setEscolaridade(rs.getString("escolaridade"));
				p.setSexo(rs.getString("sexo"));
				p.setUf(rs.getString("uf"));
			}
			cont.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean alterar(Pessoa objP) {
		String lsTecnologia = "";
		for (String t : objP.getTecnologia()) {
			lsTecnologia += t + ",";
		}

		try {
			// Conexao c = new Conexao(); // instancia da classe Conexao
			Connection cont = Conexao.conectar(); // metodo de conexao ao banco

			String sql = " update pessoas set " + "nomecompleto   = ?," + "telefone        = ?,"
					+ "datanascimento   = ?," + "email           = ?," + "sexo            = ?," + "tecnologia      = ?,"
					+ "escolaridade    = ?, " + "uf = ?" + "where " + "id				= ?";

			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setString(1, objP.getNome());
			pst.setString(2, objP.getTelefone());
			pst.setString(3, objP.getDataNascimento());
			pst.setString(4, objP.getEmail());
			pst.setString(5, objP.getSexo());
			pst.setString(6, lsTecnologia);
			pst.setString(7, objP.getEscolaridade());
			pst.setInt(8, objP.getId());
			pst.setString(9, objP.getUf());

			pst.execute();
			pst.close();
			cont.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public boolean apagar(int id) {
		
		try {
			// Conexao c = new Conexao(); // instancia da classe Conexao
			Connection cont = Conexao.conectar(); // metodo de conexao ao banco

			String sql = "delete from pessoas where id = ?";

			PreparedStatement pst = cont.prepareStatement(sql);
			pst.setInt(1, id);

			pst.execute();
			pst.close();
			cont.close();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	public Pessoa validarLogin(String login, String senha) {
		Pessoa p = new Pessoa();
		try {
			Connection cont = Conexao.conectar();
			PreparedStatement pst = cont.prepareStatement("select * from pessoas where email = '"+login+"' and senha = '"+senha+"'");
			
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {

				p.setNome(rs.getString("nomecompleto"));
				p.setEmail(rs.getString("email"));
				p.setId(rs.getInt("id"));
				p.setTelefone(rs.getString("telefone"));
				p.setDataNascimento(rs.getString("datanascimento"));
				p.setTecnologia(rs.getString("tecnologia").split(","));
				p.setEscolaridade(rs.getString("escolaridade"));
				p.setSexo(rs.getString("sexo"));
				p.setUf(rs.getString("uf"));
			}
			cont.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}
}
