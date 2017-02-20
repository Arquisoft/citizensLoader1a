package dbupdate;

import java.util.List;

import model.User;

public interface Insert {
	User save(User user);

	List<User> findByDNI(String dni);

	List<User> findByEmail(String email);
}
