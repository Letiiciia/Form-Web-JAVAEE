
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
	Connection cont = Conexao.conectar();

	if (cont != null) {
		PreparedStatement pst = cont .prepareStatement("select nomecompleto, email from pessoas");
		ResultSet rs = pst.executeQuery();
	%>

	<table>
		<tr>
			<th>Nome</th>
			<th>Email</th>
		</tr>
		<%while(rs.next()){ %>
		<tr>
			<td><%out.print(rs.getString("nomecompleto")); %></td>
			<td><%out.print(rs.getString("email")); %></td>
		</tr>	
		<% } %>
	</table>
	<%
	}
	cont.close();
	%>

</body>
</html>