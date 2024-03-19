package rahulshettybreakdown.pagemethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import rahulshettybreakdown.utils.ReusableUtils;



public class CheckoutPageMethods extends ReusableUtils {

	// driver initialization
	WebDriver driver;

	// constructor giving live to the driver
	public CheckoutPageMethods(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
		@FindBy(xpath = "//input[@placeholder='Select Country']")
		public static WebElement counrty;

		@FindBy(xpath = "//a[@class='btnn action__submit ng-star-inserted']")
		public static WebElement submit;

		@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
		public static WebElement selectcountry;

		// ByElements
		public static By result = By.cssSelector(".ta-results");



	// actions
	public void selectCountry(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(counrty, CountryName).build().perform();
		waitforElementToapare(result);
		selectcountry.click();
	}

	public ConfirmationPageMethods submitOrder() {
		submit.click();
		ConfirmationPageMethods confirmation = new ConfirmationPageMethods(driver);
		return confirmation;
	}

}
