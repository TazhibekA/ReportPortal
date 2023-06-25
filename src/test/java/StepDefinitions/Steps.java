package StepDefinitions;

import business.selenium.pages.LaunchesPage;
import business.selenium.pages.LoginPage;
import core.config.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Steps {
	WebDriver driver;
	LaunchesPage launchesPage;

	@Before("@DDT")
	public void startBrowser(){
		driver = DriverSingleton.getDriver();
	}

	@After("@DDT")
	public void closeBrowser(){
		DriverSingleton.closeDriver();
	}

	@When("Login to reportportal")
	public void login(){
		launchesPage = new LoginPage(driver)
						.openPage()
						.waitEmailInputIsDisplayed()
						.enterTextEmailInput("aknurtazhibek")
						.enterTextPasswordInput("Totashka789")
						.clickLoginButton();
	}

	@Then("Click Launches option")
	public void clickLaunchesOption() {
		launchesPage.waitLaunchesIsDisplayed().clickLaunches();
	}

	@When("Wait all launches are displayed")
	public void waitAllLaunchesAreDisplayed() {
		launchesPage.waitAllLaunchesIsDisplayed();
	}

	@Then("Columns list has {string}")
	public void columnsListHas(String columnName) {
		Assert.assertTrue(launchesPage.getColumnsText().contains(columnName));
	}

	@When("Click hamburger icon")
	public void clickHamburgerIcon() {
		launchesPage.clickHamburgerIcon();
	}

	@Then("Menu actions have {string}")
	public void menuActionsHave(String menuAction) {
		Assert.assertTrue(launchesPage.getHamburgerMenuActionsText().contains(menuAction));
	}

	@When("Wait hamburger icon is displayed")
	public void waitHamburgerIconIsDisplayed() {
		launchesPage.waitHamburgerIconIsDisplayed();
	}

	@When("Click first launch")
	public void clickFirstLaunch() {
		launchesPage.clickFirstLaunch();
	}

	@When("Click more button")
	public void clickMoreButton() {
		launchesPage.waitMoreButtonIsDisplayed()
						.clickMoreButton();
	}

	@Then("More list have {string}")
	public void moreListHave(String moreListOption) {
		launchesPage.waitMoreListIsDisplayed()
						.getMoreListText().contains(moreListOption);
	}
}
