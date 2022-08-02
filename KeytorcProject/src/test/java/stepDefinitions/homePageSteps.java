package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import util.DriverFactory;

public class homePageSteps {

pages.homePage homePage = new homePage(DriverFactory.getDriver());

    @Given("go to url")
    public void goToUrl() { homePage.goToUrl(); }

    @Then("check homepage title")
    public void homePageTitle() { homePage.checkHomePageTitle(); }

    @When("click lighting text button")
    public void clickLightingTextButton() {
        homePage.clickLightingTextButton();
    }

    @When("click login button")
    public void clickLoginButton() { homePage.clickLoginButton(); }

    @When("write {string} in search box")
    public void writeInSearchBox(String brand) {
        homePage.writeSamsungInSearchBox(brand);
    }

    @When("click search icon")
    public void clickSearchIcon() {
        homePage.clickSearchIcon();
    }

}
