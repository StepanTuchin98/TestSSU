import javafx.util.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.GlobalMethods;

import java.util.concurrent.TimeUnit;

public class FindMouseSteps {

    private static final String SORT_BY = "div.n-filter-sorter:nth-child(3) > a:nth-child(1)";
    private static final String REAL_PRICE_MIN = "div.n-snippet-cell2:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)";
    private static final String REAL_PRICE_MAX = "div.n-snippet-cell2:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1)";

    public static Pair<String, String> findMaxAndMin(WebDriverWait wait){
        WebElement sortBy = GlobalMethods.clickElemBySelect(wait, SORT_BY);

        WebElement MinPrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REAL_PRICE_MIN)));
        String[] smin = MinPrice.getText().split(" ");

        sortBy.click();
        WebElement MaxPrice = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(REAL_PRICE_MAX)));
        String[] smax = MaxPrice.getText().split(" ");

        return  new Pair<String, String>(smin[0], smax[0]);
    }

}
