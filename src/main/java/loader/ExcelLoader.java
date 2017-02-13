package loader;

import executer.*;


class ExcelLoader implements FileLoader{
	private ExecuterFacade eF;
	
	@Override
	public void load(String path) {
		/* TODO Lee el fichero excel de la ruta pasada por parametro
		 Si el fichero no esta en formato excel, detiene la lectura y escribe en el log
		 la causa del error.
		 Va leyendo linea por linea(hay un usuario en cada linea):
		 Para cada linea crea un objeto User y se lo pasa al metodo cargarDatos del 
		 ExecuterFacade. Si existe algun fallo de FORMATO se para la lectura y se 
		 escribe dicho error en el log.
		 */
	}	
	public ExecuterFacade geteF() {
		return eF;
	}

	public void seteF(ExecuterFacade eF) {
		this.eF = eF;
	}

	

}
