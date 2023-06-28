package core.utils;

import org.openqa.selenium.WebDriver;

public class Actions {
	private WebDriver driver;
	private Actions actions;

	public Actions(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
	}
}
