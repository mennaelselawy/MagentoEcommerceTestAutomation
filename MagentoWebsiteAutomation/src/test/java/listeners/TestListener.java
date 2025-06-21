package listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object currentClass = result.getInstance();

        try {
            WebDriver driver = (WebDriver) currentClass.getClass()
                    .getMethod("getDriver")
                    .invoke(currentClass);

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(
                    screenshot.toPath(),
                    Paths.get("resources/screenshots/" + result.getName() + ".png")
            );
            System.out.println("✅ Screenshot saved for failed test: " + result.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
