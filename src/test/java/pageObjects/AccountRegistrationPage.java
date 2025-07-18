package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmail;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtTelephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement checkboxPolicy;
		
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement buttonContinue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String mail)
	{
		txtEmail.sendKeys(mail);
	}
	
	public void setTelephone(String tel)
	{
		txtTelephone.sendKeys(tel);
	}
	
	public void setPwd(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void setConfirmPwd(String pwd)
	{
		txtConfirmPassword.sendKeys(pwd);
	}
	
	public void setPrivacyPolicy()
	{
		checkboxPolicy.click();
	}
	
	public void clickContinue()
	{
		//sol1
		buttonContinue.click();
		
		//sol2
		//buttonContinue.submit();
		
		//sol3
//		Actions act = new Actions(driver);
//		act.moveToElement(buttonContinue).click().perform();
		
		//sol4
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click", buttonContinue);
		
		//sol5
		//buttonContinue.sendKeys(Keys.RETURN);
		
		//sol6
//		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		mywait.until(ExpectedConditions.elementToBeClickable(buttonContinue)).click();
	}
	
	public String getConfirmationMsg()
	{
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
}