package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".totalRow button") // checkout button
	WebElement checkoutEle;

	@FindBy(css = ".cartSection h3") //
	public List<WebElement> productTitles;

	@FindBy(css = ".card-body button:last-of-type")
	List<WebElement> addToCartButton;

	
	public Boolean VerifyProductDisplay(String productName) {
		Boolean match = productTitles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		return match;
	}

	public CheckOutPage goToCheckOut() 
	{
		checkoutEle.click();
		return new CheckOutPage(driver);
		
	}
}
