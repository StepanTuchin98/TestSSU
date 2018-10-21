package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GlobalMethods {

    private static final String SEARCH_FIELD = "header-search";
    private static final String SEARCH_BUTTON = "button.button2";
    private static final String MIN_PRICE = "#glpricefrom";
    private static final String MAX_PRICE = "#glpriceto";

    public static void searchField(WebDriverWait wait, String queryProduct) {
        WebElement searchField = wait.until(ExpectedConditions.elementToBeClickable(By.id(SEARCH_FIELD)));
        searchField.clear();
        searchField.sendKeys(queryProduct);

        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(SEARCH_BUTTON)));
        searchButton.click();
    }
    public static void MinPriceField(WebDriverWait wait, String minPriceValue) {
        WebElement minPrice =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(MIN_PRICE)));
        minPrice.clear();
        minPrice.sendKeys(minPriceValue);
    }

    public static void MaxPriceField(WebDriverWait wait, String maxPriceValue) {
        WebElement maxPrice =  wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(MAX_PRICE)));
        maxPrice.clear();
        maxPrice.sendKeys(maxPriceValue);
    }

}
