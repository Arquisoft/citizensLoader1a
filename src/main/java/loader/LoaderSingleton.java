package loader;

public class LoaderSingleton {
	private static LoaderSingleton single;
	private FileLoader loader;

	private LoaderSingleton() {
		this.loader = new ExcelLoader();
	}

	public static LoaderSingleton getInstance() {
		if (single == null)
			single = new LoaderSingleton();
		return single;
	}

	public void read(String cad) throws Exception {
		loader.load(cad);
	}

}
