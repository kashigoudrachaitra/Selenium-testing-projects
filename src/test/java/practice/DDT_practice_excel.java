package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT_practice_excel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream fls=new FileInputStream("./src/test/resources/TEST DATA.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		Sheet sh = wb.getSheet("Sheet1");
		Row r = sh.getRow(1);
		Cell cl=r.getCell(2);
		 
		String value = cl.getStringCellValue();
		System.out.println(value);
		

		

	}

}
