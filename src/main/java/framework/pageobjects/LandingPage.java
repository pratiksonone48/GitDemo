package framework.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent 
{
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css ="#userEmail")
	WebElement userEmail;

	@FindBy(css = "#userPassword")
	WebElement userpassword;

	@FindBy(id = "login")
	WebElement submit;
	
	@FindBy(css= "[class*='flyInOut']")
	WebElement errorMessage;

	public ProductCatalogue loginApplication(String email,String password) 
	{
		userEmail.sendKeys(email);
		userpassword.sendKeys(password);
		submit.click();
		ProductCatalogue productcatalouge = new ProductCatalogue(driver);
		return productcatalouge;
		
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
	public void goTo()

	{
		driver.get("https://www.rahulshettyacademy.com/client");
	}
}
