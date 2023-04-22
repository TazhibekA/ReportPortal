package ui;
import common.UICommonTest;
import org.testng.Assert;
import org.testng.annotations.*;

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

	@DataProvider(name = "Menu actions")
	public static Object[][] menuActions() {
		return new Object[][]{
						new Object[]{"Move to debug"},
						new Object[]{"Force finish"},
						new Object[]{"Analysis"},
						new Object[]{"Unique Error analysis"},
						new Object[]{"Pattern analysis"},
						new Object[]{"Delete"}
		};
	}

	@DataProvider(name = "More list")
	public static Object[][] viewTabs() {
		return new Object[][]{
						new Object[]{"Start time"},
						new Object[]{"Description"},
						new Object[]{"Attribute"},
						new Object[]{"Total"},
						new Object[]{"Passed"},
						new Object[]{"Failed"},
						new Object[]{"Skipped"},
						new Object[]{"Product bug"},
						new Object[]{"Automation bug"},
						new Object[]{"System issue"},
						new Object[]{"To investigate"}
		};
	}

	@Test(dataProvider = "Column names")
	public void validateColumnNamesTest(String columnName){
		Assert.assertTrue(launchesPage
						.waitAllLaunchesIsDisplayed()
						.getColumnsText().contains(columnName));
	}

	@Test(dataProvider = "Menu actions")
	public void validateMenuActionsTest(String menuAction){
		Assert.assertTrue(launchesPage
						.waitAllLaunchesIsDisplayed()
						.waitHamburgerIconIsDisplayed()
						.clickHamburgerIcon()
						.getHamburgerMenuActionsText().contains(menuAction));
	}

	@Test(dataProvider = "More list")
	public void validateMoreListTest(String moreListOption){
		Assert.assertTrue(launchesPage
						.waitAllLaunchesIsDisplayed()
						.waitHamburgerIconIsDisplayed()
						.clickFirstLaunch()
						.waitMoreButtonIsDisplayed()
						.clickMoreButton()
						.waitMoreListIsDisplayed()
						.getMoreListText().contains(moreListOption));
	}
}
