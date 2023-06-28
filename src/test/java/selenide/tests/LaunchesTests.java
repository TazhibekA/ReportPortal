package selenide.tests;

import core.utils.ScreenshotListener;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import selenide.common.UICommonTest;

@Listeners(ScreenshotListener.class)
public class LaunchesTests extends UICommonTest {

	@DataProvider(name = "Column names")
	public static Object[][] columnNames() {
		return new Object[][]{
						new Object[]{"NAME"},
						new Object[]{"START TIME"},
						new Object[]{"TOTAL"},
						new Object[]{"PASSED"},
						new Object[]{"FAILED"},
						new Object[]{"SKIPPED"},
						new Object[]{"PRODUCT BUG"},
						new Object[]{"AUTO BUG"},
						new Object[]{"SYSTEM ISSUE"},
						new Object[]{"TO INVESTIGATE"}
		};
	}

	@Test(dataProvider = "Column names")
	public void validateColumnNamesTest(String columnName){
		Assert.assertTrue(launchesPage
						.waitAllLaunchesIsDisplayed()
						.getColumnsText().contains(columnName));
	}
}
