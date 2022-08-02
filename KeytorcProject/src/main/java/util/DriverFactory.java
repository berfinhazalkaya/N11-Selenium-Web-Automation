package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static WebDriver driver;
    static Properties properties;

    public static WebDriver initialize_Driver(String browser) {

        properties = ConfigReader.getProperties();
            if (browser.equals("Chrome")) {
                //Setting options to avoid automation detection
                ChromeOptions options = new ChromeOptions();

                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-notifications");
                options.addArguments("--start-maximized");
                options.addArguments("--disable-web-security");
                options.addArguments("--no-proxy-server");
                options.addArguments("--enable-automation");
                options.addArguments("--disable-save-password-bubble");
                options.addArguments("--disable-popup-blocking");
                options.addArguments("--disable-plug-in");

                Map<String, Object> prefs = new HashMap<String, Object>();
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                options.setExperimentalOption("prefs", prefs);

                options.addArguments("--disable-blink-features=AutomationControlled"); //Removes the detection
                options.setExperimentalOption("useAutomationExtension", false);
                options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation",}); //Removes the banner

                DesiredCapabilities capabilities = DesiredCapabilities.chrome();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
                capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
                capabilities.setCapability(CapabilityType.SUPPORTS_LOCATION_CONTEXT, true);
                capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(options);

            } else if (browser.equals("Firefox")) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

            String url = properties.getProperty("url");
            int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
            int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
            driver.get(url);
            driver.manage().window().maximize();
            driver.manage().timeouts().pageLoadTimeout(impWait, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(pageWait, TimeUnit.SECONDS);

            return getDriver();
        }

        public static WebDriver getDriver() {
            return driver;
        }


}
