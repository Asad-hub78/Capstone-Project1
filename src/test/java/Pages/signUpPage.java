package Pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;
import junit.framework.Assert;

public class signUpPage {
	WebDriver driver = BaseClass.driver;

	@FindBy(id = "signup")
	WebElement signUpBtn;
	@FindBy(tagName = "h4")
	WebElement actualPage;
	@FindBy(id = "firstName")
	WebElement fName;
	@FindBy(name = "lastName")
	WebElement lastName;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(id = "contactNumber")
	WebElement contactNo;
	@FindBy(name = "password")
	WebElement passwd;
	@FindBy(id = "confirmPassword")
	WebElement confirmPswd;
	@FindBy(xpath = "//input[@value='USER']")
	WebElement roleBtn;
	@FindBy(tagName = "button")
	WebElement nextBtn;
	@FindBy(name = "addressLineOne")
	WebElement addLine1;
	@FindBy(id = "addressLineTwo")
	WebElement addLine2;
	@FindBy(id = "city")
	WebElement city;
	@FindBy(name = "postalCode")
	WebElement postCode;
	@FindBy(xpath = "//input[@id='state']")
	WebElement state;
	@FindBy(id = "country")
	WebElement country;
	@FindBy(name = "_eventId_confirm")
	WebElement nxtBtn;
	@FindBy(xpath = "//a[text()='Confirm']")
	WebElement confirmBtn;
	@FindBy(tagName = "h1")
	WebElement welcomeTxt;
	@FindBy(xpath = "//a[text()='Login Here']")
	WebElement clickLoginhereBtn;

	public signUpPage() {
		PageFactory.initElements(driver, this);
	}

	public void signUp(String expText) {
		signUpBtn.click();
		String actText = actualPage.getText();
		System.out.println(actText);
		Assert.assertEquals(expText, actText);

	}

	public void signUpPersonalPage(String fNameVal, String lastNameVal, String emailVal, String contactNoVal,
			String passwdVal, String confirmPswdVal) {

		fName.sendKeys(fNameVal);
		lastName.sendKeys(lastNameVal);
		email.sendKeys(emailVal);
		contactNo.sendKeys(contactNoVal);
		passwd.sendKeys(passwdVal);
		confirmPswd.sendKeys(confirmPswdVal);
		roleBtn.click();
		nextBtn.click();
	}

	public void signUpAddressPage(String addLine1Val, String addLine2Val, String cityVal, String postCodeVal,
			String stateVal, String countryVal) {

		addLine1.sendKeys(addLine1Val);
		addLine2.sendKeys(addLine2Val);
		city.sendKeys(cityVal);
		postCode.sendKeys(postCodeVal);
		state.sendKeys(stateVal);
		country.sendKeys(countryVal);
		nxtBtn.click();
		Actions action = new Actions(driver);
		action.moveToElement(confirmBtn).click().perform();
		confirmBtn.click();
		Actions action2 = new Actions(driver);
		action2.moveToElement(clickLoginhereBtn).click().perform();
		clickLoginhereBtn.click();
	}

	public void validatingSignUp(String expMsg) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String actualMsg = welcomeTxt.getText();
		System.out.println(actualMsg);
		Assert.assertEquals(expMsg, actualMsg);

	}

}