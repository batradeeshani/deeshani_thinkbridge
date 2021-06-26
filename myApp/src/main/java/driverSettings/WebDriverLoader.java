package driverSettings;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverLoader {
    private static final String CHROME = "chrome";
    private static final String FIREFOX = "firefox";
    private static final String HEADLESS_FIREFOX = "headless firefox";
    private static final String EDGE = "edge";
    private static final String HEADLESS_CHROME = "headless chrome";

    public WebDriver loadWebDriver(String driverType) throws MalformedURLException {
	WebDriver driver;
	switch (driverType.toLowerCase())
	{
	case CHROME:
	    driver=loadChromeDriver();
	    break;
	case HEADLESS_CHROME:
	    driver=loadHeadlessChromeDriver();
	    break;
	case FIREFOX:
	    driver=loadFirefoxDriver();
	    break;
	case HEADLESS_FIREFOX:
	    driver=loadHeadlessFirefoxDriver();
	    break;
	case EDGE:
	    driver=loadEdgeDriver();
	    break;
	default:
	{
	    WebDriverManager.chromedriver().setup();
	    driver= new ChromeDriver();
	}

	}
	return driver;

    }


    private WebDriver loadHeadlessFirefoxDriver() {
	FirefoxBinary firefoxBinary = new FirefoxBinary();
	firefoxBinary.addCommandLineOptions("--headless");
	FirefoxOptions firefoxOptions = new FirefoxOptions();
	firefoxOptions.setBinary(firefoxBinary);
	WebDriverManager.firefoxdriver().setup();
	return new FirefoxDriver(firefoxOptions);
    }
    
    private WebDriver loadHeadlessChromeDriver() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless");
	WebDriverManager.chromedriver().setup();
	return new ChromeDriver(options);
    }
    
    private WebDriver loadEdgeDriver() {
	WebDriverManager.edgedriver().setup();
	return new EdgeDriver();
    }
    
    private WebDriver loadFirefoxDriver() {
	WebDriverManager.firefoxdriver().setup();
	return new FirefoxDriver();
    }
    
    private WebDriver loadChromeDriver() {
	WebDriverManager.chromedriver().setup();
	return new ChromeDriver();
    }

}
