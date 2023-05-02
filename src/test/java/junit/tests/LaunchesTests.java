package junit.tests;

import junit.common.UICommonTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.testng.Assert;

public class LaunchesTests extends UICommonTest {

	@ParameterizedTest
	@ValueSource(strings = {"NAME", "START TIME", "TOTAL", "PASSED", "FAILED", "SKIPPED", "PRODUCT BUG", "AUTO BUG", "SYSTEM ISSUE", "TO INVESTIGATE"})
	public void validateColumnNamesTest(String columnName){
		Assert.assertTrue(launchesPage
						.waitAllLaunchesIsDisplayed()
						.getColumnsText().contains(columnName));
	}

	@ParameterizedTest
	@ValueSource(strings = {"Move to debug", "Force finish", "Analysis", "Unique Error analysis", "Pattern analysis", "Delete"})
	public void validateMenuActionsTest(String menuAction){
		Assert.assertTrue(launchesPage
						.waitAllLaunchesIsDisplayed()
						.waitHamburgerIconIsDisplayed()
						.clickHamburgerIcon()
						.getHamburgerMenuActionsText().contains(menuAction));
	}

	@ParameterizedTest
	@ValueSource(strings = {"Start time", "Description", "Attribute", "Total", "Passed", "Failed", "Skipped", "Product bug", "Automation bug", "System issue", "To investigate"})
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
