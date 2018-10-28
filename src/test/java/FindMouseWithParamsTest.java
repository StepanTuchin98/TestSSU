import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.WebDriverLoader;

public class FindMouseWithParamsTest {

    private static FindMouseWithParamsSteps findMouseWithParamsSteps;
    private static final int TIMEOUTSECONDS = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";


    @BeforeMethod
    public void initialize() {
        findMouseWithParamsSteps = new FindMouseWithParamsSteps();
    }

    @DataProvider(name = "testWithParams")
    public static Object[][] valueMinMax() {
        return new Object[][]{{800, 1000}, {200, 1000}, {2000, 5000}};
    }

    @Test(dataProvider = "testWithParams")
    public void testFindMouseWithParams(int minPriceValue, int maxPriceValue) {
        WebDriver driver = WebDriverLoader.setDriver();
        WebDriverWait wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);
        WebDriverLoader.loadPage(driver, PAGENAME);

        Assert.assertTrue(findMouseWithParamsSteps.findMouse(wait, minPriceValue, maxPriceValue ));
    }

}
