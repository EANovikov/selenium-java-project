package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by xevgnov on 5/10/2017.
 */
public class WebDriverFactory {
    private static WebDriver driver;
    private static File file;
    DesiredCapabilities desiredCapabilities;

    public static WebDriver getWebDriver(String browser) throws Exception {
        if (browser.equalsIgnoreCase("Internet Explorer")) {
            file = new File("src/test/resources/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            file = new File("src/test/resources/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            file = new File("src/test/resources/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            driver = new FirefoxDriver();
        } else {
            throw new Exception("Wrong browser " + browser + " name is provided.");
        }
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        return driver;
    }
}
