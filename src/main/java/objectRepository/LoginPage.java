package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

	
		
	public LoginPage(WebDriver driver) {
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

	

}
