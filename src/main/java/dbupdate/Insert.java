package dbupdate;

import model.User;

public interface Insert{
	User save(User user);
	User findByDNI(String dni);
	User findByEmail(String email);
}
