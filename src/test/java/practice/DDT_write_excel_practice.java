package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDT_write_excel_practice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fl=new FileInputStream(".\\src\\test\\resources\\TEST DATA.xlsx");
		 Workbook wb = WorkbookFactory.create(fl);
		 Sheet sh = wb.getSheet("Sheet1");
		 Row rw = sh.getRow(1);
		 Cell cl = rw.createCell(6);
		 cl.setCellValue("Information");
		 FileOutputStream fs=new FileOutputStream(".\\src\\test\\resources\\TEST DATA.xlsx");
		 wb.write(fs);
		 wb.close();
		 System.out.println("write operation success");
		 
		 
		 
		 
	}

}
