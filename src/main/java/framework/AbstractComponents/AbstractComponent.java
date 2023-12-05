package framework.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.CartPage;
import framework.pageobjects.OrderPage;

public class AbstractComponent

{
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForElementToAppear(By findBy) {
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofseconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

	}

	public void waitForWebElementToAppear(WebElement findBy) {
		// WebDriverWait wait = new WebDriverWait(driver,Duration.ofseconds(5));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}

	public void waitForElementToDisappear(WebElement ele) throws InterruptedException {
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeaderButton;
	
	@FindBy(css = "[routerlink*='myorders']")
	WebElement orderHeader;

	@FindBy(id = ".toast-container")
	WebElement findby;

	public CartPage goToCartPage() {
		cartHeaderButton.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}
	
	public  OrderPage goToOrdersPage() 
	{
		orderHeader.click();
		OrderPage orderpage = new OrderPage(driver);
		return orderpage;
	
	}
	
	@FindBy(css = ".ng-animating")
	WebElement ele;

}
