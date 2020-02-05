package myTestcases;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import myPageManager.PageObjectManager;
import myPages.CartPage;
import myPages.CheckoutPage;
import myPages.HomePage;
import myPages.ProductListingPage;

public class Steps 
{
	WebDriver driver;
	HomePage homePage;
	ProductListingPage productListingPage;
	CartPage cartPage;
	CheckoutPage checkoutPage;
	PageObjectManager pageObjectManager;
	
	
	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 System.setProperty("webdriver.chrome.driver","D:\\Chromedriver\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 driver.get("http://www.shop.demoqa.com");
		 pageObjectManager = new PageObjectManager(driver);
		 homePage = pageObjectManager.getHomePage();
		 homePage.navigateTo_HomePage(); 
	    //throw new PendingException();
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		homePage.perform_Search(product);
	   // throw new PendingException();
	}

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		productListingPage = pageObjectManager.getProductListingPage();
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();
	    //throw new PendingException();
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		cartPage = pageObjectManager.getCartPage();
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();
	    //throw new PendingException();
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkoutPage = pageObjectManager.getCheckoutPage();
		checkoutPage.fill_PersonalDetails();		 
	}

	@When("^select same delivery address$")
	public void select_same_delivery_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkoutPage.check_ShipToDifferentAddress(false);	    
	}

	@When("^select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkoutPage.select_PaymentMethod("CheckPayment");   
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
		driver.quit();
	}
}
