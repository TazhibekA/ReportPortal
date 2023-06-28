package core.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult itestResult) {
		Object driver = itestResult.getTestContext().getAttribute("driver");
		if (driver != null) {
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File("c:\\tmp\\screenshot.png"));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
	}
}