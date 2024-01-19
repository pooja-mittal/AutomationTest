package stepdef;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.MotorolaCartPage;
import util.WebDriverFactory;
import org.testng.Assert;

public class MotorolaCartStepDefination {
	MotorolaCartPage motorolaCartPage;
	
	WebDriverFactory webDriverFactory = new WebDriverFactory();
	WebDriver driver = webDriverFactory.initalizeDriver();

	public MotorolaCartStepDefination() {
		motorolaCartPage = new MotorolaCartPage(driver);
	}
	
	@Given("User launch an application with {string}")
	public void user_launch_an_application_with(String url) {
	   motorolaCartPage.navigateToAnyWebsite(url);
	   
	}
	
	@When("Validate user navigate to given application page")
	public void validate_user_navigate_to_given_application_page() {
		Assert.assertTrue(motorolaCartPage.validateCompanyPage());
	}

	@Then("User select the location {string}")
	public void user_add_location(String givenLocation) {
		motorolaCartPage.enterLocation();
		motorolaCartPage.userSelectCorrectLocation(givenLocation);
	}

	@When("User increase the quantity of the item")
	public void user_increase_the_quantity_of_the_item() {
		motorolaCartPage.increaseTheQuantityOfTheFood();
		
	}
	
	@Then("User add other item in the cart")
		public void add_other_item_in_the_cart() {
			motorolaCartPage.addOtherItemInTheCart();
	}
	
	@When("user count the items in the cart and compare the price ")
	public void user_count_the_items_in_the_cart_and_compare_the_price () {
		
	}
	
	@Then("User search for resturant {string}")
	public void user_search_for_resturant(String resturantName) throws InterruptedException {
		Thread.sleep(3000);
		motorolaCartPage.searchForResturant(resturantName);
	}
	
	@When("User select one dish from the menu {string}")
	public void user_select_one_dish_from_the_menu(String dishName) {
		motorolaCartPage.addDishName(dishName);
	}
	
	@When("User click on continue button")
	public void user_click_on_continue_button() {
		motorolaCartPage.clickOnContinueBtn();
	}
	
	@Then("User select another dish from the menu {string}")
	public void user_another_dish_from_the_menu(String dishName) throws InterruptedException {
		Thread.sleep(2000);
		motorolaCartPage.addDishName(dishName);
	}
	
	@When("Clicks on continue")
	public void clicks_on_continue() {
		motorolaCartPage.clickOnContinueIfNoCombo();
	}
	
	@Then("User increase the quantity for second dish {string}")
	public void user_increase_the_quantity_for_second_dish(String dishName) {
		motorolaCartPage.increaseTheQuantity(dishName);
	}
	
	@Then("User click on the cart")
	public void user_click_on_cart() throws InterruptedException {
		Thread.sleep(2000);
		motorolaCartPage.clickOnViewCart();
	}
	
	@When("User read the price for the products")
	public void user_read_the_price_for_the_products() {
		motorolaCartPage.readProductPrice();
	}
	
	@Then("User validate product price with item total")
	public void User_validate_product_price_with_item_total() {
		Assert.assertTrue(motorolaCartPage.validateItemTotalPrice());
	}
	
	@Then("User validate delivery fee acc to km {string}")
	public void user_validate_delivery_fee(String expectedDeliveryFee) {
		Assert.assertTrue(motorolaCartPage.calculateDeliveryFee(expectedDeliveryFee));
	}
	
	@Then("User validate platform fee {string}")
	public void user_validate_platform_fee(String expectedPlatformFee) {
		Assert.assertTrue(motorolaCartPage.calculatePlatformFee(expectedPlatformFee));
	}
	
	@Then("User validate total taxes fee {string}")
	public void user_validate_total_taxes_fee(String expectedTaxes) {
		Assert.assertTrue(motorolaCartPage.calculateTaxes(expectedTaxes));
	}
	
	@Then("User finally validate the total price")
	public void user_finally_validate_the_total_price() {
		
	}
	
	
	@After
	public void closeBrowser() {
		driver.quit();
	}

}
