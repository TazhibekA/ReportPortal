package junit.common;

import business.pages.LaunchesPage;
import business.pages.LoginPage;
import core.config.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class UICommonTest {
	protected LaunchesPage launchesPage;
	protected WebDriver driver;

	@BeforeEach()
	public void setUp()
	{
		driver = DriverSingleton.getDriver();
		launchesPage = new LoginPage(driver)
						.openPage()
						.waitEmailInputIsDisplayed()
						.enterTextEmailInput("aknurtazhibek")
						.enterTextPasswordInput("Totashka789")
						.clickLoginButton()
						.waitLaunchesIsDisplayed()
						.clickLaunches();
	}

	@AfterEach
	public void stopBrowser()
	{
		DriverSingleton.closeDriver();
	}
}
