package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {

	public CampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
     @FindBy(name = "campaignName")
	private WebElement campnname;
     @FindBy(name = "targetSize")
     private WebElement targetsize;
     @FindBy(xpath = "//button[text()='Create Campaign']")
     private WebElement createcampaignbutton;
     @FindBy(name = "campaignStatus")
     private WebElement campaignstatus;
     @FindBy(name = "expectedCloseDate")
     private WebElement expectedclosedate;
     @FindBy(xpath = "//div[@role='alert']")
     private WebElement toastmsg;
     @FindBy(xpath = "//button[@aria-label='close']")
     private WebElement closetoastmsg;
	 public WebElement getCampnname() {
		 return campnname;
	 }
	 public WebElement getTargetsize() {
		 return targetsize;
	 }
	 public WebElement getCreatecampaignbutton() {
		 return createcampaignbutton;
	 }
	 public WebElement getCampaignstatus() {
		 return campaignstatus;
	 }
	 public WebElement getExpectedclosedate() {
		 return expectedclosedate;
	 }
	 public WebElement getToastmsg() {
		 return toastmsg;
	 }
	 public WebElement getClosetoastmsg() {
		 return closetoastmsg;
	 }
     
     
     
}
