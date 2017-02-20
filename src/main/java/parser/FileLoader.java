package parser;

import java.io.FileNotFoundException;

//Esto sería ReadList
public interface FileLoader {
	public void load(String path) throws FileNotFoundException;
}
