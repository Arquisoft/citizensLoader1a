package loader;

import executer.*;


class ExcelLoader implements FileLoader{
	private ActionFacade aF;
	
	@Override
	public void load(String path) {
		/* TODO Lee el fichero excel de la ruta pasada por parametro
		 Si el fichero no esta en formato excel, detiene la lectura y escribe en el log
		 la causa del error.
		 Va leyendo linea por linea(hay un usuario en cada linea):
		 Para cada linea crea un objeto User y se lo pasa al metodo cargarDatos del 
		 AtionFacade. Si existe algun fallo de FORMATO se ignora esa linea y 
		 se pasa a la siguiente, ademas de escribir dicho error en el log.
		 */
	}	
	public ActionFacade getaF() {
		return aF;
	}

	public void setaF(ActionFacade aF) {
		this.aF = aF;
	}

	

}
