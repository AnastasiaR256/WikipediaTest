package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.TestCase;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class CoreTestCase extends TestCase {
    public AppiumDriver driver;
    public static String AppiumURL = "http://127.0.0.1:4723";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appium:automationName", "UiAutomator2");
        capabilities.setCapability("appium:app", "C:\\Users\\Anastasya\\IdeaProjects\\appium\\apks\\org.wikipedia.apk");
        capabilities.setCapability("appium:appPackage", "org.wikipedia");
        capabilities.setCapability("appium:appActivity", ".main.MainActivity");

        driver = new AndroidDriver(new URL(AppiumURL), capabilities);
    }

    @Override
    protected void tearDown() throws Exception {
        driver.quit();
        super.tearDown();
    }
}
