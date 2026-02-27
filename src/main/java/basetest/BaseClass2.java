package basetest;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import genericUtilities.ExcelUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertiesFileUtility;
import genericUtilities.WebdriverUtility;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass2 {
	public  WebDriver driver=null;
	public static WebDriver sdriver=null;
	public ExcelUtility eutil=new ExcelUtility();
    public JavaUtility jutil=new JavaUtility();
   public PropertiesFileUtility putil=new PropertiesFileUtility();
    public WebdriverUtility wutil=new WebdriverUtility();
    
    @BeforeSuite(groups = {"Regression","smoke"})
    public void beforeSuite() {
    Reporter.log("db open", true);
    }
    
	
	
	@BeforeClass(groups = {"Regression","smoke"})
	  public void beforeClass() throws Throwable {
		
    // String BROWSER = putil.togetDataFromPropertiesFile("Browser");
		String BROWSER = System.getProperty("Browser");
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
			
			}
			
			sdriver=driver;	
			System.out.println("launching browser");
	  }
	
  
  @BeforeMethod(groups = {"Regression","smoke"})
  public void beforeMethod() throws Throwable {
	  
	 
		String URL = putil.togetDataFromPropertiesFile("Url");
		String USERNAME = putil.togetDataFromPropertiesFile("Username");
		String PASSWORD = putil.togetDataFromPropertiesFile("Password");
		 driver.manage().window().maximize();
			wutil.waitForPageToLoad(driver);
		driver.get(URL);
		LoginPage ln=new LoginPage(driver);
		ln.getUsernametf().sendKeys(USERNAME);
		ln.getInputpasswordtf().sendKeys(PASSWORD);
		ln.getSigninbt().click();
		Reporter.log("login",true);
		
  }

  @AfterMethod(groups = {"Regression","smoke"})
  public void afterMethod() {
	  HomePage hp=new HomePage(driver);
	  WebElement icon =hp.getUsericon();
		wutil.mouseHoverOnWebElement(driver, icon);
		WebElement logout = hp.getLogout();
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
