package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverLoader {

    public static WebDriver setDriver(String path){
        System.setProperty("webdriver.gecko.driver", path);

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);

        return new FirefoxDriver(options);
    }

    public static WebDriverWait setWait(WebDriver driver, int timeOutSeconds) {
        return new WebDriverWait(driver, timeOutSeconds);
    }

    public static void loadPage(WebDriver driver, String pageName){
        driver.get(pageName);
    }
}
