package ui;

import business.pages.LoginPage;
import common.UICommonTest;
import org.testng.annotations.Test;

public class DashboardsTests extends UICommonTest {
	@Test(priority = 1)
	public void validate(){
		LoginPage loginPage = new LoginPage(driver).openPage();
	}
}
