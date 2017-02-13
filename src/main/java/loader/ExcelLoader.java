package loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.User;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import executer.*;

class ExcelLoader implements FileLoader {
	private ActionFacade aF;
	
	@Override
	public void load(String path) {
		/*
		 * Lee el fichero excel de la ruta pasada por parametro Si el
		 * fichero no esta en formato excel, detiene la lectura y escribe en el
		 * log la causa del error. Va leyendo linea por linea(hay un usuario en
		 * cada linea): Para cada linea crea un objeto User y se lo pasa al
		 * metodo cargarDatos del AtionFacade. Si existe algun fallo de FORMATO
		 * se ignora esa linea y se pasa a la siguiente, ademas de escribir
		 * dicho error en el log.
		 */
		InputStream ficheroExcel;
		XSSFWorkbook excel;
		try {
			ficheroExcel = new FileInputStream(path);

			excel = new XSSFWorkbook(ficheroExcel);
			XSSFSheet sheet = excel.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;

			List<String> user; 
			
			Iterator<Row> rows = sheet.rowIterator();
			int i=0;
			while (rows.hasNext()) {
				user = new ArrayList<String>();
				row = (XSSFRow) rows.next();
				Iterator<Cell> cells = row.cellIterator();
				if (i > 0){
					while (cells.hasNext()) {
						cell = (XSSFCell) cells.next();
							user.add(cell.toString());
						}
					System.out.println();
					crearUsuarios(user);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo excel esperado");
			e.printStackTrace();
		} catch (IOException ioe) {
			System.err.println("Problema con la lectura del excel");
			ioe.printStackTrace();
		}

	}

	public ActionFacade getaF() {
		return aF;
	}

	public void setaF(ActionFacade aF) {
		this.aF = aF;
	}
	
	private void crearUsuarios(List<String> list){
		User user = new User(list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6));
		System.out.println(user.toString());
		//aF.saveData(user);
	}

}
