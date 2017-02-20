package executer;

import dbupdate.Insert;
import dbupdate.InsertP;
import model.User;

public class ActionFacadeClass implements ActionFacade {

	@Override
	public void saveData(User user) {
		Insert insert = new InsertP();
		insert.save(user);
			
	}
}