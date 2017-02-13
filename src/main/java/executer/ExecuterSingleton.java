package executer;

public class ExecuterSingleton {
	private ExecuterFacade facade;
	private static ExecuterSingleton single;

	private ExecuterSingleton() {
		this.facade = new ExecuterFacadeClass();
	}

	public static ExecuterSingleton getInstance() {
		if (single == null)
			single = new ExecuterSingleton();
		return single;
	}

	public ExecuterFacade getEF() {
		return facade;
	}
}
