package rahulshettybreakdown.stepdefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettybreakdown.hooks.Hooks;
import rahulshettybreakdown.pagemethods.CartPageMethods;
import rahulshettybreakdown.pagemethods.CheckoutPageMethods;
import rahulshettybreakdown.pagemethods.ConfirmationPageMethods;
import rahulshettybreakdown.pagemethods.LoginPageMethods;
import rahulshettybreakdown.pagemethods.ProductPageMethods;


public class SubmitOrderStepDef extends Hooks{
	
	LoginPageMethods landingPage;
	ProductPageMethods productdetails;
	CartPageMethods cartpage;
	CheckoutPageMethods checkout;
	ConfirmationPageMethods confirmation;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPage = LaunchApplication();
	}

	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
         productdetails = loginpage.loginApplication(username,password);
	}
	
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		productdetails.addTocart(productName);
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName) throws InterruptedException
	{
	    cartpage = productdetails.clickOnCart();
		Boolean data = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(data);
		checkout = cartpage.checkout();
		checkout.selectCountry("India");
		checkout.scrollDown();
		confirmation = checkout.submitOrder();
	}
	

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
    	String text = confirmation.getConfirmationText();
		Assert.assertTrue(text.equalsIgnoreCase("Thankyou for the order."));
		driver.close();
    }

}
