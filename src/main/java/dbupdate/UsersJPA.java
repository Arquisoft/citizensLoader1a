package dbupdate;

import org.springframework.data.repository.CrudRepository;

import model.User;

public interface UsersJPA extends CrudRepository<User, Long>{
	 User findByEmail();
	 User findByDNI();
}
