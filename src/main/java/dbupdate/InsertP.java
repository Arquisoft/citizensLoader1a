package dbupdate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import model.User;
import persistence.UserFinder;
import persistence.util.Jpa;

public class InsertP implements Insert {

	@Override
	public User save(User user) {
		EntityManager mapper = Jpa.createEntityManager();
		EntityTransaction trx = mapper.getTransaction();
		trx.begin();
		try {
			Jpa.getManager().persist(user);
			trx.commit();
		} catch (PersistenceException ex) {
			if (trx.isActive())
				trx.rollback();
			throw ex;
		} finally {
			if (mapper.isOpen())
				mapper.close();
		}
		return user;
	}

	@Override
	public List<User> findByDNI(String dni) {
		return UserFinder.findByDNI(dni);
	}

	@Override
	public List<User> findByEmail(String email) {
		return UserFinder.findByEmail(email);
	}
}
