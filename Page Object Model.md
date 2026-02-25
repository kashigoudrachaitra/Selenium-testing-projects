## 1) What is Page Object Model (POM)?
**Page Object Model (POM)** is a **design pattern** in Selenium where we create a **separate class for each web page**.

That page class works like an **Object Repository**:
- It stores **WebElements (locators)**
- It stores **methods (actions)** to work on those elements  
  Example actions: `enterUsername()`, `clickLogin()`, `selectCampaign()`

### Simple meaning
**1 page = 1 class**  
Inside that class:
- **Find elements**
- **Perform actions**

---

## 2) Key Points of POM 
- POM is used to create an **Object Repository** for UI elements
- We create **one page class for each page** (LoginPage, HomePage, ContactsPage, etc.)
- Page class **finds WebElements**
- Page class also contains **methods** that perform actions on those WebElements

---

## 3) POM “Rules” (common standards)
1. **Number of web pages = number of POM classes**  
   Example: 5 pages → 5 page classes

2. **Number of elements = number of WebElement variables**  
   Example: username textbox → one variable `usernameTb`

3. Keep WebElements as **private**  
   (Encapsulation: outside classes should not directly access elements)

4. Use **getters methods**  
   

5. Use **PageFactory** to initialize elements  
   `PageFactory.initElements(driver, this);`

---

## 5) Why PageFactory is used?
- It initializes `@FindBy` elements
- It keeps code cleaner and easier to read
- It can reduce some issues when elements are re-located (but it is NOT a full guarantee)

> Note: **StaleElementReferenceException** can still happen on refresh/DOM changes.
> Best practice is: use **waits**, avoid storing old element references, and re-locate when needed.

---
## 6) How the Framework uses POM (Step-by-step flow)
1. **Test starts** (TestNG/JUnit)
2. Framework **opens browser** using Base class / Driver setup
3. Test creates the **Page Object**
   - Example: `LoginPage lp = new LoginPage(driver);`
4. Page Object uses **PageFactory** to initialize `@FindBy` elements
5. Test calls **Page methods** (actions), not direct locators
   - Example: `lp.enterUsername(value); lp.clickLogin();`
6. Framework validates results (assertions), takes screenshots (if needed), and creates report
7. Browser closes (teardown)

---

## 7) Why POM is used inside the Framework
Without POM, tests will contain many lines like:
- `driver.findElement(...).sendKeys(...)`

With POM, locators stay in Page class, and tests stay clean:
- Test uses only **methods**, not locators

This gives:
- same coding style for team
- easy maintenance
- less duplicate code
- faster updates when UI changes

---

## 8) POM Key Points (as in your slide)
- POM is a design pattern to create an **Object Repository** for UI elements
- **One Page Class for each Web Page**
- Page class **finds WebElements**
- Page class contains **methods** to perform actions on those WebElements


## 9) Example POM Class (Template)
> Replace locators based on your application.


```java

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
//Generate Getters method directly by one click -Go to Sources-Select Generate Getters and Setters
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
