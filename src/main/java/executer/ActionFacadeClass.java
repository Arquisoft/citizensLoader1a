package executer;

import dbupdate.InsertP;
import model.User;

public class ActionFacadeClass implements ActionFacade {

	@Override
	public void saveData(User user) {
		InsertP insert = new InsertP();
		insert.save(user);
		/* TODO Consulta la base de datos para guardar el usuario leido del fichero
		   Si el usuario ya existe, da igual si viene con los mismos datos u otros, 
		   se escribe en el log y no se guarda en BBDD.
		   Si no existe crea usuario y contraseña para dicho usuario llamando a 
		   metodos del modelo (User) y lo guarda en BBDD. Intentar hacerlo en pocas lineas
		   como los comandos del carWorkshop
		 */
		
	}

	@Override
	public void writeLog(String text) {
		/* TODO Llama a metodos estaticos de la clase Log para escribir
	     en el fichero de log */		
	}
}