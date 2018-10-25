import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.GlobalMethods;
import utils.WebDriverLoader;

public class FindRobotVacuumCleanerTest {

    private static final String PATH = "C:\\Program Files\\SeleniumGecko\\geckodriver.exe";
    private static final int TIMEOUTSECONDS = 10;
    private static final String PAGENAME = "https://market.yandex.ru/";
    private static final String LOGIN = "tuchinstepan";
    private static final String PASSWORD = "yandextest";
    private static final String QUERY_PRODUCT = "Робот пылесос";

    @Description("Login, add to the basket.")
    @Test(groups = {"Adding_to_basket"}, dependsOnMethods= "LoginTest.loginTest")
    public void addToBasket() {
        WebDriver driver = WebDriverLoader.setDriver(PATH);
        WebDriverWait wait = WebDriverLoader.setWait(driver, TIMEOUTSECONDS);

        WebDriverLoader.loadPage(driver, PAGENAME);
        LoginSteps.login(wait, driver, LOGIN, PASSWORD);

        Assert.assertEquals(LoginSteps.getUserName(wait), LOGIN);
        GlobalMethods.searchField(wait, QUERY_PRODUCT);
        FindVacuumCleanerSteps.setCheckBox(wait);
        String addedName = FindVacuumCleanerSteps.getAddedName(wait);
        FindVacuumCleanerSteps.addToDeferred(wait);
        FindVacuumCleanerSteps.checkDeferredList(wait);
        boolean res = false;
        for (WebElement w: FindVacuumCleanerSteps.getDeferredList(wait)) {
            if(w.getText().equals(addedName))
                res = true;

        }
        Assert.assertTrue(res);
    }

}
