<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dao.FornitoreDao"%>
<%@ page import="dao.Fornitore"%>
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
<%String actionFrom=request.getParameter("action"); 
Fornitore f=new Fornitore();
String ButtonLabel="";
String actionToPass="";
if (actionFrom.equals("Modify")){
	FornitoreDao fd = new FornitoreDao();
	f=fd.getSingleFornitore(Integer.parseInt(request.getParameter("codForn")));
	ButtonLabel="Conferma Modifica";
	actionToPass="doModify";
}else{
	ButtonLabel="Inserisci";
	actionToPass="Insert";
	f.setNome("");
	f.setCognome("");
	f.setCitta("");
	f.setIndirizzo("");
	f.setNumTelefono("");
}
%>
	<center>
		<form method="post" action="scheda">
			<input type="hidden" name="action" value="<%=actionToPass.toString() %>">
			<table>
				<tr>
					<td colspan="2">
						<h2 align="center">Inserisci un nuovo utente</h2>
					</td>
				</tr>

		
				
				<tr>
					<td>
						<p>Nome:</p>
					</td>
					<td><input type="text" name="Nome" value="<%=f.getNome() %>"/></td>

				</tr>


				<tr>
					<td>
						<p>Cognome:</p>
					</td>
					<td><input type="text" name="Cognome" value="<%=f.getCognome() %>"/></td>
				</tr>
				
				<tr>
					<td>
						<p>Città:</p>
					</td>
					<td><input type="text" name="Citta" value="<%=f.getCitta() %>"/></td>

				</tr>


				<tr>
					<td>
						<p>Indirizzo:</p>
					</td>
					<td><input type="text" name="Indirizzo" value="<%=f.getIndirizzo()%>"/></td>
				</tr>
				
				<tr>
					<td>
						<p>Num Telefono:</p>
					</td>
					<td><input type="text" name="NumTel" value="<%=f.getNumTelefono()%>"/></td>
				</tr>
				<td colspan="2">
					<center>
						<input type="hidden" name="codForn" value="<%=f.getCodiceFornitore()%>"/>
						<input type="submit" value="<%=ButtonLabel.toString().toUpperCase() %>" />
					</center>
				</td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>