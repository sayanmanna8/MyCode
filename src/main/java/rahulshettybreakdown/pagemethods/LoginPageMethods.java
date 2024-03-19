package rahulshettybreakdown.pagemethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettybreakdown.utils.ReusableUtils;


public class LoginPageMethods extends ReusableUtils {
	 WebDriver driver;
	//LoginPageObjects LoginPageObjects = new LoginPageObjects(driver);
	// driver initialization
	//WebDriver driver;
	
	// constructor giving live to the driver
	public LoginPageMethods(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	// locators
		@FindBy(id = "userEmail")
		WebElement useremail;

		@FindBy(id = "userPassword")
		WebElement pass;

		@FindBy(id = "login")
		WebElement submit;

		@FindBy(css = "[class*='flyInOut']")
		WebElement errormessage;

	
	
	//actions
	public void getUrl() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMeassage() {

		// waitforWebElementToapare(errormessage);
		return errormessage.getText();
	}

	public ProductPageMethods loginApplication(String username, String password) {
		useremail.sendKeys(username); 
		pass.sendKeys(password);
		submit.click();
		ProductPageMethods productdetails = new ProductPageMethods(driver);
		return productdetails;
	}

}
