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

	/**
	 * Lee el fichero excel de la ruta pasada por parametro Si el fichero no
	 * esta en formato excel, detiene la lectura y escribe en el log la causa
	 * del error. Va leyendo linea por linea(hay un usuario en cada linea): Para
	 * cada linea crea un objeto User y se lo pasa al metodo cargarDatos del
	 * AtionFacade. Si existe algun fallo de FORMATO se ignora esa linea y se
	 * pasa a la siguiente, ademas de escribir dicho error en el log.
	 * 
	 * @param path
	 *            ruta del fichero
	 * 
	 */
	@Override
	public void load(String path) {
		InputStream excelFile;
		XSSFWorkbook excel;
		int i = 0;
		try {
			excelFile = new FileInputStream(path);
			excel = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = excel.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			List<XSSFCell> user;
			Iterator<Row> rows = sheet.rowIterator();

			while (rows.hasNext()) {
				user = new ArrayList<XSSFCell>();
				row = (XSSFRow) rows.next();
				Iterator<Cell> cells = row.cellIterator();
				if (i > 0) {
					while (cells.hasNext()) {
						cell = (XSSFCell) cells.next();
						user.add(cell);
						System.out.println(cell.toString());
					}
					crearUsuarios(user);
				}
				i++;
			}
		} catch (FileNotFoundException e) {
			System.err.println("No se ha encontrado el archivo excel esperado");
		} catch (IOException ioe) {
			System.err.println("Problema con la lectura del excel en la linea " + i);
		}

	}

	public ActionFacade getaF() {
		return aF;
	}

	public void setaF(ActionFacade aF) {
		this.aF = aF;
	}

	private void crearUsuarios(List<XSSFCell> list) {
		User user = new User(list.get(0).getStringCellValue(), list.get(1).getStringCellValue(),
				list.get(2).getStringCellValue(), list.get(3).getDateCellValue(), 
				list.get(4).getStringCellValue(),list.get(5).getStringCellValue(), 
				list.get(6).getStringCellValue());
		getaF().saveData(user);
	}

}
