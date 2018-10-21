import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;

public class LoginSteps {

    private static final String ENTER_BUTTON = "html/body/div[1]/div/div[1]/noindex/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/a";
    private static final String XPATH_LOGIN = "div.passport-Domik-Form-Field:nth-child(10) > label:nth-child(1) > input:nth-child(1)";
    private static final String XPATH_PASSWORD = "div.passport-Domik-Form-Field:nth-child(11) > label:nth-child(1) > input:nth-child(1)";
    private static final String BUTTON_SINGIN = "button.passport-Button:nth-child(1)";
    private static final String USER_BUTTON = "html/body/div[1]/div/div[1]/noindex/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/a/span[1]";
    private static final String ACTUAL_USER_NAME = ".n-passport-suggest-popup-opener > a:nth-child(1) > span:nth-child(2)";

    public static void login(WebDriverWait wait, WebDriver driver, String userLogin, String userPassword){
        WebElement enter = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ENTER_BUTTON)));
        enter.click();

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        while (it.hasNext()){
            String parent = it.next();
            String newWin = it.next();
            driver.switchTo().window(newWin);

            WebElement login = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(XPATH_LOGIN)));
            login.clear();
            login.sendKeys(userLogin);

            WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(XPATH_PASSWORD)));
            password.clear();
            password.sendKeys(userPassword);

            WebElement singIn = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(BUTTON_SINGIN)));
            singIn.click();

            driver.switchTo().window(parent);
        }
        WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(USER_BUTTON)));
        user.click();
    }

    public static String getUserName(WebDriverWait wait){
        return wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(ACTUAL_USER_NAME))).getText();
    }



}
