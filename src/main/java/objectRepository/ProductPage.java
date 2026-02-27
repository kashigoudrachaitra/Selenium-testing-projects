package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[contains(text(),'Add Product')]")
	private WebElement addproduct;
	@FindBy(name="productName")
	private WebElement productname;
	// Dropdown 1 select the product category by selec class
	@FindBy(name="productCategory")
	private WebElement productcatgry;
	
	@FindBy(name="quantity")
	private WebElement quantity;
	@FindBy(name="price")
	private WebElement price;
	// DropDown 2
	@FindBy(name="vendorId")
	private WebElement vendername;
	@FindBy(xpath="//button[contains(text(),'Add')]")
	private WebElement addvendorname;
	 @FindBy(xpath = "//button[@aria-label='close']")
     private WebElement closetoastmsg;
	
	public WebElement getAddproduct() {
		return addproduct;
	}
	public WebElement getProductname() {
		return productname;
	}
	public WebElement getProductcatgry() {
		return productcatgry;
	}
	public WebElement getQuantity() {
		return quantity;
	}
	public WebElement getPrice() {
		return price;
	}
	
	public WebElement getVendername() {
		return vendername;
	}
	public WebElement getAddvendorname() {
		return addvendorname;
	}
	 public WebElement getClosetoastmsg() {
		 return closetoastmsg;
	 }
     
	
}
