package testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesFileUtility;
import genericUtilities.WebdriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;
import objectRepository.ProductPage;

public class CreateProductUsingPOM {

	public static void main(String[] args) throws IOException, Throwable {
		PropertiesFileUtility putil = new PropertiesFileUtility();
		ExcelUtility eutil = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebdriverUtility wutil = new WebdriverUtility();
		String BROWSER = putil.togetDataFromPropertiesFile("Browser");
		String URL = putil.togetDataFromPropertiesFile("Url");
		String USERNAME = putil.togetDataFromPropertiesFile("Username");
		String PASSWORD = putil.togetDataFromPropertiesFile("Password");
		WebDriver driver = null;
		if (BROWSER.equals("Edge")) {
		driver = new EdgeDriver();
		} else if (BROWSER.equals("Chrome")) {
		driver = new ChromeDriver();
		} else if (BROWSER.equals("Firefox")) {
		driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
		LoginPage ln=new LoginPage(driver);
		ln.getUsernametf().sendKeys(USERNAME);
		ln.getInputpasswordtf().sendKeys(PASSWORD);
		ln.getSigninbt().click();
		
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
		WebElement icon = hp.getUsericon();
		wutil.mouseHoverOnWebElement(driver, icon);
		WebElement logout = hp.getLogout();
		wutil.clickOnWebElement(driver, logout);
		// close browser
		driver.quit();
				

	}

}
