package selenide.common;

import business.selenide.pages.LaunchesPage;
import business.selenide.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.codeborne.selenide.testng.ScreenShooter;

import static com.codeborne.selenide.Selenide.closeWebDriver;

@Listeners({ ScreenShooter.class})
public class UICommonTest {
	protected LaunchesPage launchesPage;

	@BeforeMethod()
	public void setUp()
	{
		launchesPage = new LoginPage()
						.waitEmailInputIsDisplayed()
						.enterTextEmailInput("aknurtazhibek")
						.enterTextPasswordInput("Totashka789")
						.clickLoginButton()
						.clickLaunches();
	}

	@AfterMethod()
	public void tearDown() {
		closeWebDriver();
	}
}
