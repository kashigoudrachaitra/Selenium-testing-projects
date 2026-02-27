package testCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import bussinessutility.Login_BusinessUtility;
import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesFileUtility;
import genericUtilities.WebdriverUtility;
import objectRepository.CampaignPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateCampainWithManditoryFielsWithBusinessUtility {

	public static void main(String[] args) throws Throwable {
		PropertiesFileUtility putil = new PropertiesFileUtility();
		ExcelUtility eutil = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		WebdriverUtility wutil = new WebdriverUtility();
		String BROWSER = putil.togetDataFromPropertiesFile("Browser");
		String URL = putil.togetDataFromPropertiesFile("Url");
		String USERNAME = putil.togetDataFromPropertiesFile("Username");
		String PASSWORD = putil.togetDataFromPropertiesFile("Password");
		String campname = eutil.toreadDatafromExcelFile("Sheet1", 1, 2);
		String target = eutil.toreadDatafromExcelFile("Sheet1", 1, 3);
		WebDriver driver = null;
		if (BROWSER.equals("Edge")) {
		driver = new EdgeDriver();
		} else if (BROWSER.equals("Chrome")) {
		driver = new ChromeDriver();
		} else if (BROWSER.equals("Firefox")) {
		driver = new FirefoxDriver();
		}
		
		wutil.waitForPageToLoad(driver);
		
		Login_BusinessUtility ln=new Login_BusinessUtility(driver);
		ln.login(URL, USERNAME, PASSWORD);
		ln.getSigninbt().click();
		
		
		HomePage hp=new HomePage(driver);
		hp.getCreatecampbt().click();
		// create campaign
        CampaignPage cp=new CampaignPage(driver);
		
		cp.getCampnname().sendKeys(campname + jutil.getRandomNumber());
		WebElement size = cp.getTargetsize();
		size.clear();
		size.sendKeys(target);
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
				WebElement icon =hp.getUsericon();
				wutil.mouseHoverOnWebElement(driver, icon);
				WebElement logout = hp.getLogout();
				wutil.clickOnWebElement(driver, logout);
				// close browser
				driver.quit();

		
	}

}
