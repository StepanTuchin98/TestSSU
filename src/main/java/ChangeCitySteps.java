import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChangeCitySteps {

    private static final String ANOTHER_CITY_BUTTON = ".button2_theme_normal";
    private static final String CITY_BUTTON = "span.link:nth-child(1)";
    private static final String CITY_INPUT ="div.input > span:nth-child(1) > input:nth-child(2)";
    private static final String BUTTON_AGREE = ".suggestick-list";
    private static final String BUTTON_CHANGE = ".button";
    private static final String CHANGED_CITY ="span.link:nth-child(1) > span:nth-child(2)";



    public static void changeCity(WebDriverWait wait) {

        WebElement anotherCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ANOTHER_CITY_BUTTON)));

        WebElement City = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CITY_BUTTON)));
        if(anotherCity != null)
            anotherCity.click();
        else
            City.click();
    }


    public static void setCity(WebDriverWait wait, String tempCity) {
        WebElement cityInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CITY_INPUT)));
        cityInput.clear();
        cityInput.sendKeys(tempCity);

        WebElement agreementCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_AGREE)));
        agreementCity.click();

        WebElement buttonChange = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_CHANGE)));
        buttonChange.click();

    }

    public static String getChangedCityName(WebDriverWait wait){
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(CHANGED_CITY))).getText();
    }

    public static void getInitialCityName(WebDriverWait wait, String initial_City) {
        WebElement initialCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(initial_City)));
        initialCity.click();
    }
    public static String getRealCityName(WebDriverWait wait,String real_City) {

        WebElement realCity = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(real_City)));

        return realCity.getText();
    }




}
