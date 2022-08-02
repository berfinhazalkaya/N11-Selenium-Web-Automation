package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.ElementHelper;

public class loginPage {

    By loginPage = By.cssSelector("div[class='leftBlock'] h2");
    By emailPart = By.cssSelector("#email");
    By passwordPart = By.cssSelector("#password");
    By showButton = By.cssSelector(".showPass");
    By loginButton = By.cssSelector("#loginButton");

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    public void checkLoginPage() {
        elementHelper.checkElementVisible(loginPage);
    }

    public void writeEmail(String email) { elementHelper.sendKey(emailPart,email); }

    public void writePassword(String psw) { elementHelper.sendKey(passwordPart, psw); }

    public void clickShowButton() {
        elementHelper.click(showButton,10);
        elementHelper.waitBySeconds(3);
    }

    public void clickLoginButtonInLoginPage() {
        elementHelper.click(loginButton,10);
        try {
            Assert.assertNotEquals("Failed to login", driver.getCurrentUrl(),
                    "https://www.n11.com/giris-yap");

            System.out.println("Member login successfully ");
        } catch (AssertionError e) {
            driver.quit();
            Assert.fail("Failed to login");
        }
    }
}
