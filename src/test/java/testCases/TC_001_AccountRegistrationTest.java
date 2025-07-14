package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass{
	
	@Test(groups={"Regression", "Master"})
	public void verify_accountRegistration()
	{
		
		logger.info("***Starting TC_001_AccountRegistrationTest");
		
		try
		{
		
			HomePage hp = new HomePage(driver);
			
			logger.info("Clicked on My Account");
			hp.clickMyAccount();
			
			logger.info("Clicked on Register");
			hp.clickRegister();
			
			AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
			
			logger.info("Providing customer details..");
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toLowerCase());
			
			regPage.setEmail(randomString()+"@gmail.com");
			regPage.setTelephone(randomNumber());
			
			String password = randomAlphaNumeric();
			
			regPage.setPwd(password);
			regPage.setConfirmPwd(password);
			
			regPage.setPrivacyPolicy();
			regPage.clickContinue();
			
			logger.info("Validating expected message");
			String confmsg = regPage.getConfirmationMsg();
			if(confmsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("Test Failed!");
				logger.debug("Debug logs!");
				Assert.assertTrue(false);
			}
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("Finished");
	}

}