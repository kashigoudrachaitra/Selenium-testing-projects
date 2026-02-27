package basetest;

import org.testng.annotations.Test;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesFileUtility;
import genericUtilities.WebdriverUtility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public  WebDriver driver=null;
	public ExcelUtility eutil=new ExcelUtility();
    public JavaUtility jutil=new JavaUtility();
   public PropertiesFileUtility putil=new PropertiesFileUtility();
    public WebdriverUtility wutil=new WebdriverUtility();
    @BeforeSuite(groups = {"Regression","smoke"})
    public void beforeSuite() {
    Reporter.log("db open", true);
    }
    
	
	@Parameters("BROWSER")
	@BeforeClass(groups = {"Regression","smoke"})
	  public void beforeClass(String BROWSER) throws Throwable {
		 //String BROWSER = putil.togetDataFromPropertiesFile("Browser");
		ChromeOptions settings = new ChromeOptions();
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.password_manager_leak_detection", false);
		settings.setExperimentalOption("prefs", prefs); 
			
			if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
			} else if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver(settings);
			} else if (BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
			Reporter.log("launch Browser",true);
			}
	  }
  
  @BeforeMethod(groups = {"Regression","smoke"})
  public void beforeMethod() throws Throwable {
	  
	  driver.manage().window().maximize();
		wutil.waitForPageToLoad(driver);
		String URL = putil.togetDataFromPropertiesFile("Url");
		
		String USERNAME = putil.togetDataFromPropertiesFile("Username");
		String PASSWORD = putil.togetDataFromPropertiesFile("Password");
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		Reporter.log("login",true);
		
  }

  @AfterMethod(groups = {"Regression","smoke"})
  public void afterMethod() {
	  WebElement icon =  driver.findElement(By.xpath("//div[@class='user-icon']"));
		wutil.mouseHoverOnWebElement(driver, icon);
		WebElement logout = driver.findElement(By.xpath("//div[@class='dropdown-item logout']"));
		wutil.clickOnWebElement(driver, logout);
		Reporter.log("logout",true);
  }

  

  @AfterClass(groups = {"Regression","smoke"})
  public void afterClass() {
	  driver.quit();
	  Reporter.log("close browser",true);
  }

 

  @AfterSuite(groups = {"Regression","smoke"})
  public void afterSuite() {
	Reporter.log("db close", true);
  }

}
