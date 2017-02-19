package dbupdate;

import org.springframework.beans.factory.annotation.Autowired;

import model.User;

public class InsertP implements Insert{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findByDNI(String dni) {
		return userRepository.findByDni(dni);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
}
