package dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.SystemException;
import org.hibernate.Transaction;
import org.hibernate.HibernateException;
//import javax.persistence.NoResultException;
//import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.SessionBuilder;
import org.hibernate.cfg.Configuration;

public class FornitoreDao {

	public List<Fornitore> getFornitore(String nome, String cognome) {
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		TypedQuery<?> query = session.createQuery("FROM Fornitore WHERE Nome = :Nome AND Cognome = :Cognome");
		query.setParameter("Nome", nome);
		query.setParameter("Cognome", cognome);
		Fornitore f = null;
		List<Fornitore> lstF;
		lstF = (List<Fornitore>) query.getResultList();
		return lstF;
	}
	
	public Fornitore getSingleFornitore(int ID) {
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		session.beginTransaction();
		TypedQuery<?> query = session.createQuery("FROM Fornitore WHERE codiceFornitore = :ID");
		query.setParameter("ID", ID);
		Fornitore f = null;
		f = (Fornitore) query.getSingleResult();
		return f;
	}


	public void deleteUser(int codiceFornitore) {

		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();

		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Fornitore fornitore = session.get(Fornitore.class, codiceFornitore); 
			session.delete(fornitore); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) 
				tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

	}



	/* Method to CREATE an supplier in the database */
	public void addUser(String Nome, String Cognome, String numTelefono, String Indirizzo, String Citta){
		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		Transaction tx = null;

		try{
			tx = session.beginTransaction();
			Fornitore fornitore = new Fornitore();
			fornitore.setNome(Nome);
			fornitore.setCitta(Citta);
			fornitore.setCognome(Cognome);
			fornitore.setNumTelefono(numTelefono);
			fornitore.setIndirizzo(Indirizzo);
			session.save(fornitore); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}

	}


	/* Method to UPDATE  Supplier */
	public void updateUser(Integer SupplierID, String Nome, String Cognome,
			String numTelefono, String Indirizzo, String Citta ){

		Session session = new Configuration().configure().buildSessionFactory().getCurrentSession();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			Fornitore fornitore = 
					(Fornitore)session.get(Fornitore.class, SupplierID); 
			fornitore.setCitta(Citta);
			fornitore.setCognome(Cognome);
			fornitore.setcodiceFornitore(SupplierID);
			fornitore.setNome(Nome);
			fornitore.setIndirizzo(Indirizzo);
			fornitore.setNumTelefono(numTelefono);
			session.update(fornitore); 
			tx.commit();
		}catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		}finally {
			session.close(); 
		}
	}




}