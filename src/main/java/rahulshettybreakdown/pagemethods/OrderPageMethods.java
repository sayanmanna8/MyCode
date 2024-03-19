package rahulshettybreakdown.pagemethods;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettybreakdown.utils.ReusableUtils;



public class OrderPageMethods extends ReusableUtils {

	// driver initialization
	WebDriver driver;

	// constructor giving live to the driver
	public OrderPageMethods(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// locators
		@FindBy(css = "tr td:nth-child(3)")
		public static List<WebElement> orders;

	// actions
	public Boolean VerifyProductDisplay(String productName) {
		Boolean data = orders.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productName));
		return data;
	}

}
