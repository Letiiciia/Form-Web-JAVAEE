
<%@page import="org.senai.model.Pessoa"%>
<%@page import="java.util.List"%>
<%@page import="org.senai.dao.PessoaDao"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="org.senai.db.Conexao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<%
	PessoaDao objDao = new PessoaDao();
	List<Pessoa> ls = objDao.listaPessoa();
	if (ls.size() > 0) {
	%>

	<table id="estilo-tb">
		<tr>
			<th>ID</th>
			<th>Nome</th>
			<th>Email</th>
<!-- 			<th>Ação</th> -->
			
			
		</tr>
		<%
		for(Pessoa ps : ls){
			
		%>
		<tr onclick="window.location.href = 'formCadastro.jsp?id=<%=ps.getId() %>'">
			<td><%=ps.getId() %></td>
			<td><%=ps.getNome()%></td>
			<td><%=ps.getEmail()%></td>
<%-- 			<td><a href="formCadastro.jsp?id=<%=ps.getId() %>">Editar</a> --%>
<%-- 			<a href="cadastroServlet?acao=apagar&id=<%=ps.getId() %>">Apagar</a> --%>
<!-- 			</td> -->
			
		</tr>
		<%
		}
		%>
	</table>
	<%
	}
	
	%>

