<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Usando JSP</title>
</head>
<body>
<h1>Hola mundo</h1>
<p>Fecha Mediante Directiva</p>
<p><%=new Date() %></p>

<p>Fecha Mediante Variable Local: </p>
<%Date fecha =new Date();%>
<%System.out.println("<i>"+ fecha + "</i>"); %>
<p>Fecha Formateada: </p>


</body>
</html>