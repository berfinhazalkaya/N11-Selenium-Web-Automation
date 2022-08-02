package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import util.DriverFactory;

 public class loginPageSteps {

pages.loginPage loginPage = new loginPage(DriverFactory.getDriver());

    @Then("check login page")
    public void checkLoginPage() {
        loginPage.checkLoginPage();
    }

    @When("write {string} in email part")
    public void writeInEmailPart(String email) { loginPage.writeEmail(email); }

    @When("write {string} in password part")
    public void writeInPasswordPart(String psw) {
        loginPage.writePassword(psw);
    }

    @When("click show button")
    public void clickShowButton() {
        loginPage.clickShowButton();
    }

    @When("click login button in login page")
    public void clickLoginButtonInLoginPage() { loginPage.clickLoginButtonInLoginPage(); }

 }
