package campaign;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import basetest.BaseClass;
import basetest.BaseClass2;
import genericUtilities.ExcelUtility;
import objectRepository.CampaignPage;
import objectRepository.HomePage;

public class CampaignTest1 extends BaseClass2  {
	@Test(groups = "Regression")
	public void toCreateCampaigntest() throws Throwable, IOException
	{
		
		ExcelUtility eutil = new ExcelUtility();
	String campname = eutil.toreadDatafromExcelFile("Sheet1", 1, 2);
	String target = eutil.toreadDatafromExcelFile("Sheet1", 1, 3);
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
	
	}
	@Test(groups = "smoke")
	public void toCreateWithStatusTest() throws Throwable, IOException {
		String campname = eutil.toreadDatafromExcelFile("Sheet1", 4, 2);
		String target = eutil.toreadDatafromExcelFile("Sheet1", 4, 3);
		String stutus = eutil.toreadDatafromExcelFile("Sheet1", 4, 4);
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
		
	}
	@Test(groups = "Regression")
	public void toCreateCampaignExpectedClosingDateTest() throws Throwable, IOException {
		String campname = eutil.toreadDatafromExcelFile("Sheet1", 4, 2);
		String target = eutil.toreadDatafromExcelFile("Sheet1", 4, 3);
		String stutus = eutil.toreadDatafromExcelFile("Sheet1", 4, 4);
		String daterequired = jutil.togetRequiredDate(30);
		HomePage hp=new HomePage(driver);
		hp.getCreatecampbt().click();
		CampaignPage cp=new CampaignPage(driver);
		cp.getCampnname().sendKeys(campname);
		WebElement size = cp.getTargetsize();
		size.clear();
		size.sendKeys(target);
		WebElement expClosedate =cp.getExpectedclosedate();
		wutil.passInput(driver, expClosedate, daterequired);
		cp.getCreatecampaignbutton().click();
		// validation
		WebElement toastmsg =cp.getToastmsg();
		wutil.waitForVisibilityOfElement(driver, toastmsg);
		String msg = toastmsg.getText();
		if (msg.contains(campname)) {
		System.out.println("campaign created");
		}
		else {
		System.out.println("campaign not created");
		}
		cp.getClosetoastmsg().click();
		
	}

}
