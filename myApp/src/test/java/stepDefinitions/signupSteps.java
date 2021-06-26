package stepDefinitions;

import org.openqa.selenium.WebDriver;

import driverSettings.BaseDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;

import org.junit.Assert;


public class signupSteps extends BaseDriver{

    WebDriver driver;
    SignupPage signup;

    @Given("I am at app URL")
    public void i_am_at_app_url() {
	signup = navigateTo();
    }

    @When("I validate that the dropdown has {string} and {string}")
    public void i_validate_that_the_dropdown_has_and(String string, String string2) {
	String dropDownList= signup.getDropDownValues().getText();
	Assert.assertTrue(dropDownList.contains(string));
	Assert.assertTrue(dropDownList.contains(string));
	signup.selectLanguage(string);
    }

    @When("I fill in name as {string}")
    public void i_fill_in_name_as(String string) {
	signup.enterName(string);
    }


    @When("I fill oganization as {string}")
    public void i_fill_oganization_as(String string) {
	signup.enterOrg(string);
    }

    @When("I input my email address")
    public void i_input_my_email_address() {
	signup.enterEmailAddress();
    }



    @When("I click on I agree to the Terms and Conditions")
    public void i_click_on_i_agree_to_the_terms_and_conditions() {
	signup.checkTAndC();
    }

    @When("I Click on SignUp")
    public void i_click_on_signup() {
	signup.signup();
    }

    @Then("I have signed up successfully")
    public void i_have_signed_up_successfully() {
	Assert.assertTrue(signup.validateSignupMsg());
	Assert.assertTrue(signup.validateEmail());
    }

}
