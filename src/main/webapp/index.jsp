<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Primeira p�gina JSP</title>
</head>
<body>
<h1>Primeira P�gina JSP</h1>


<%
String conteudo = "JAVA";
out.println("Aqui � um conte�do em " + conteudo); 
%>

</body>
</html>