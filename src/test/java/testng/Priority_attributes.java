package testng;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Priority_attributes {
	
		@Test(priority = -2)
		public void add() {
			Reporter.log("add", true);
			
		}
		@Test(priority =-1 )
		public void sub() {
			Reporter.log("sub", true);
			
		}
	     @Test(priority = 0)
	     public void mul() {
	 		Reporter.log("mul", true);
	    	 
	     }
	     @Test(priority = 1)
	     public void div() {
	 		Reporter.log("div", true);
	    	 
	     }
	     @Test(priority = 2)
	     public void mod() {
	 		Reporter.log("modulus", true);
	    	 
	     }
	}

