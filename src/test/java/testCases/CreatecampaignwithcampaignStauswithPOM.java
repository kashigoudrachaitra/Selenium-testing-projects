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
import objectRepository.CampaignPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreatecampaignwithcampaignStauswithPOM {

	public static void main(String[] args) throws IOException {
		ExcelUtility eutil=new ExcelUtility();
	      JavaUtility jutil=new JavaUtility();
	      PropertiesFileUtility putil=new PropertiesFileUtility();
	      WebdriverUtility wutil=new WebdriverUtility();
	      String BROWSER = putil.togetDataFromPropertiesFile("Browser");
			String URL = putil.togetDataFromPropertiesFile("Url");
			String USERNAME = putil.togetDataFromPropertiesFile("Username");
			String PASSWORD = putil.togetDataFromPropertiesFile("Password");
			String campname = eutil.toreadDatafromExcelFile("Sheet1", 4, 2);
			String target = eutil.toreadDatafromExcelFile("Sheet1", 4, 3);
			String stutus = eutil.toreadDatafromExcelFile("Sheet1", 4, 4);
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
			hp.getCreatecampbt().click();
			// create campaign
			CampaignPage cp=new CampaignPage(driver);
		    cp.getCampnname().sendKeys(campname);
			cp.getCampaignstatus().sendKeys(stutus);
		    
			cp.getCreatecampaignbutton().click();
			
			// validation
			WebElement toastmsg = cp.getToastmsg();
			wutil.waitForVisibilityOfElement(driver, toastmsg);
			String msg = toastmsg.getText();
			if (msg.contains(campname)) {
			System.out.println("campaign created");
			}
			else {
			System.out.println("campaign not created");
			}
			cp.getClosetoastmsg().click();
			// logout
			WebElement icon = hp.getUsericon();
			wutil.mouseHoverOnWebElement(driver, icon);
			WebElement logout =hp.getLogout();
			wutil.clickOnWebElement(driver, logout);
			// close browser
			driver.quit();

	}

}
