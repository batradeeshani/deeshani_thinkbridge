package pages;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.ValidateEmail;

public class SignupPage extends BasePage{
    @FindBy(xpath="//*[@placeholder='Choose Language']/span") WebElement languageDropDown;
    @FindBy(id="ui-select-choices-1") WebElement languageList;
    @FindBy(id="name") WebElement nameInput;
    @FindBy(id="orgName") WebElement orgInput;
    @FindBy(id="singUpEmail") WebElement emailInput;
    @FindBy(xpath="//input[@type='checkbox']") WebElement termsAndCondnCheckbox;
    @FindBy(xpath="//button[@type='submit' and text()='Get Started']") WebElement getStartedButton;
    String signupMsg= "//div[contains(@class, 'alert')]";
    String prefix="//a//div[text()='";
    String suffix="']";
    String email;
    WebElement langIdentifier;
    WebDriverWait wait = new WebDriverWait(driver,10);


    public SignupPage(WebDriver driver) {
	super(driver);

    }
    public WebElement getDropDownValues() {
	languageDropDown.click();
	return languageList;

    }
    public void selectLanguage(String lang) {
	langIdentifier=driver.findElement(By.xpath(prefix+lang+suffix)); 
	wait.until(
		ExpectedConditions.elementToBeClickable(langIdentifier));
	langIdentifier.click();
    }
    public void enterName(String name) {
	nameInput.clear();
	nameInput.sendKeys(name);
    }
    public void enterOrg(String org) {
	orgInput.clear();
	orgInput.sendKeys(org);	
    }
    public void enterEmailAddress() {
	Random random=new Random();
	int randomNo=random.nextInt(100);
	email="atestmail4+"+randomNo+"@gmail.com";
	emailInput.clear();
	emailInput.sendKeys(email);
    }
    public void checkTAndC() {
	JavascriptExecutor js = (JavascriptExecutor) driver;  
	js.executeScript("arguments[0].click();",termsAndCondnCheckbox);
    }
    public void signup() {
	getStartedButton.click();
    }
    public boolean validateSignupMsg() {
	try {
	    driver.findElement(By.xpath(signupMsg));
	    return true;
	}
	catch (Exception e) {
	    return false;
	}
    }
    public boolean validateEmail() {
	return new ValidateEmail(driver).checkEmail();
	
    }


}
