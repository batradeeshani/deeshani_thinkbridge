package driverSettings;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import pages.SignupPage;


public class BaseDriver extends ConfigFileReader{
   
    private String siteURL;
    private String browser;
    public static WebDriver driver;
    protected String getBrowser() {
	return browser;
    }
    protected void setBrowser(String browser) {
	this.browser = browser;
    }
    @Override
    protected void applyProperties(Properties properties) {
	// TODO Auto-generated method stub
	setSiteURL(properties.getProperty("url") );
	setBrowser(properties.getProperty("browser") );


    }
    protected String getSiteURL() {
	try {
	    URL newURL = new URL(this.siteURL);
	    return newURL.toString();
	} catch (MalformedURLException exception) {
	    throw new RuntimeException("Failed to build site url", exception);
	}
    }
    protected void setSiteURL(String siteURL) {
	this.siteURL = siteURL;
    }
    public WebDriver getDriver() {
	return driver;
}
   
    public SignupPage navigateTo() {
	getDriver().get(getSiteURL());
      return new SignupPage(getDriver());
    }
   
}
