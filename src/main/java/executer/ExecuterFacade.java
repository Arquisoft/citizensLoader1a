package executer;

import model.User;

public interface ExecuterFacade {
	public void saveData(User usuario);
	public void writeLog(String texto);
	// public void verifySecurity();  Esto es una ampliacion opcional y no se en que consiste
}