package dao;

import javax.persistence.TypedQuery;

//import javax.persistence.NoResultException;
//import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class FornitoreDao_bkp {

	public Fornitore getFornitore(String nome, String cognome) {
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		TypedQuery<?> query = session.createQuery("FROM Fornitore WHERE Nome = :Nome AND Cognome = :Cognome");
		query.setParameter("Nome", nome);
		query.setParameter("Cognome", cognome);
		Fornitore f = null;
		
			f = (Fornitore) query.getSingleResult();
		

		return f;
	}
}