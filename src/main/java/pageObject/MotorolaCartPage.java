package pageObject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import util.CommonPage;
import util.WebLogger;
import java.time.Duration;

public class MotorolaCartPage {

	WebDriver driver;
	WebLogger logger;
	CommonPage commomPage;
	Alert alert;
	Double priceForProduct1, priceForProduct2, itemTotalPrice, actualDeliveryFee, actualPlatformfee, actualTaxes,
	actualFinalPrice;

	public MotorolaCartPage(WebDriver driver) {
		this.driver = driver;
		logger = new WebLogger();
		commomPage = new CommonPage(driver);

	}

	public String addProductInTheCart = "//div[contains(@class,'TopNav')]//ul//li";
	public String locateCompanyPage = "//div//a[text()='Login']";
	public String clickOnAddBtn = "//div[contains(@class,'flex items-center')]//ul//li//div//button[text()='Add']";
	public String enterLocation = "location";
	public String selectCity = "//div//ul//li//a[text()='Bangalore']";
	public String selectOneProduct = "//div[contains(@class,'CollectionGrid')]//div[@class='row']//div[1]//a//img";
	public String selectLocation = "//div[contains(@class,'style__LocationContainer')]//div[contains(@class,'style__LocationIconContainer')]/*[local-name()='svg']";
	public String selectOneLocation = "//div[contains(@class,'style__LocationBlock')]//div[contains(@class,'style__LocationContent')]//div[2]";
	public String locateSearchBar = "//div//input[contains(@placeholder,'Search for area')]";
	public String clickOnAddItemCta = "//div//span[text()='Add Item']";
	public String clickOnViewCart = "//div[contains(@class,'MenuStickyBottom_viewCart')]//button[@id='view-cart-btn']";
	public String clickOnRepeatLast = "//div//button[text()='REPEAT LAST']";
	public String clickOnIWillChoose = "//div//button[text()='I’LL CHOOSE']";
	public String selectAnotherItem = "//div[contains(@id,'cust_id')]//div//input[@type='checkbox'][1]";
	public String mouseHoverOnCart = "//div[@class='global-nav']//ul//li";
	public String clickOnCheckout = "//div//a[@href='/checkout']";
	public String clickOnSearchIcon = "//div[@class='global-nav']//ul//li//a[@href='/search']";
	public String enterResturantName = "//div//input[@placeholder='Search for restaurants and food']";
	public String searchResturant = "//div[text()='Search for restaurant and food']";
	public String selectOneresturantFromList = "//div[contains(@class,'style__ItemContainer')]//button//img";
	public String clickOnResturant = "//div[contains(@class,'Search_widgets')][2]//div[@data-testid='resturant-card-image-container']//img";
	public String addOneDish = "//ancestor::div[contains(@class,'styles_detailsContainer')]/following-sibling::div//div[text()='ADD']";
	public String clickOnContinueBtn = "//div//span[text()='Continue']";
	public String increaseTheQuantity = "//ancestor::div[contains(@class,'styles_detailsContainer')]/following-sibling::div//div[text()='+']";
	public String readProductPrice = "//button[text()='Customize'][1]/ancestor::div/following-sibling::div//span";
	public String extractTotalPrice = "//span[text()='Item Total']/parent::div/following-sibling::div//span//span[@class]";
	public String extractDeliveryFee = "//div[contains(text(),'Delivery Fee')]/parent::div/following-sibling::div//span//span[@class]";
	public String extractPlatformFee = "//div[contains(text(),'Platform fee')]/parent::div/following-sibling::div//span//span[@class]";
	public String extractTaxes = "//div[contains(text(),'GST and Restaurant')]/parent::div/following-sibling::div//span//span[@class]";
	public String extractFinalTotalPrice = "//div[contains(text(),'TO PAY')]/parent::div/child::div[@class]";

	public void navigateToAnyWebsite(String url) {
		System.out.println("..given url.." + url);
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public boolean validateCompanyPage() {
		if (commomPage.getWebElementByXpath(locateCompanyPage).isDisplayed()) {
			return true;
		} else
			return false;

	}

	public void userSelectCorrectLocation(String givenLocation) {
		WebElement ele = commomPage.getWebElementByXpath(selectLocation);
		System.out.println("..element found");
		ele.click();
		System.out.println("..element clicked");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		commomPage.getWebElementByXpath(locateSearchBar).sendKeys(givenLocation);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		List<WebElement> totalSuggestion = commomPage.getListOfWebElementByXpath(selectOneLocation);
		System.out.println("..total suggestion in the location drop down.." + totalSuggestion.size());
		commomPage.getListOfWebElementByXpath(selectOneLocation).get(0).click();
		System.out.println("..one location is selected from the drop down");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(70));
	}

