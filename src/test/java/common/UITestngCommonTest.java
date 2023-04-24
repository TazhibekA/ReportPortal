package common;

import business.pages.LaunchesPage;
import business.pages.LoginPage;
import core.config.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class UITestngCommonTest {
	protected LaunchesPage launchesPage;
	protected WebDriver driver;
	@BeforeMethod()
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

	@AfterMethod(alwaysRun = true)
	public void stopBrowser()
	{
		DriverSingleton.closeDriver();
	}
}
