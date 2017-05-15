//package servlet;
//
//import java.io.IOException;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import dao.*;
//
//public class FornitoreServlet_bkp extends HttpServlet {
//
//	@Override
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String nome = request.getParameter("nome");
//		String cognome = request.getParameter("cognome");
//		FornitoreDao fornitoreDao = new FornitoreDao();
//		Fornitore fornitore = fornitoreDao.getFornitore(nome, cognome);
//		String spPage = "";
//
//		if (fornitore != null) {
//			spPage = "pages/dati.jsp";
//			request.setAttribute("fornitore", fornitore);
//		} else
//			spPage = "pages/error.jsp";
//		request.getRequestDispatcher(spPage).forward(request, response);
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		doGet(request, response);
//	}
//
//}
