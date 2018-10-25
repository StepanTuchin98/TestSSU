import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GlobalMethods;

import java.util.Iterator;
import java.util.Set;

public class LoginSteps {

    private static final String XPATH_ENTER_BUTTON = "html/body/div[1]/div/div[1]/noindex/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/div/a";
    private static final String LOGIN = "div.passport-Domik-Form-Field:nth-child(10) > label:nth-child(1) > input:nth-child(1)";
    private static final String PASSWORD = "div.passport-Domik-Form-Field:nth-child(11) > label:nth-child(1) > input:nth-child(1)";
    private static final String BUTTON_SINGIN = "button.passport-Button:nth-child(1)";
    private static final String XPATH_USER_BUTTON = "html/body/div[1]/div/div[1]/noindex/div[2]/div/div[2]/div/div[2]/div[2]/div/div[2]/div[1]/div/a/span[1]";
    private static final String ACTUAL_USER_NAME = ".n-passport-suggest-popup-opener > a:nth-child(1) > span:nth-child(2)";

    public static void login(WebDriverWait wait, WebDriver driver, String userLogin, String userPassword){
        GlobalMethods.clickElemByXPath(wait, XPATH_ENTER_BUTTON);

        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();

        while (it.hasNext()){
            String parent = it.next();
            String newWin = it.next();
            driver.switchTo().window(newWin);

            GlobalMethods.sendKeysBySelect(wait, LOGIN, userLogin);
            GlobalMethods.sendKeysBySelect(wait, PASSWORD, userPassword);
            GlobalMethods.clickElemBySelect(wait, BUTTON_SINGIN);

            driver.switchTo().window(parent);
        }
        GlobalMethods.clickElemByXPath(wait, XPATH_USER_BUTTON);
    }

    public static String getUserName(WebDriverWait wait){
        return GlobalMethods.getTextOfField(wait, ACTUAL_USER_NAME);
    }

}
