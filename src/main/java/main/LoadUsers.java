package main;

import java.io.FileNotFoundException;

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
		if(args.length == 0){
			System.out.println("Introduce como parámetro la orden --help para mostrar la información.");
		} else{
			if (args[0].equals("--help"))
				showHelp();
			else
				try{
					LoaderSingleton.getInstance().loadFile(args[0]);
				}catch(FileNotFoundException e){
					System.err.println("No se ha encontrado el archivo excel esperado");
					e.printStackTrace();
				}
						
		}
	}
	
	private void showHelp(){
		System.out.println("Ayuda para cargar el archivo a la base de datos:");
		System.out.println("Introduce como único parámetro la ruta del archivo a cargar.");
	}
}
