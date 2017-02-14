package main;

import parser.LoaderSingleton;


/**
 * Main application
 * 
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	void run(String... args) {
		// TODO main para pruebas
		if(args.length == 0 || args[0].equals("--help")){
			showHelp();
		} else{
			LoaderSingleton.getInstance().loadFile(args[0]);
		}
	}
	
	private void showHelp(){
		System.out.println("Ayuda para cargar el archivo a la base de datos:");
		System.out.println("Introduce como único parámetro la ruta del archivo a cargar.");
		System.out.println("Para la ayuda introduce como parámetro --help");
	}
}
