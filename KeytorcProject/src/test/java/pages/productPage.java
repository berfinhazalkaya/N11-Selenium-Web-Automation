package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;
import java.util.List;

public class productPage {

    By secondPage = By.cssSelector("div:nth-child(4) > div:nth-child(2) > div:nth-child(5) > a:nth-child(2)");
    By closeButton = By.id("shareWinTooltipClose");
    By favoriteButton = By.cssSelector("#getWishList");


    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkProductPage() {
        if(driver.findElements(By.id("searchResultNotFound")).size()!=0)
            System.out.println("Product Not Found");

        else
            System.out.println("Product Found");

        Assert.assertTrue(driver.getTitle().contains("Samsung"));
        System.out.println("Product Page Title is : " + driver.getTitle());
    }

    public void clickSecondPage() {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0 ,3000);");
        elementHelper.click(secondPage,5);

//      Bu kodu da kullanabiliriz. Aynı işe yarıyor :
//        WebElement secondPage = driver.findElement(By.linkText("2"));
//        secondPage.click();
    }

    public void checkSecondPage() {

        if(driver.findElement(By.cssSelector("a[class^='active']")).getText().equals("2"))
            System.out.println("You are now on page 2.");
        else
            System.out.println("You are now on page " +driver.findElement(By.cssSelector("a[class^='active']")).getText());

        Assert.assertTrue(driver.getTitle().contains("2"));
        System.out.println("Secon Page Title is : " + driver.getTitle());
    }

    public void click(int a) {
        List<WebElement> element = driver.findElements(By.cssSelector(".list-ul > li"));
        element.get(2).click();
    }

    public void clickCloseButton() {
        elementHelper.click(closeButton,10);
    }

    public void clickFavoriteButton() {
        elementHelper.click(favoriteButton,10);
    }

}
