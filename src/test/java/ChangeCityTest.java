import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ChangeCityTest {

    private static final String PATH = "";
    private static final String ANOTHER_CITY_BUTTON = ".button2_theme_normal";
    private static final String CITY_INPUT ="div.input > span:nth-child(1) > input:nth-child(2)";
    private static final String TEMP_CITY = "Энгельс";
    private static final String BUTTON_AGREE = ".suggestick-list";
    private static final String BUTTON_CHANGE = ".button";
    private static final String INTIAL_CITY = ".n-region-notification__back-to";
    private static final String REAL_CITY = "span.link:nth-child(1) > span:nth-child(2)";
    private static final String LOCATION_CITY = "Саратов";

   
    @Test(groups = { "Changing" })
    @Description("Try to change city to another one, than change it back.")
    public void yandexMarketChangeCity(){
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\SeleniumGecko\\geckodriver.exe");

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);
        WebDriver driver = new FirefoxDriver(options);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.get("https://market.yandex.ru/");


        WebElement anotherCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ANOTHER_CITY_BUTTON)));
        anotherCity.click();

        WebElement cityInput = driver.findElement(By.cssSelector(CITY_INPUT));
        cityInput.clear();
        cityInput.sendKeys(TEMP_CITY);

        WebElement agreementCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_AGREE)));
        agreementCity.click();


        WebElement buttonChange = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_CHANGE)));
        buttonChange.click();


        WebElement intialCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(INTIAL_CITY)));
        intialCity.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        WebElement realCity = driver.findElement(By.cssSelector(REAL_CITY));
        Assert.assertEquals(realCity.getText(),LOCATION_CITY);

    }
}
