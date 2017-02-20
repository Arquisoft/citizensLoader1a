package dbupdate;

import java.util.List;

import model.User;
import persistence.UserFinder;
import persistence.util.Jpa;


public class InsertP implements Insert {
	

	@Override
	public User save(User user) {
		Jpa.getManager().persist(user);
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
