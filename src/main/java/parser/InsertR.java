package parser;

import dbupdate.Insert;
import dbupdate.InsertP;
import model.User;

public class InsertR implements Insert{

	@Override
	public User save(User user) {
		return new InsertP().save(user);
	}

	@Override
	public User findByDNI(String dni) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
