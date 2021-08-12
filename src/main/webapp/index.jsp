<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira página JSP</title>
</head>
<body>
<h1>Primeira Página JSP</h1>


<%
String conteudo = "JAVA";
out.println("Aqui é um conteúdo em " + conteudo); 
%>

</body>
</html>