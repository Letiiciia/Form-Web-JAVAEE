<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Primeira pagina JSP</title>
</head>
<body>
<%@ include file="menu.jsp"%>
<h1>Primeira Pagina JSP</h1>


<%
String conteudo = "JAVA";
out.println("Aqui é um conteúdo em " + conteudo); 
%>

</body>
</html>