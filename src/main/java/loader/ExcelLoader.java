package loader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import executer.*;


class ExcelLoader implements FileLoader{
	private ActionFacade aF;
	
	@SuppressWarnings("deprecation")
	@Override
	public void load(String path){
		/* TODO Lee el fichero excel de la ruta pasada por parametro
		 Si el fichero no esta en formato excel, detiene la lectura y escribe en el log
		 la causa del error.
		 Va leyendo linea por linea(hay un usuario en cada linea):
		 Para cada linea crea un objeto User y se lo pasa al metodo cargarDatos del 
		 AtionFacade. Si existe algun fallo de FORMATO se ignora esa linea y 
		 se pasa a la siguiente, ademas de escribir dicho error en el log.
		 */
		InputStream ficheroExcel;
		XSSFWorkbook excel;
		try{
			ficheroExcel = new FileInputStream(path);
			
			excel = new XSSFWorkbook(ficheroExcel);
			XSSFSheet sheet = excel.getSheetAt(0);
			XSSFRow row;
			XSSFCell cell;
			
			Iterator<Row> rows = sheet.rowIterator();
			while(rows.hasNext()){
				row=(XSSFRow) rows.next();
				Iterator<Cell> cells = row.cellIterator();
				while (cells.hasNext())
				{
					cell=(XSSFCell) cells.next();
			
					if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
					{
						System.out.print(cell.getStringCellValue()+ " ");
					}
					else if(cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
					{
						System.out.print(cell.getNumericCellValue()+" ");
					}
				}
				System.out.println();
			}
		} catch (FileNotFoundException e){
			System.err.println("No se ha encontrado el archivo excel esperado");
			e.printStackTrace();
		} catch (IOException ioe){
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

	

}
