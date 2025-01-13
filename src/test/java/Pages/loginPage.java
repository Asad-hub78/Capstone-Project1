package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;
import junit.framework.Assert;

public class loginPage extends BaseClass {
	WebDriver driver = BaseClass.driver;

	@FindBy(xpath = "//*[@id='login']")
	WebElement loginBtn;
	@FindBy(xpath = "//input[@id='username']")
	WebElement enterEmail;
	@FindBy(xpath = "//input[@id='password']")
	WebElement enterPswd;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement clickLoginBtn;
	@FindBy(xpath = "//*[text()='Categories']")
	WebElement loginSuccess;
	@FindBy(xpath = "//div[text()='Username and Password is invalid!']")
	WebElement loginFailure;

	public loginPage() {
		PageFactory.initElements(driver, this);
	}

	public void loginAc(String emailVal, String passwordVal) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginBtn.click();
		enterEmail.sendKeys(emailVal);
		enterPswd.sendKeys(passwordVal);

		clickLoginBtn.click();
	}

	public void validateLoginSuccess(String expMsg) {
		String actualMsg = loginSuccess.getText();
		System.out.println(actualMsg);
		Assert.assertEquals(expMsg, actualMsg);

	}

	public void loginFailure(String expText) {
		String actualTxt = loginFailure.getText();
		System.out.println(actualTxt);
		Assert.assertEquals(expText, actualTxt);

	}

}
