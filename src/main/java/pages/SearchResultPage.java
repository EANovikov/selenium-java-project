package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

/**
 * Created by xevgnov on 5/10/2017.
 */
public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    private WebElement pageTitle = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.className("breadcrumb_last")));
    private WebElement mainPageArea = wait.until(ExpectedConditions
            .visibilityOfElementLocated(By.id("middle")));
    private List<WebElement> searchResultRows = mainPageArea.findElements(By.className("row"));
    private WebElement searchResultStatus = searchResultRows.get(1).findElement(By.cssSelector("p"));

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public String getSearchResultStatus() {
        return searchResultStatus.getText();
    }

    public String getSearchResultContent() {
        if (searchResultRows.size() >= 4) {
            return searchResultRows.get(3).findElement(By.cssSelector("h2")).getText();
        } else {
            return null;
        }
    }

}
