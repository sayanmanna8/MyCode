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



public class ProductPageMethods extends ReusableUtils {

	// driver initialization
	WebDriver driver;

	// constructor giving live to the driver
	public ProductPageMethods(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// locators
		@FindBy(css = ".mb-3")
		public static List<WebElement> products;

		@FindBy(css = ".ng-animating")
		public static WebElement spinner;

		// ByElements
		public static By element = By.cssSelector("#toast-container");
		public static By addcart = By.cssSelector(".card-body button:last-of-type");
		public static By toast = By.cssSelector(".card-body button:last-of-type");


	// actions
	public List<WebElement> getProductlist() {
		waitforElementToapare(element);
		return products;
	}

	public WebElement getProductName(String pname) {
		WebElement prod = getProductlist().stream()
				.filter(product -> product.findElement(By.cssSelector("b")).getText().contains(pname)).findFirst()
				.orElse(null);
		return prod;

	}

	public void addTocart(String pname) throws InterruptedException {
		WebElement prod = getProductName(pname);
		prod.findElement(addcart).click();
		waitforElementToapare(toast);
		waitforElementTodisapear(spinner);

	}

}
