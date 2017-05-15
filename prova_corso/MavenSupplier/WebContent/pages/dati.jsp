<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dao.Fornitore"%>
<%@ page import="java.util.List"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Risultato ricerca</title>
</head>
<body>
	<%
		List<Fornitore> forn = (List<Fornitore>) request.getAttribute("fornitore");
	%>
	<center>
		<h1>Fornitori Trovati</h1>

		<table style="border: 2px solid blue">
			<tr bgcolor="#e6f200">
				<th>Nome e Cognome</th>
				<th>Citta</th>
				<th>Numero di telefono</th>
				<th>Indirizzo</th>
				<th></th>
				<th></th>
			</tr>
			<%
				int k = 0;
			%>
			<%
				for (Fornitore f : forn) {
			%>
			<%
				k++;
					if ((k % 2) == 0) {
			%>
			<!-- Codice di cambio bg pari -->
			<tr bgcolor="#e6f2ff">
				<%
					} else {
				%>
				<!-- Codice di cambio bg dispari -->
			<tr bgcolor="#FFFFFF">
				<%
					}
				%>

				<td>
					<%
						out.println(f.getNome());
							out.println(f.getCognome());
					%>
				</td>
				<td>
					<%
						out.println(f.getCitta());
					%>
				</td>

				<td>
					<%
						out.println(f.getNumTelefono());
					%>
				</td>

				<td>
					<%
						out.println(f.getIndirizzo());
					%>
				</td>

				<td>
					<%
						int cod = f.getCodiceFornitore();
							String name = f.getNome();
							String surname = f.getCognome();
					%>
					<form method="get" action="scheda">
						<input type="hidden" name="codForn" value="<%=cod%>"> <input
							type="hidden" name="action" value="delete"> <input
							type="hidden" name="nome" value="<%=name.toString()%>"> <input
							type="hidden" name="cognome" value="<%=surname.toString()%>">
						<input type="submit" value="X" />
					</form>

				</td>

				<td>
					<form method="post" action="scheda">
						<input type="hidden" name="codForn" value="<%=cod%>" /> <input
							type="hidden" name="action" value="Modify" /> <input
							type="hidden" name="nome" value="<%=name.toString()%>" /> <input
							type="hidden" name="cognome" value="<%=surname.toString()%>" /> <input
							type="submit" value="..." />
					</form>
				</td>



			</tr>
			<%
				}
			%>
		</table>


		<a href="index.jsp">TORNA ALLA HOME</a>
	</center>

</body>
</html>