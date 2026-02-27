package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Practic_1 {
	
	
	@Test
	public void ama() {
		Reporter.log("amazon", true);
	}
	@Test
	public void bas() {
		Reporter.log("baskinob", true);
	}
    @Test
    public void criz() {
    	Reporter.log("crizbuzz", true);
    }
    
}