	public void enterLocation() {
		commomPage.getWebElementByXpath(selectCity).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public Double convertStringPrice(String price) {
		System.out.println("..price.." + price);
		return Double.parseDouble(price);
	}

	public void increaseTheQuantityOfTheFood() {
		commomPage.getWebElementByXpath(increaseTheQuantity).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		commomPage.getWebElementByXpath(clickOnRepeatLast).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	public void addOtherItemInTheCart() {
		commomPage.getWebElementByXpath(increaseTheQuantity).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		commomPage.getWebElementByXpath(clickOnIWillChoose).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		commomPage.getListOfWebElementByXpath(selectAnotherItem).get(0).click();
		commomPage.getWebElementByXpath(clickOnAddItemCta).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public void clickOnViewCart() {
		System.out.println("..inside the view cart method..");
		Actions action = new Actions(driver);
		WebElement element = commomPage.getWebElementByXpath(mouseHoverOnCart);
		action.moveToElement(element).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void searchForResturant(String resturantName) {
		Actions action = new Actions(driver);
		WebElement element = commomPage.getWebElementByXpath(searchResturant);
		action.moveToElement(element).click().sendKeys(resturantName).build().perform();
		commomPage.getListOfWebElementByXpath(selectOneresturantFromList).get(0).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		commomPage.getWebElementByXpath(clickOnResturant).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	public void addDishName(String dishName) {
		commomPage.getWebElementByXpath("//h3[text()='" + dishName + "']" + addOneDish).click();
	}

	public void clickOnContinueBtn() {
		Actions action = new Actions(driver);
		WebElement element = commomPage.getWebElementByXpath(clickOnContinueBtn);
		action.moveToElement(element).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		action.moveToElement(element).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		action.moveToElement(commomPage.getWebElementByXpath(clickOnAddItemCta)).click().build().perform();
	}

	public void clickOnContinueIfNoCombo() {
		Actions action = new Actions(driver);
		WebElement element = commomPage.getWebElementByXpath(clickOnContinueBtn);
		action.moveToElement(element).click().build().perform();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		action.moveToElement(commomPage.getWebElementByXpath(clickOnAddItemCta)).click().build().perform();
	}

	public void increaseTheQuantity(String dishName) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("//h3[text()='" + dishName + "']" + increaseTheQuantity);
		commomPage.getWebElementByXpath("//h3[text()='" + dishName + "']" + increaseTheQuantity).click();
	}

	public void clickOnRepeatLast() {
		commomPage.getWebElementByXpath(clickOnRepeatLast).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void readProductPrice() {
		priceForProduct1 = Double.parseDouble(commomPage.getListOfWebElementByXpath(readProductPrice).get(0).getText());
		System.out.println("..price for product1.." + priceForProduct1);
		priceForProduct2 = Double.parseDouble(commomPage.getListOfWebElementByXpath(readProductPrice).get(1).getText());
		System.out.println("..price for product2.." + priceForProduct2);
	}

	public Double convertIntoDouble(WebElement element) {
		return Double.parseDouble((element).getText());
	}

	public boolean validateItemTotalPrice() {
		WebElement element = commomPage.getWebElementByXpath(extractTotalPrice);
		itemTotalPrice = convertIntoDouble(element);
		System.out.println("..item total price value.." + itemTotalPrice);
		if (itemTotalPrice == (priceForProduct1 + priceForProduct2)) {
			return true;
		} else
			return false;
	}

	public boolean calculateDeliveryFee(String expectedDeliveryFee) {
		WebElement element = commomPage.getWebElementByXpath(extractDeliveryFee);
		actualDeliveryFee = convertIntoDouble(element);
		System.out.println("..actual delivery fee.." + actualDeliveryFee);
		if (Double.parseDouble(expectedDeliveryFee) == actualDeliveryFee) {
			return true;
		} else
			return false;
	}

	public boolean calculatePlatformFee(String expectedPlatformFee) {
		WebElement element = commomPage.getWebElementByXpath(extractPlatformFee);
		actualPlatformfee = convertIntoDouble(element);
		System.out.println("..actual platform fee.." + actualPlatformfee);
		if (Double.parseDouble(expectedPlatformFee) == actualPlatformfee) {
			return true;
		} else
			return false;
	}

	public boolean calculateTaxes(String expectedTaxes) {
		WebElement element = commomPage.getWebElementByXpath(extractTaxes);
		actualTaxes = convertIntoDouble(element);
		System.out.println("..actual GSt and resturant charges.." + actualTaxes);
		if (Double.parseDouble(expectedTaxes) == actualTaxes) {
			return true;
		} else
			return false;
	}

	public boolean validateTotalPrice() {
		WebElement element = commomPage.getWebElementByXpath(extractTotalPrice);
		actualFinalPrice = convertIntoDouble(element);
		System.out.println("..actual total final price.." + actualFinalPrice);
		Double expectedTotalPrice = itemTotalPrice + actualDeliveryFee + actualPlatformfee + actualTaxes;
		System.out.println("..expected total final price.." + expectedTotalPrice);
		if (actualFinalPrice == expectedTotalPrice) {
			return true;
		} else
			return false;

	}
}
