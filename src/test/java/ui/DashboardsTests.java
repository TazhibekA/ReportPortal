package ui;

import business.pages.LoginPage;
import common.UICommon;
import org.testng.annotations.Test;

public class DashboardsTests extends UICommon {
	@Test(priority = 1)
	public void validate(){
		LoginPage loginPage = new LoginPage(driver).openPage();
	}
}
