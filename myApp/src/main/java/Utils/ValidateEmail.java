package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class ValidateEmail extends BasePage{
    @FindBy(xpath="//input[@id='identifierId']") WebElement email;
    @FindBy(xpath="//input[@name='password']") WebElement password;
    @FindBy(xpath="//button//span[text()='Next']") WebElement nextButton;
    String jabaTalksEmail="//span[contains(text(),'JabaTalks Develop')]";
    String signedInUser="//*[contains(@aria-label,'testMail account')]";
    WebDriverWait wait = new WebDriverWait(driver, 20);


    public ValidateEmail(WebDriver driver) {
	super(driver);

    }

    public boolean checkEmail() {
	if(loginToGmail("atestmail4","Takemetospiti")) {
	    return objectExists((jabaTalksEmail));
	}
	return false;
    }

    private boolean loginToGmail(String username, String passW) {
	driver.navigate().to("https://mail.google.com/");
	email.sendKeys(username);
	nextButton.click();
	wait.until(ExpectedConditions.visibilityOf(password));
	password.sendKeys(passW);
	nextButton.click();
	if(isSignedIn())
	    return true;
	else
	    return false;

    }

    private boolean isSignedIn() {
	return objectExists(signedInUser);
    }
    
    private boolean objectExists(String selector)
    {
	
	try {
	    driver.findElement(By.xpath(selector));
	    return true;
	}
	catch (Exception e) {
	    return false;	
	    }
	
    }
}
