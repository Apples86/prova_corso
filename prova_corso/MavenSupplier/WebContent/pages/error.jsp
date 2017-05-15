<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
table, tr, td {
	border-collapse: collapse;
	border: 1px solid black;
}
</style>
</head>
<body>
	<center>
		<table>
			<tr>
				<td>
					<h1 align="center">
						Ciao
						<%
					    String nome = request.getParameter("nome");
					    out.print(nome);
					%>
					</h1>
				</td>
			</tr>
			<tr>
				<td>
						<h2 align="center"> Il fornitore è inesistente!</h2>
				</td>
			</tr>
			<tr>
				<td>
					<center>
						<a href="./index.jsp">Torna alla home</a>
					</center>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>