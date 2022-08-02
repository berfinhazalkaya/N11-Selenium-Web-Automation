package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.favoritePage;
import util.DriverFactory;

public class favoritePageSteps {

pages.favoritePage favoritePage = new favoritePage(DriverFactory.getDriver());

    @Then("check favorite page")
    public void checkFavoritePage() {
        favoritePage.checkFavoritePage();
    }

    @When("click my favorites button")
    public void clickMyFavoritesButton() {
        favoritePage.clickFavoriteButton();
    }

    @Then("check the product on favorite page")
    public void checkTheProductOnFavoritePage() {
        favoritePage.checkTheProductOnFavPage();
    }

    @When("click delete button")
    public void clickDeleteButton() {
        favoritePage.clickDeleteButton();
    }

    @When("click okey button")
    public void clickOkeyButton() {
        favoritePage.clickOkeyButton();
    }

    @Then("check favorites page is empty")
    public void checkFavoritesPageIsEmpty() {
        favoritePage.checkFavoritePageIsEmpty();
    }
}
