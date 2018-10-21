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
import utils.WebDriverLoader;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    private static final String LOGIN = "tuchinstepan";
    private static final String PASSWORD = "yandextest";
    private static final String PATH = "C:\\Program Files\\SeleniumGecko\\geckodriver.exe";
    private static final int TIMEOUTSECONDS = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";


    @Description("Login test with correct data, than test checks that the user sing in.")
    @Test(groups = { "Logining" })
    public void loginTest(){
        WebDriver driver = WebDriverLoader.setDriver(PATH);
        WebDriverWait wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);

        WebDriverLoader.loadPage(driver, PAGENAME);

        LoginSteps.login(wait, driver, LOGIN, PASSWORD);

        Assert.assertEquals(LoginSteps.getUserName(wait), LOGIN);


    }
}
