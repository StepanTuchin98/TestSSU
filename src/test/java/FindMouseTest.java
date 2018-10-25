
import io.qameta.allure.Description;
import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GlobalMethods;
import utils.WebDriverLoader;

import java.util.concurrent.TimeUnit;

public class FindMouseTest {

    private static final String PATH = "C:\\Program Files\\SeleniumGecko\\geckodriver.exe";
    private static final int TIMEOUTSECONDS = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static final String QUERY_PRODUCT = "Компьютерные мыши";
    private static final String MIN_PRICE_VALUE = "800";
    private static final String MAX_PRICE_VALUE = "1000";


    @Description("Test finds mouses in set range.")
    @Test(groups = { "basic" })
    public void findMouse(){
        WebDriver driver = WebDriverLoader.setDriver(PATH);
        WebDriverWait wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);

        WebDriverLoader.loadPage(driver, PAGENAME);

        GlobalMethods.searchField(wait, QUERY_PRODUCT);
        GlobalMethods.MinPriceField(wait, MIN_PRICE_VALUE);
        GlobalMethods.MaxPriceField(wait, MAX_PRICE_VALUE);
        Pair<String,String> temp = FindMouseSteps.findMaxAndMin(wait);

        if(Integer.valueOf(temp.getKey()) >= Integer.parseInt(MIN_PRICE_VALUE)
                && Integer.valueOf(temp.getValue()) <= Integer.parseInt(MAX_PRICE_VALUE))
            Assert.fail("Price doesn't match");

    }
}
