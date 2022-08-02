package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.productPage;
import util.DriverFactory;

public class productPageSteps {

pages.productPage productPage = new productPage(DriverFactory.getDriver());


    @Then("check product page")
    public void checkProductPage() { productPage.checkProductPage(); }

    @When("click second page")
    public void clickSecondPage() { productPage.clickSecondPage(); }

    @Then("check second page")
    public void checkSecondPage() { productPage.checkSecondPage(); }

    @When("add the {int}. product to favorite")
    public void addTheProductToFavorite(int a) { productPage.click(a); }

    @When("click close button")
    public void clickCloseButton() { productPage.clickCloseButton(); }

    @When("click favorite button")
    public void clickFavoriteButton() {
        productPage.clickFavoriteButton();
    }

}
