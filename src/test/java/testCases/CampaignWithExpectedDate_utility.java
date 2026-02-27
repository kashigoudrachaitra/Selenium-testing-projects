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

public class CampaignWithExpectedDate_utility {

	public static void main(String[] args) throws IOException
	{
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
		driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		String daterequired = jutil.togetRequiredDate(30);
		driver.findElement(By.xpath("//span[text()='Create Campaign']")).click();
		driver.findElement(By.name("campaignName")).sendKeys("hplaptop");
		WebElement size = driver.findElement(By.name("targetSize"));
		size.clear();
		size.sendKeys(target);
		WebElement expClosedate = 
		driver.findElement(By.name("expectedCloseDate"));
		wutil.passInput(driver, expClosedate, daterequired);
		driver.findElement(By.xpath("//button[text()='Create Campaign']")).click();
		// validation
		WebElement toastmsg = driver.findElement(By.xpath("//div[@role='alert']"));
		wutil.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(campname)) {
		System.out.println("campaign created");
		}
		else {
		System.out.println("campaign not created");
		}
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();
		// logout
		WebElement icon =  driver.findElement(By.xpath("//div[@class='user-icon']"));
		wutil.mouseHoverOnWebElement(driver, icon);
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		wutil.clickOnWebElement(driver, logout);
		// close browser
		driver.quit();

	}

}
