package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.*;

public class FornitoreServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String method="";
		method=request.getMethod();


		String action="";
		String id="";
		action=request.getParameter("action");
		if ((!(action.equals(null)))&&(action.equals("delete"))){
			id=request.getParameter("codForn");
			String name=request.getParameter("nome");
			String surname=request.getParameter("cognome");
			doDelete(id,name,surname,request, response);


		}else if ((!(action.equals(null)))&&(action.equals("Insert"))){
			String spPage="/pages/insert.jsp";
			request.getRequestDispatcher(spPage).forward(request, response);
		}else{

			String nome = request.getParameter("nome");

			String cognome = request.getParameter("cognome");
			FornitoreDao fornitoreDao = new FornitoreDao();
			List<Fornitore> fornitore = fornitoreDao.getFornitore(nome, cognome);
			String spPage = "";

			if (fornitore != null) {
				spPage = "pages/dati.jsp";
				request.setAttribute("fornitore", fornitore);
			} else
				spPage = "pages/error.jsp";
			if(!response.isCommitted()){
				request.getRequestDispatcher(spPage).forward(request, response);
			}

		}





	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action="";
		action=request.getParameter("action");
		String Nome = null;
		String Cognome = null;
		String numTelefono = null;
		String Indirizzo = null;
		String Citta = null;
		
		if (action.equals("Insert")){
			Nome = request.getParameter("Nome");
			Cognome = request.getParameter("Cognome");
			numTelefono = request.getParameter("NumTel");
			Indirizzo = request.getParameter("Indirizzo");
			Citta = request.getParameter("Citta");
			doInsert( Nome, Cognome,  numTelefono,  Indirizzo, Citta,request,response);
		}else if(action.equals("Modify")){
			String spPage = "pages/insert.jsp";
			try {
				request.getRequestDispatcher(spPage).forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			if(action.equals("doModify")){
				Nome = request.getParameter("Nome");
				Cognome = request.getParameter("Cognome");
				numTelefono = request.getParameter("NumTel");
				Indirizzo = request.getParameter("Indirizzo");
				Citta = request.getParameter("Citta");
				doModify( Nome, Cognome,  numTelefono,  Indirizzo, Citta,request,response);	
			}
		}
		
		
		
		
	}

	protected void doDelete(String id, String name, String surname,HttpServletRequest request, HttpServletResponse response){
		//doGet(request, response);
		FornitoreDao f=new FornitoreDao();
		f.deleteUser(Integer.parseInt(id));
		String spPage = "";
		request.setAttribute("nome", name);
		request.setAttribute("cognome", surname);
		FornitoreDao fornitoreDao = new FornitoreDao();
		List<Fornitore> fornitore = fornitoreDao.getFornitore(name, surname);

		if (!(fornitore.isEmpty())) {
			spPage = "pages/dati.jsp";
			request.setAttribute("fornitore", fornitore);
		} else
			spPage = "pages/error.jsp";
		try {
			request.getRequestDispatcher(spPage).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	protected void doInsert(String Nome, String Cognome, String numTelefono, String Indirizzo, String Citta,HttpServletRequest request, HttpServletResponse response){
		FornitoreDao f=new FornitoreDao();
		f.addUser( Nome,  Cognome,  numTelefono,  Indirizzo,  Citta);
		String spPage = "";
		spPage = "/index.jsp";


		try {
			request.getRequestDispatcher(spPage).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	protected void doModify(String Nome, String Cognome, String numTelefono, String Indirizzo, String Citta,HttpServletRequest request, HttpServletResponse response){
		FornitoreDao f=new FornitoreDao();
		f.updateUser( Integer.parseInt(request.getParameter("codForn")),Nome,  Cognome,  numTelefono,  Indirizzo,  Citta);
		String spPage = "";
		spPage = "/index.jsp";


		try {
			request.getRequestDispatcher(spPage).forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

//	protected void doPut(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		//doGet(request, response);
//	}

//Commento Aggiunto per far uscire che avevo modificato il file
}
