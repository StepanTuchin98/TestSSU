import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.WebDriverLoader;

public class ChangeCityTest {


    private static final int TIMEOUTSECONDS = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static final String TEMP_CITY = "Энгельс";
    private static final String INITIAL_CITY = ".n-region-notification__back-to";
    private static final String REAL_CITY = "span.link:nth-child(1) > span:nth-child(2)";
    private static final String LOCATION_CITY = "Саратов";


   
    @Test(groups = { "basic" })
    @Description("Try to change city to another one, than change it back.")
    public void yandexMarketChangeCity(){
        WebDriver driver = WebDriverLoader.setDriver();
        WebDriverWait wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);

        WebDriverLoader.loadPage(driver, PAGENAME);
        ChangeCitySteps.changeCity(wait);
        ChangeCitySteps.setCity(wait, TEMP_CITY);

        String changedCity = ChangeCitySteps.getChangedCityName(wait);
        ChangeCitySteps.getInitialCityName(wait, INITIAL_CITY);
        Assert.assertEquals(changedCity, TEMP_CITY);

        String realCity = ChangeCitySteps.getRealCityName(wait, REAL_CITY);
        Assert.assertEquals(realCity, LOCATION_CITY);


    }
}
