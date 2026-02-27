package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_campaign_DDT {

		public static void main(String[] args) throws IOException, InterruptedException {
			FileInputStream fis=new FileInputStream(".//src/test/resources/Commondata.properties");
			Properties prop=new Properties();
			prop.load(fis);
			String BROWSER = prop.getProperty("Browser");
			String URL= prop.getProperty("Url");
			String USERNAME = prop.getProperty("Username");
			String PASSWORD = prop.getProperty("Password");
			
			WebDriver driver=null;
			
			// Step 1: Launch Browser

			ChromeOptions settings = new ChromeOptions();
			HashMap<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.password_manager_leak_detection", false);
			settings.setExperimentalOption("prefs", prefs);
			
			//Run time polymorphism for browser launch - driver 
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(settings);
			}
			else if(BROWSER.equalsIgnoreCase("Firefox"))
			{
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("edge")) 
			{
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			}
			else 
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver(settings);
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			// Step 2: Load the URL
			driver.get(URL);
			
			Thread.sleep(3000);
			driver.findElement(By.id("username")).sendKeys(USERNAME);
			driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
			driver.findElement(By.xpath("//button[text()='Sign In']")).click();
			FileInputStream fls=new FileInputStream("./src/test/resources/TEST DATA.xlsx");
			Workbook wb = WorkbookFactory.create(fls);
			Sheet sh = wb.getSheet("Sheet1");
			Row r = sh.getRow(1);
			Cell cl=r.getCell(2);
			String CAMPAIGNNAME = r.getCell(2).getStringCellValue();
			String TARGETSIZE = r.getCell(3).getStringCellValue();
			String value = cl.getStringCellValue();
			System.out.println(value);
			
			// Step 4: Click on create campaign
			driver.findElement(By.xpath("//span[.='Create Campaign']")).click();

			// Step 5: enter mandatory details
			driver.findElement(By.name("campaignName")).sendKeys(CAMPAIGNNAME);
			driver.findElement(By.name("targetSize")).sendKeys(TARGETSIZE);

			// Step 6: click on create campaign
			driver.findElement(By.xpath("//button[.='Create Campaign']")).click();

			Thread.sleep(1000);

			// Step 7: Validate for Campaign
			String toastMsg = driver.findElement(By.className("Toastify__toast-body")).getText();
			System.out.println(toastMsg);

			if (toastMsg.contains(CAMPAIGNNAME)) {
				System.out.println("Campaign created");
			} else {
				System.out.println("Campaign creation failed");
			}
			Thread.sleep(6000);
			// Step 8: logout of Application
			//logout
			WebElement icon = driver.findElement(By.className("user-icon-container"));
			Actions act=new Actions(driver);
			act.moveToElement(icon).perform();
			driver.findElement(By.className("dropdown-item logout")).click();
			driver.quit();


}
	}
