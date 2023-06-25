package business.selenium.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {
	protected WebDriver driver;
	protected final WebDriverWait wait;
	protected static final int WAITSECONDS = 60;
	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(WAITSECONDS));
	}
}
