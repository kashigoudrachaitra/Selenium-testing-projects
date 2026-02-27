package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DependOnMethod_Attribute {
	@Test
	public void createAcc() {
		Reporter.log("created succesfully", true);
		
	}
	@Test(dependsOnMethods = "createAcc")
	public void editAcc() {
		Reporter.log("edited succesfully", true);
		
	}
     @Test(dependsOnMethods = {"createAcc","editAcc",})
     public void deleteAcc() {
 		Reporter.log("deleted succesfully", true);
    	 
     }
     

}
