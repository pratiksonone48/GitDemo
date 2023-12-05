package framework.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import framework.TestComponents.BaseTest;

public class ErrorValidation extends BaseTest {

	@Test(groups = { "Errorhandling" }, retryAnalyzer = framework.TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException {

		// wrong password
		landingpage.loginApplication("anshika@gmail.com", "Iamking@000");
		Assert.assertEquals("Incorrect email or password.", landingpage.getErrorMessage());
		
	}
}
