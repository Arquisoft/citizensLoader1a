package persistence;

import java.util.List;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import model.User;
import persistence.util.Jpa;
import reportwriter.ReportWriter;

public class UserFinder {

	public static List<User> findByDNI(String dni) {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		List<User> res = null;
		try {
			res = Jpa.getManager().createNamedQuery("User.findByDni", User.class).setParameter(1, dni)
					.getResultList();
			trx.commit();
		} catch (PersistenceException ex) {
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Error de la BBDD");
			if (trx.isActive())
				trx.rollback();
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
		return res;
	}

	public static List<User> findByEmail(String email) {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		List<User> res = null;
		try {
			res = Jpa.getManager().createNamedQuery("User.findByEmail", User.class).setParameter(1, email)
					.getResultList();
			trx.commit();
		} catch (PersistenceException ex) {
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "Error de la BBDD");
			if (trx.isActive())
				trx.rollback();
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
		return res;
	}
}
