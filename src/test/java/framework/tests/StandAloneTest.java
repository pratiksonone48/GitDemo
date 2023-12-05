package framework.tests;

import java.awt.Window;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.TestComponents.BaseTest;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckOutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.LandingPage;
import framework.pageobjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {

	@Test
	public void submitOrder() throws IOException, InterruptedException
	{
		String productName = "ZARA COAT 3";
		ProductCatalogue productcatalogue = landingpage.loginApplication("pratiksonone@gmail.com", "Pratik@123");
		List<WebElement> products= productcatalogue.getProductList();
		productcatalogue.addProductToCart(productName);
		CartPage cartpage=productcatalogue.goToCartPage();
		
		Boolean match= cartpage.VerifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckOutPage checkoutpage= cartpage.goToCheckOut();
		checkoutpage.selectCountry("india");
		checkoutpage.scroll();
		ConfirmationPage confirmationpage=checkoutpage.submitOrder();
	
		String confirmMessage = confirmationpage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		
	}

}
