package core.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JSExecutor {
	private final WebDriver driver;
	private final JavascriptExecutor jsExecutor;

	public JSExecutor(WebDriver driver) {
		this.driver = driver;
		this.jsExecutor = (JavascriptExecutor) driver;
	}

	public void scrollToElement(WebElement element) {
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void clickWithJS(WebElement element) {
		jsExecutor.executeScript("arguments[0].click();", element);
	}
}
