package parser;

import java.io.FileNotFoundException;

//Esto sería ReadList
public interface ReadList {
	public void load(String path) throws FileNotFoundException;
}
