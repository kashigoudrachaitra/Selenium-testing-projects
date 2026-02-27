package product;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import basetest.BaseClass;
import objectRepository.HomePage;
import objectRepository.ProductPage;

public class CreateProduct extends BaseClass {
	@Test
	public void toCreateProductTest() throws IOException, Throwable {

	
		HomePage hp=new HomePage(driver);
		hp.getCreateproduct().click();
		ProductPage ppg=new ProductPage(driver);
		ppg.getAddproduct().click();
		ppg.getProductname().sendKeys("HP"+jutil.getRandomNumber());
		WebElement categorydropdown =ppg.getProductcatgry();
		// Dropdown 1 select the product category by selec class
	     wutil.select(categorydropdown, "Electricals");
	     WebElement quantity =ppg.getQuantity();
	     quantity.clear();
	     quantity.sendKeys("20");
		WebElement price = ppg.getPrice();
			price.clear();
			price.sendKeys("20000");

			// DropDown 2
			WebElement vendordropdown =ppg.getVendername();
			Thread.sleep(6000);
			wutil.select(vendordropdown, 2);
			//drop2.selectByIndex(2);
			ppg.getAddvendorname().click();
			Thread.sleep(2000);
			ppg.getClosetoastmsg().click();
			Reporter.log("Product is created", true);
		
	}
	

}
