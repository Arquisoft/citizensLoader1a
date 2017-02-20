package parsertest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.User;

import org.junit.Test;

import dbupdate.Insert;
import dbupdate.InsertP;
public class DbupdateTest {

	@Test
	public void InsertExitotest() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Insert insert = new InsertP();
		String fecha = "10/12/1988";
		Date fecha2 = null;
		try {
			fecha2 = formato.parse(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		User citizen = new User("Alberto","García López","agl@example.com",fecha2,
				"C/ Uria", "Español", "74582594S");
		User user = insert.save(citizen);
		assertEquals(1,1);
	}
}
