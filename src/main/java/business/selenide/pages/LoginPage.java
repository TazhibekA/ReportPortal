package business.selenide.pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
	private static final String URL = "https://rp.epam.com/ui/#login";
	private SelenideElement emailInput = $(By.xpath("//input[@name='login']"));
	private SelenideElement passwordInput = $(By.xpath("//input[@name='password']"));
	private SelenideElement loginButton = $(By.xpath("//button[@type='submit']"));

	public LoginPage() {
		open(URL);
		Configuration.browserSize = "1920x1080";
	}

	public LaunchesPage clickLoginButton(){
		loginButton.click();
		return page(LaunchesPage.class);
	}

	public LoginPage waitEmailInputIsDisplayed(){
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
