package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TestCases.BaseClass;
import junit.framework.Assert;

public class homePage {
	WebDriver driver = BaseClass.driver;
	@FindBy(id = "listProducts")
	WebElement productList;
	@FindBy(xpath = "//tbody/tr[1]/td[6]/a[2]/span[1]")
	WebElement selectProdct;
	@FindBy(xpath = "//h3[text()='Product has been successfully added inside cart!']")
	WebElement validatePdctAdded;
	@FindBy(linkText = "Checkout")
	WebElement checkOutBtn;
	@FindBy(xpath = "//a[text()='Select']")
	WebElement selectAddresBtn;
	@FindBy(xpath = "//*[@role='button']")
	WebElement payBtn;
	@FindBy(linkText = "Continue Shopping")
	WebElement continueBtn;
	@FindBy(xpath = "//tbody/tr[2]/td[6]/a[2]")
	WebElement addProduct2;
	@FindBy(id = "cardNumber")
	WebElement insertCard;
	@FindBy(id = "expityMonth")
	WebElement insertExpMonth;
	@FindBy(id = "expityYear")
	WebElement insertExpYear;
	@FindBy(id = "cvCode")
	WebElement insertCvCode;
	@FindBy(xpath = "//div[@class='alert alert-success']/h3")
	WebElement productSuccess;

	public homePage() {
		PageFactory.initElements(driver, this);
	}

	public void addtoCart1() {
		Actions action = new Actions(driver);
		action.moveToElement(productList).click().perform();
		productList.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		selectProdct.click();

	}

	public void addToCart2() {
		Actions button = new Actions(driver);
		button.moveToElement(continueBtn).click().perform();
		continueBtn.click();
		button.moveToElement(addProduct2).click().perform();
		addProduct2.click();

	}

	public void validateAddedProdct(String expMsg) {
		String actMsg = validatePdctAdded.getText();
		System.out.println(actMsg);
		Assert.assertEquals(expMsg, actMsg);

	}

	public void checkoutFeatures(String cardNoVal, String exMonthVal, String exYearVal, String cvCodeVal,
			String exMsg) {
		Actions action2 = new Actions(driver);
		action2.moveToElement(checkOutBtn).build().perform();
		checkOutBtn.click();
		action2.moveToElement(selectAddresBtn).build().perform();
		selectAddresBtn.click();
		insertCard.sendKeys(cardNoVal);
		insertExpMonth.sendKeys(exMonthVal);
		insertExpYear.sendKeys(exYearVal);
		insertCvCode.sendKeys(cvCodeVal);
		payBtn.click();
		String actMsg = productSuccess.getText();
		System.out.println(actMsg);
		Assert.assertEquals(exMsg, actMsg);
	}
}
