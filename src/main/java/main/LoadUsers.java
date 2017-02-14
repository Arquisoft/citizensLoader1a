package main;

import loader.LoaderSingleton;


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
		
		LoaderSingleton.getInstance().loadFile(args[0]);
	}
}
