import javafx.util.Pair;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalMethods;

public class FindMouseWithParamsSteps {
    private static final String QUERY_PRODUCT = "Компьютерные мыши";

    public boolean findMouse(WebDriverWait wait, int minPriceValue, int maxPriceValue){


        GlobalMethods.searchField(wait, QUERY_PRODUCT);
        GlobalMethods.MinPriceField(wait, Integer.toString(minPriceValue));
        GlobalMethods.MaxPriceField(wait, Integer.toString(maxPriceValue));
        Pair<String,String> temp = FindMouseSteps.findMaxAndMin(wait);

        if(Integer.valueOf(temp.getKey()) >= minPriceValue && Integer.valueOf(temp.getValue()) <= maxPriceValue)
            return true;
        return false;


    }
}

