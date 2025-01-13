package TestCases;

import java.time.Duration;

import org.testng.annotations.Test;

import Pages.homePage;
import Pages.loginPage;
import Pages.signUpPage;

public class TestClass extends BaseClass {
	@Test
	public void signUpTest1() {
		signUpPage sP = new signUpPage();
		sP.signUp("Sign Up - Personal");
		sP.signUpPersonalPage("Tim", "John", "Tim@abc.com", "07835143688", "John@123", "John@123");
		sP.signUpAddressPage("Flat 6", "Fernhill Street", "Newham", "E6 2hz", "London", "United Kingdom");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		sP.validatingSignUp("Welcome!");
	}

	@Test
	public void loginSuccessTest2() {
		loginPage lP = new loginPage();
		lP.loginAc("Tim@abc.com", "John@123");
		lP.validateLoginSuccess("Categories");
	}

	@Test
	public void loginFailureText() {
		loginPage lPage = new loginPage();
		lPage.loginAc("Tim@abc.com", "abc@123");
		lPage.loginFailure("Username and Password is invalid!");
	}

	@Test
	public void addToCart() {
		loginPage lP = new loginPage();
		lP.loginAc("Tim@abc.com", "John@123");
		homePage hP = new homePage();
		hP.addtoCart1();
		hP.validateAddedProdct("Product has been successfully added inside cart!");
		hP.checkoutFeatures("4658357687651243", "09", "2027", "567", "Your Order is Confirmed!!");
	}

	@Test
	public void addToCart2() {
		loginPage lP = new loginPage();
		lP.loginAc("Tim@abc.com", "John@123");
		homePage hP = new homePage();
		hP.addtoCart1();
		hP.addToCart2();
		hP.validateAddedProdct("Product has been successfully added inside cart!");
		hP.checkoutFeatures("4658357687651243", "09", "2027", "567", "Your Order is Confirmed!!");
	}
}
