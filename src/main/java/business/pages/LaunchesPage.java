package business.pages;

import business.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LaunchesPage extends AbstractPage {
	@FindBy(xpath = "//div[contains(@class,'gridHeader')]")
	WebElement columns;

	@FindBy(xpath = "//div[contains(@class,'sidebar__top-block')]/div[2]/div//a")
	WebElement launches;

	@FindBy(xpath = "//div[text()='All launches']")
	WebElement allLaunches;

	@FindBy(xpath = "//div[contains(@class,'gridRow__grid-row-wrapper')][1]/div[2]/td/div/div[contains(@class,'hamburger__hamburger-icon')]")
	WebElement hamburgerIcon;

	@FindBy(xpath = "//div[contains(@class,'hamburger__hamburger-menu-actions')]")
	WebElement hamburgerMenuActions;

	@FindBy(xpath = "//div[contains(@class,'grid__grid')]/div[2]//div[contains(@class,'itemInfo__main')]")
	WebElement firstLaunch;

	@FindBy(xpath = "//div[contains(@class,'entitiesSelector__toggler')]")
	WebElement moreButton;

	@FindBy(xpath = "//div[contains(@class,'entitiesSelector__entities-list')]")
	WebElement moreList;

	protected LaunchesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getColumnsText(){
		return columns.getText();
	}

	public LaunchesPage waitLaunchesIsDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(launches));
		return this;
	}

	public LaunchesPage waitAllLaunchesIsDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(allLaunches));
		return this;
	}

	public LaunchesPage clickLaunches(){
		launches.click();
		return this;
	}

	public LaunchesPage clickHamburgerIcon(){
		hamburgerIcon.click();
		return this;
	}

	public String getHamburgerMenuActionsText(){
		return hamburgerMenuActions.getText();
	}

	public LaunchesPage waitHamburgerIconIsDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(hamburgerIcon));
		return this;
	}

	public LaunchesPage clickFirstLaunch(){
		firstLaunch.click();
		return this;
	}

	public LaunchesPage waitMoreButtonIsDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(moreButton));
		return this;
	}

	public LaunchesPage clickMoreButton(){
		moreButton.click();
		return this;
	}

	public LaunchesPage waitMoreListIsDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(moreList));
		return this;
	}

	public String getMoreListText(){
		return  moreList.getText();
	}
}
