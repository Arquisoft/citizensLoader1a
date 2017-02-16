package main;

import java.io.FileNotFoundException;

import parser.LoaderSingleton;

/**
 * Main application
 * 
 * @author 1A1
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	void run(String... args) {
		if (args.length == 0 || args[0].equals("--help"))
			showHelp();
		else if (args[0].equals("info"))
			showInfo();
		else if (args[0].equals("load")) {
			if (args.length < 2)
				System.err.println("La operacion load necesita al menos otro "
						+ "argumento con la ubicacion del fichero");
			else {
				for (int i = 1; i < args.length - 1; i++)
					try {
						LoaderSingleton.getInstance().loadFile(args[i]);
					} catch (FileNotFoundException e) {
						continue;
					}
			}
		}
	}

	private void showInfo() {
		// TODO Por hacer

	}

	private void showHelp() {
		// TODO Por hacer
	}
}
