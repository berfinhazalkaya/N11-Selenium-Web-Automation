package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class favoritePage {

    By favoritePage = By.cssSelector(".accTitle");
    By favoriteButton = By.cssSelector("li[class='wishGroupListItem favorites'] h4[class='listItemTitle']");
    By productTitle = By.cssSelector(" a:nth-child(1) > p:nth-child(4)");
    By deleteButton = By.cssSelector(".deleteProFromFavorites");
    By okeyButton = By.cssSelector(".btn.btnBlack.confirm");
    By emptyPage = By.cssSelector(".emptyWatchList.hiddentext");

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public favoritePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkFavoritePage() {
        elementHelper.checkElementVisible(favoritePage);
    }

    public void clickFavoriteButton() {
        elementHelper.click(favoriteButton,10);
    }

    public void checkTheProductOnFavPage() {
        elementHelper.checkElementVisible(productTitle);
    }

    public void clickDeleteButton() {
        elementHelper.click(deleteButton,10);
    }

    public void clickOkeyButton() { elementHelper.click(okeyButton,10); }

    public void checkFavoritePageIsEmpty() { elementHelper.checkElementVisible(emptyPage); }
}
