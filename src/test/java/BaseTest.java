import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import util.WebDriverFactory;

/**
 * Created by xevgnov on 5/10/2017.
 */
public abstract class BaseTest {

    WebDriver driver;
    public static final String BASE_URL = "http://www.s3group.com/";

    @Parameters("propertyName")
    @BeforeMethod
    public void setUp(String browser) throws Exception {
        driver = WebDriverFactory.getWebDriver(browser);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                System.out.println("==PASSED==");
            } else if (result.getStatus() == ITestResult.FAILURE) {
                System.out.println("==FAILED==");
            } else if (result.getStatus() == ITestResult.SKIP) {
                System.out.println("==SKIPPED==");
            } else {
                System.out.println("==UNKNOWN RESULT==");
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

}
