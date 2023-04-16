package business.pages;

import business.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	static private final String url = "https://rp.epam.com/ui/#login";

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public LoginPage openPage()
	{
		driver.navigate().to(url);
		return this;
	}
}
