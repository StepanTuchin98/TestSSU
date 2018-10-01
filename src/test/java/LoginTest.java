
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static final String LOGIN = "tuchinstepan";
    private static final String PASSWORD = "yandextest";
    private static final String PATH = "C:\\Program Files\\SeleniumGecko\\geckodriver.exe";
    private static final String ENTER_BUTTON = "html/body/div[1]/div/div[1]/noindex/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/a";
    private static final String XPATH_LOGIN = "div.passport-Domik-Form-Field:nth-child(10) > label:nth-child(1) > input:nth-child(1)";
    private static final String XPATH_PASSWORD = "div.passport-Domik-Form-Field:nth-child(11) > label:nth-child(1) > input:nth-child(1)";
    private static final String BUTTON_SINGIN = "button.passport-Button:nth-child(1)";
    private static final String USER_BUTTON = "html/body/div[1]/div/div[1]/noindex/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/a/span[1]";
    private static final String ACTUAL_USER_NAME = ".n-passport-suggest-popup-opener > a:nth-child(1) > span:nth-child(2)";

    @Description("Login test with correct data, than test checks that the user sing in.")
    @Test(groups = { "Logining" })
    public void loginTest(){
        System.setProperty("webdriver.gecko.driver", PATH );
        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);
        WebDriver driver = new FirefoxDriver(options);


        driver.get("https://market.yandex.ru/");
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        WebElement enter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ENTER_BUTTON)));
        enter.click();

        Set <String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        while (it.hasNext()){
            String parent = it.next();
            String newWin = it.next();
            driver.switchTo().window(newWin);

            WebElement login = driver.findElement(By.cssSelector(XPATH_LOGIN));
            login.clear();
            login.sendKeys(LOGIN);

            WebElement password = driver.findElement(By.cssSelector(XPATH_PASSWORD));
            password.clear();
            password.sendKeys(PASSWORD);

            WebElement singIn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_SINGIN)));
            singIn.click();

            driver.switchTo().window(parent);
        }


        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(USER_BUTTON)));
        user.click();

        Assert.assertEquals(driver.findElement(By.cssSelector(ACTUAL_USER_NAME)).getText(), LOGIN);


    }
}
