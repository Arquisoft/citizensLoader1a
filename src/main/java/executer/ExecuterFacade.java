package executer;

import model.User;

public interface ExecuterFacade {
	public void guardarDatos(User usuario);
	public void escribirLog(String texto);
	// public void comprobarSeguridad();  Esto es una ampliacion opcional y no se en que consiste
}