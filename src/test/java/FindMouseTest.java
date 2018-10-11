
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FindMouseTest {

    private static final String PATH = "C:\\Program Files\\SeleniumGecko\\geckodriver.exe";
    private static final String QUERY_PRODUCT = "Компьютерные мыши";
    private static final String SEARCH_FIELD = "header-search";
    private static final String SEARCH_BUTTON = "button.button2";
    private static final String MIN_PRICE = "#glpricefrom";
    private static final String MAX_PRICE = "#glpriceto";
    private static final String MIN_PRICE_VALUE = "800";
    private static final String MAX_PRICE_VALUE = "1000";
    private static final String SORT_BY = "div.n-filter-sorter:nth-child(3) > a:nth-child(1)";
    private static final String REAL_PRICE_MIN = "div.n-snippet-cell2:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)";
    private static final String REAL_PRICE_MAX = "div.n-snippet-cell2:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)";

    @Description("Test finds mouses in set range.")
    @Test(groups = { "Finding" })
    public void findMouse(){

        System.setProperty("webdriver.gecko.driver", PATH);

        FirefoxOptions options = new FirefoxOptions();
        options.setCapability("marionette", false);
        WebDriver driver = new FirefoxDriver(options);


        driver.get("https://market.yandex.ru/");


        WebElement searchField = driver.findElement(By.id(SEARCH_FIELD));

        searchField.clear();

        searchField.sendKeys(QUERY_PRODUCT);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

        WebElement searchButton = driver.findElement(By.cssSelector(SEARCH_BUTTON));

        searchButton.click();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

        WebElement minPrice = driver.findElement(By.cssSelector(MIN_PRICE));
        minPrice.clear();
        minPrice.sendKeys(MIN_PRICE_VALUE);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

        WebElement maxPrice = driver.findElement(By.cssSelector(MAX_PRICE));
        maxPrice.clear();
        maxPrice.sendKeys(MAX_PRICE_VALUE);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

        WebElement sortBy = driver.findElement(By.cssSelector(SORT_BY));
        sortBy.click();
        WebElement MinPrice = driver.findElement(By.cssSelector(REAL_PRICE_MIN));
        String[] smin = MinPrice.getText().split(" ");
        sortBy.click();
        WebElement MaxPrice = driver.findElement(By.cssSelector(REAL_PRICE_MAX));
        String[] smax = MaxPrice.getText().split(" ");

        try {

            if(Integer.valueOf(smin[0]) == Integer.parseInt(MIN_PRICE_VALUE)
                    && Integer.valueOf(smax[0]) == Integer.parseInt(MAX_PRICE_VALUE))
                Assert.fail("Price doesn't match");
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }



    }
}
