package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by xevgnov on 5/10/2017.
 */
public class MainPage extends BasePage {

    private WebElement topMenu = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.className("search-main")));
    private WebElement searchButton = topMenu.findElement(By.className("input-group")).findElement(By.className("btn"));
    private WebElement searchField;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void searchByTypingTheText(String text) {
        searchButton.click();
        searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-term")));
        searchField.sendKeys(text + Keys.RETURN);
    }

    public void searchByPastingTheText(String text) {
        searchButton.click();
        searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-term")));
        saveTextToClipboard(text);
        searchField.sendKeys(Keys.LEFT_CONTROL + "v");
        searchField.sendKeys(Keys.RETURN);
    }

}
