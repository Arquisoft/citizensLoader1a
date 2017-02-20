package dbupdate;



import model.User;

public class InsertP implements Insert {
	
	UserRepository userRepository;

	@Override
	public User save(User user) {
		userRepository = MyContext.getApplicationContext().getBean(UserRepository.class);
		try {
			userRepository.save(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
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
