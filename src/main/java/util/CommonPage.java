package util;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPage {
	WebDriver driver;
	protected Logger log = LogManager.getLogger(this.getClass());

	public CommonPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWebElementByXpath(String xpath) {
		waitFor(By.xpath(xpath));
		return driver.findElement(By.xpath(xpath));
	}

	public WebElement getWebElementById(String id) {
		waitFor(By.id(id));
		return driver.findElement(By.id(id));
	}

	public void waitFor(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public List<WebElement> getListOfWebElementByXpath(String xpath) {
		waitFor(By.xpath(xpath));
		return driver.findElements(By.xpath(xpath));
	}

}
