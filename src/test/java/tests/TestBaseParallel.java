package tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBaseParallel {
	
	// SauceLabs Configuration
	public static final String SAUCE_URL = "https://oauth-abdullah.nerds.test-2b04b:b6e2ea9e-3bb5-4c95-a532-c28b01e996b6@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
	
	
	public static String BaseURL = "https://demo.nopcommerce.com/";
	
	protected ThreadLocal<RemoteWebDriver> driver = null;

	@BeforeClass
	@Parameters(value = {"browser"})
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
		
		driver = new ThreadLocal<>();
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("browserName", browser);
		
		// Run on SauceLabs
		driver.set(new RemoteWebDriver(new URL(SAUCE_URL), caps));
		
		// Selenium Grid on local
//		driver.set(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
		getDriver().navigate().to(BaseURL);
	}
	
	public WebDriver getDriver() {
		return driver.get();
	}
	
	@AfterClass
	public void stopDriver() {
		getDriver().quit();
		driver.remove();
	}
	
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
		
		if (result.getStatus() == ITestResult.FAILURE) {
			System.out.println("Failed!");
			System.out.println("Taking Screenshot...");
			Helper.captureScreenShot(getDriver(), result.getTestName());
		}
	}
}
