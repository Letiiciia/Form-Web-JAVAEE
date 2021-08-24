
<%@page import="org.senai.model.Pessoa"%>
<%@page import="java.util.List"%>
<%@page import="org.senai.dao.PessoaDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="org.senai.db.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="IUTF-8">
<title>Listar Pessoas</title>
</head>
<body>
	<%
	PessoaDao objDao = new PessoaDao();
	List<Pessoa> ls = objDao.listaPessoa();
	if (ls.size() > 0) {
	%>

	<table>
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
			<th>Ação</th>
			
		</tr>
		<%
		for(Pessoa p : ls){
			
		%>
		<tr>
			<td><%=p.getId() %></td>
			<td><%=p.getNome()%></td>
			<td><%=p.getEmail()%></td>
			<td><a href="formCadastro.jsp?id=<%=p.getId() %>">Editar</a></td>
			<td><a href="cadastroServlet?acao=apagar&id=<%=p.getId() %>">Apagar</a></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	
	%>

</body>
</html>