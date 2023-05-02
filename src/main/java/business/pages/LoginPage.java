package business.pages;

import business.common.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {
	private static final String URL = "https://rp.epam.com/ui/#login";

	@FindBy(xpath = "//input[@name='login']")
	WebElement emailInput;

	@FindBy(xpath = "//input[@name='password']")
	WebElement passwordInput;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public LoginPage openPage() {
		driver.navigate().to(URL);
		return this;
	}

	public LaunchesPage clickLoginButton(){
		loginButton.click();
		return new LaunchesPage(driver);
	}

	public LoginPage waitEmailInputIsDisplayed(){
		wait.until(ExpectedConditions.visibilityOf(emailInput));
		return this;
	}

	public LoginPage enterTextEmailInput(String email){
		emailInput.sendKeys(email);
		return this;
	}

	public LoginPage enterTextPasswordInput(String password){
		passwordInput.sendKeys(password);
		return this;
	}
}
