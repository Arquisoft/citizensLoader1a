package parser;

import java.io.FileNotFoundException;

public class LoaderSingleton {
	private static LoaderSingleton instance;
	private FileLoader loader;

	private LoaderSingleton() {
		this.loader = new ExcelLoader();
	}

	public static LoaderSingleton getInstance() {
		if (instance == null)
			instance = new LoaderSingleton();
		return instance;
	}

	public void loadFile(String cad) throws FileNotFoundException {
		loader.load(cad);
	}

}
