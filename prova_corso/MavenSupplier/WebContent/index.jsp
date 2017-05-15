<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagina Fornitori</title>
<style>
table {
	border-collapse: collapse;
	border: 1px solid black;
}
</style>
</head>
<body>
	<center>
		<form method="get" action="scheda">
			<input type="hidden" name="action" value="searchByPar">
			<table>
				<tr>
					<td colspan="2">
						<h2 align="center">Benvenuto sul sito Fornitori.it!</h2>
					</td>
				</tr>

				<tr>
					<td>
						<p>Inserisci il cognome del fornitore che vuoi visualizzare:</p>
					</td>
					<td><input type="text" name="cognome" /></td>

				</tr>
				<tr>
					<td>
						<p>Inserisci il nome del fornitore che vuoi visualizzare:</p>
					</td>
					<td><input type="text" name="nome" /></td>

				</tr>
				<tr>
					<td colspan="2">
						<center>

							<input type="submit" value="VAI ALLA PAGINA" /> 
							<input type="reset" value="CANCELLA" />
						</center>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						
					</td>
				</tr>
			</table>
		</form>
		<center>
							<form method="get" action="scheda">
								<input type="hidden" name="action" value="Insert">
								<input type="submit" value="Inserisci Nuovo Utente" /> 
							</form>
						</center>
	</center>
</body>
</html>