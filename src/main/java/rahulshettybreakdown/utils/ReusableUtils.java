package rahulshettybreakdown.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettybreakdown.pagemethods.CartPageMethods;
import rahulshettybreakdown.pagemethods.OrderPageMethods;





//this contains all the reusable methods of the application
public class ReusableUtils {

	// driver initialization
	WebDriver driver;

	public ReusableUtils(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// locators
	@FindBy(css = "[routerlink*=cart]")
	WebElement cartpage;
	@FindBy(css = "[routerlink*=myorders]")
	WebElement orderpage;

	// actions
	public void waitforElementToapare(By Find) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(Find));
	}

	public void waitforWebElementToapare(WebElement Find) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(Find));
	}

	public void waitforElementTodisapear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
	}

	public CartPageMethods clickOnCart() {
		cartpage.click();
		CartPageMethods cartpage = new CartPageMethods(driver);
		return cartpage;
	}

	public OrderPageMethods clickOntOrder() {
		orderpage.click();
		OrderPageMethods OrderPage = new OrderPageMethods(driver);
		return OrderPage;
	}

	public void scrollDown() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(1000);

	}

}
