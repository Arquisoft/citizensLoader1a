package executer;

import model.User;

public class ExecuterFacadeClass implements ExecuterFacade {

	@Override
	public void guardarDatos(User usuario) {
		/* TODO Consulta la base de datos para guardar el usuario leido del fichero
		   Si el usuario ya existe, da igual si viene con los mismos datos u otros, 
		   se escribe en el log y no se guarda en BBDD.
		   Si no existe crea usuario y contraseña para dicho usuario llamando a 
		   metodos del modelo (User) y lo guarda en BBDD. Intentar hacerlo en pocas lineas
		   como los comandos del carWorkshop
		 */
		
	}

	@Override
	public void escribirLog(String texto) {
		/* TODO Llama a metodos estaticos de la clase Log para escribir
	     en el fichero de log */		
	}
}