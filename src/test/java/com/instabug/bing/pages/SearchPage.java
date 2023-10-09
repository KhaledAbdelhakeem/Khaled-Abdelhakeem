package com.instabug.bing.pages;

import com.instabug.bing.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class SearchPage extends BasePage {
    WebDriverWait wait;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        driver.get("https://www.bing.com/");
    }

    public boolean isSearchInputDisplayed() {
        WebElement searchBox = driver.findElement(By.id("sb_form_q"));
        if (searchBox.isDisplayed()) {
            return true;
        }
        return false;
    }

    public boolean isSearchBoxAcceptsInputs(String value) {
        sendKeys(value);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='q']")));

        WebElement searchBoxFilled = driver.findElement(By.xpath("//textarea[@name='q']"));
        String actualValue = searchBoxFilled.getText();
        String expectedValue = "Iphone";
        if (expectedValue.equals(actualValue)) {
            return true;
        }
        return false;
    }

    public void sendKeys(String value) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sb_form_q")));
        WebElement searchBox = driver.findElement(By.id("sb_form_q"));
        WebElement searchIcon = driver.findElement(By.id("search_icon"));
        searchBox.sendKeys(value);
        searchIcon.click();
    }

    public boolean isSearchResultRelevant(String value, String keyWord) {
        sendKeys(keyWord);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("cite")));
        WebElement firstLink = driver.findElements(By.tagName("cite")).get(0);
        return firstLink.getText().contains(value);
    }

    public boolean isSearchResultFoundIncaseOfSpaces(String value, String searchWord) {
        sendKeys(searchWord);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("cite")));
        WebElement firstLink = driver.findElements(By.tagName("cite")).get(0);
        return firstLink.getText().contains(value);
    }

    public boolean doesSpellingMessageAppear(String input) {
        sendKeys(input);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@name='q']")));
        WebElement spellingMessage = driver.findElement(By.id("NRPRefSpan"));
        return spellingMessage.isDisplayed();
    }
}
