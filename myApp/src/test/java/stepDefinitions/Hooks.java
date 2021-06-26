package stepDefinitions;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import driverSettings.BaseDriver;
import driverSettings.WebDriverLoader;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends BaseDriver {
    @Before
    public void setBaseDriver() throws MalformedURLException {

	setDriver();
	maximizeScreen();
    }


    private void setDriver() throws MalformedURLException {
	driver= new WebDriverLoader().loadWebDriver(getBrowser());
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebDriver getDriver() {
	return driver;
    }

    private void maximizeScreen() {
	driver.manage().window().maximize();
    }
    @After
    public void teardown() {
	System.out.println("Close browser");
	driver.quit();
    }


}
