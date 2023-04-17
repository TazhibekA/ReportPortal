package business.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {
	protected WebDriver driver;
	protected final WebDriverWait wait;
	protected final int WAIT_TIMEOUT_SECONDS = 10;
	protected AbstractPage(WebDriver driver)
	{
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS));
	}
}
