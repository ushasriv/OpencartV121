package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity", "Master"})
	public void verify_login()
	{
		
		logger.info("*** Starting TC_002_LoginTest***");
		logger.debug("Capturing Application Debug Logs");
		try
		{
			//HomePage
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			
			//Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			
			lp.clickLogin();
			
			//MyAccount
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountPageExists();
			
			//Assert.assertEquals(targetPage, true, "Login Failed");
			Assert.assertTrue(targetPage);
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished TC_002_LoginTest");
	}
}