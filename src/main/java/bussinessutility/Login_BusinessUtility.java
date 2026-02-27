package bussinessutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_BusinessUtility {
	WebDriver driver;
	public Login_BusinessUtility(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	
	}

		@FindBy(id="username")
		private WebElement usernametf;
		
		@FindBy(id="inputPassword")
		private WebElement inputpasswordtf;
		
		@FindBy(xpath = "//button[text()='Sign In']")
		private WebElement signinbt;
		public WebElement getUsernametf() {
			return usernametf;
		}

		public WebElement getInputpasswordtf() {
			return inputpasswordtf;
		}

		public WebElement getSigninbt() {
			return signinbt;
		}
        public void login(String URL,String USERNAME,String PASSWORD)
        {
        	driver.manage().window().maximize();
        	driver.get(URL);
        	usernametf.sendKeys(USERNAME);
        inputpasswordtf.sendKeys(PASSWORD);
        
        }

}
