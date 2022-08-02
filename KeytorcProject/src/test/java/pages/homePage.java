package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ConfigReader;
import util.ElementHelper;
import java.util.Properties;

public class homePage {

    By lightingTextButton = By.className("baseBtn-green");
    By loginButton = By.cssSelector("a[title='Giriş Yap']");
    By searchBox = By.cssSelector("#searchData");
    By searchIcon = By.cssSelector(".iconsSearch");

    WebDriver driver;
    WebDriverWait wait;
    Properties properties;
    ElementHelper elementHelper;

    public homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void goToUrl() {
        properties = ConfigReader.getProperties();
        String url = properties.getProperty("url");
        driver.get(url);
    }

    public void checkHomePageTitle() {
        Assert.assertTrue(driver.getTitle().contains("n11"));
        System.out.println("Home Page Title is : " + driver.getTitle());
    }

    public void clickLightingTextButton() {
        elementHelper.waitBySeconds(2);
        elementHelper.click(lightingTextButton,10);
    }

    public void clickLoginButton() {
        elementHelper.click(loginButton,10);
    }

    public void writeSamsungInSearchBox(String Samsung) {
        elementHelper.sendKey(searchBox,Samsung);
    }

    public void clickSearchIcon() {
        elementHelper.click(searchIcon,10);
    }


}
