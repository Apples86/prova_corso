<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dao.Fornitore"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultato ricerca</title>
</head>
<body>
	<%
		Fornitore forn = (Fornitore) request.getAttribute("fornitore");
	%>
	<center>
		<h1>Visualizzazione informazioni fornitore</h1>

		<table style="border: 2px solid black">
			<tr>
				<th>Nome e Cognome</th>
				<th>Citta</th>
				<th>Numero di telefono</th>
				<th>Indirizzo</th>


			</tr>


			<tr>
				<td>
					<%
						out.println(forn.getNome());
						out.println(forn.getCognome());
					%>
				</td>
				<td>
					<%
						out.println(forn.getCitta());
					%>
				</td>

				<td>
					<%
						out.println(forn.getnumTelefono());
					%>
				</td>

				<td>
					<%
						out.println(forn.getIndirizzo());
					%>
				</td>

				
			</tr>
		</table>


		<a href="index.jsp">TORNA ALLA HOME</a>
	</center>

</body>
</html>