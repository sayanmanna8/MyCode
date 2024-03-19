package rahulshettybreakdown.pagemethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettybreakdown.utils.ReusableUtils;



public class ConfirmationPageMethods extends ReusableUtils {

	// driver initialization
	WebDriver driver;

	// constructor giving live to the driver
	public ConfirmationPageMethods(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Locators
		@FindBy(css = ".hero-primary")
		public static WebElement text;
		
		
	// actions
	public String getConfirmationText() {

		return text.getText();
	}

}
