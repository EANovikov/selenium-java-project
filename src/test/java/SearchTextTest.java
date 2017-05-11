import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.SearchResultPage;

/**
 * Created by xevgnov on 5/10/2017.
 */
public class SearchTextTest extends BaseTest {

    public static final String EXPECTED_PAGE_TITLE = "Network Search";

    @DataProvider(name = "searchParameters")
    public Object[][] createData() {
        return new Object[][]{

                {"Test", true},
                {"1", true},
                {"!Not@Existing#Text$", false},
                {"01234556789", false}
        };
    }

    @Test(dataProvider = "searchParameters")
    private void searchText(String searchInput, boolean isFound) {
        driver.get(BASE_URL);
        MainPage mainPage = new MainPage(driver);
        mainPage.searchByPastingTheText(searchInput);
        SearchResultPage searchResultPage = new SearchResultPage(driver);
        Assert.assertEquals(searchResultPage.getPageTitle(), EXPECTED_PAGE_TITLE, "Wrong page title has been found.");
        if (isFound) {
            Assert.assertTrue((searchResultPage.getSearchResultStatus().contains("matches for search term \"" + searchInput + "\".")),
                    "String " + searchResultPage.getSearchResultStatus() + " does not contain text: "
                            + "matches for search term \"" + searchInput + "\".");
            Assert.assertEquals(searchResultPage.getSearchResultContent(), "Results");
        } else {
            Assert.assertEquals(searchResultPage.getSearchResultStatus(), "Sorry, but you are looking for something that isn't here.");
            Assert.assertEquals(searchResultPage.getSearchResultContent(), null);
        }
    }

}

