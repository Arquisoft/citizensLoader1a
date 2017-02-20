package dbupdate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;

import main.LoadUsers;
import model.User;

@Configuration
@EnableAutoConfiguration
public class InsertP implements Insert {
	UserRepository userRepository;

	@Override
	public User save(User user) {
		//userRepository = MyContext.getApplicationContext().getBean(UserRepository.class);
		ConfigurableApplicationContext context = SpringApplication
				.run(LoadUsers.class);
		UserRepository userRepository = context
				.getBean(UserRepository.class);
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
