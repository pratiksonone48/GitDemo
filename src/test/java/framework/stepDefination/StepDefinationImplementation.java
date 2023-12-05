package framework.stepDefination;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import framework.TestComponents.BaseTest;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckOutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.LandingPage;
import framework.pageobjects.ProductCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;

public class StepDefinationImplementation extends BaseTest 
{
	public LandingPage landingpage;
	public ProductCatalogue productcatalogue;
	public ConfirmationPage confirmationpage;

	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_page() throws IOException 
	{
		landingpage = launchApplication();

	}

	@Given("^logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password) 
	{
		productcatalogue=landingpage.loginApplication(username, password);
	}

	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException 
	{
		List<WebElement> products = productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);

	}

	@When("^Checkout (.+) and submit the order$")
	public void chechout_and_submit_the_order(String productName) throws InterruptedException 
	{
		CartPage cartpage = productcatalogue.goToCartPage();

		Boolean match = cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.goToCheckOut();
		checkoutpage.selectCountry("india");
		checkoutpage.scroll();
		checkoutpage.submitOrder();
	}

	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed_confirmation_page(String string) 
	{
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
	}
	
	
	@Then("^\"([^\"]*)\" message is displayed$")
	public void something_message_is_displayed (String strArg1) throws Throwable
	{
		Assert.assertEquals(strArg1, landingpage.getErrorMessage());
	}
}


