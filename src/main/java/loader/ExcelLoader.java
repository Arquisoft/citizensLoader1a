package loader;

import executer.*;


class ExcelLoader implements FileLoader{
	private ExecuterFacade eF;
	
	@Override
	public void load(String path) {
		// TODO Auto-generated method stub		
	}	
	public ExecuterFacade geteF() {
		return eF;
	}

	public void seteF(ExecuterFacade eF) {
		this.eF = eF;
	}

	

}
