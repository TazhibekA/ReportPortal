package business.selenide.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LaunchesPage {
	private SelenideElement allLaunches = $(By.xpath("//div[text()='All launches']"));
	private SelenideElement columns = $(By.xpath("//div[contains(@class,'gridHeader')]"));
	private SelenideElement launches = $(By.xpath("//div[contains(@class,'sidebar__top-block')]/div[2]/div//a"));

	public LaunchesPage() {
	}

	public LaunchesPage waitAllLaunchesIsDisplayed(){
		$(allLaunches).shouldBe(visible);
		return this;
	}

	public String getColumnsText(){
		return columns.getText();
	}

	public LaunchesPage clickLaunches(){
		launches.click();
		return this;
	}
}
