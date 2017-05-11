package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Created by xevgnov on 5/10/2017.
 */
public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        System.out.println("Opened page: " + driver.getTitle());
    }

    boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void saveTextToClipboard(String buffer) {
        StringSelection stringSelection = new StringSelection(buffer);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, null);
    }
}
