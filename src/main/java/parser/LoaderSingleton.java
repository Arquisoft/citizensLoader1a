package parser;

import java.io.FileNotFoundException;
import java.util.logging.Level;

import reportwriter.ReportWriter;

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

	public void loadFile(String cad) {
		try{
			loader.load(cad);
		}catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo excel especificado.");
			ReportWriter.getInstance().getWriteReport().log(Level.WARNING, "No se ha encontrado el archivo excel");
		}
	}
}
