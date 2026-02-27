package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {


		public HomePage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		
		}

		@FindBy(linkText ="Campaigns")
		private WebElement campaignpg;
		@FindBy(xpath ="//span[.='Create Campaign']")
		private WebElement createcampbt;
		@FindBy(linkText="Products")
		private WebElement createproduct;
		@FindBy(xpath = "//div[@class='user-icon']")
		private WebElement usericon;
		@FindBy(xpath="//div[@class='dropdown-item logout']")
		private WebElement logout;
		public WebElement getCampaignpg() {
			return campaignpg;
		}
		public WebElement getCreatecampbt() {
			return createcampbt;
		}
		public WebElement getCreateproduct() {
			return createproduct;
		}
		
		public WebElement getUsericon() {
			return usericon;
		}
		public WebElement getLogout() {
			return logout;
		}
		
		
		
	}

