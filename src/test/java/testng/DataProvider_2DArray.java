package testng;

import java.lang.classfile.instruction.NewObjectInstruction;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_2DArray {
	
	
	@Test(dataProvider = "logindetails")
	public void login(String Username,String password) {
		System.out.println(Username+"   "+ password);
		
	}
	
	@DataProvider
	public Object[][] logindetails()
	{
		Object[][] obj=new Object[3][2];
		obj[0][0]="dhoni";
		obj[0][1]="dhoni34";
		obj[1][0]="virat";
		obj[1][1]="virat23";
		obj[2][0]="rohit";
		obj[2][1]="rohit";
		return obj;
	}
	

}
