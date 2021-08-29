<%@page import="org.senai.model.Pessoa"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>menu</title>
<style>
ul {
	background-color: #eee;
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	width: 53%;
	margin: auto;
}
li {
	float: left;
}
li a {
	color: black;
	padding: 16px;
	display: block;
	text-align: center;
	text-decoration: none;
}
li a:hover {
	background-color: #ddd;
}

#dadosUsuario {
color: black;
	padding: 16px;
	display: block;
	text-align: center;
	text-decoration: none;
	float: right;
}

</style>
</head>
<body>
<ul>
	<li><a href="index.jsp">Home</a></li>
	<li><a href="formCadastro.jsp">Cadastro</a></li>
	
	<%
	Pessoa usuario = (Pessoa) request.getSession().getAttribute("usuario");
	boolean verLista = false;
	if(usuario != null) {
		verLista = true;
		%>
		<li><a href="loginservlet?acao=sair">Logout</a></li>
		<span id="dadosUsuario">Bem vindo: <%=usuario.getNome()%></span>
		
		<%
		
	}else{
		%>
		<li><a href="login.jsp">Login</a></li>
		<% 
	}
	
	
	%>
	
	
	
	
</ul>

</body>
</html>