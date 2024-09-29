import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

// page_url = http://www.automationpractice.pl/index.php?controller=authentication&back=my-account#account-creation
public class TestBase {

    public static WebDriver driver;

    @BeforeSuite
    public void initialize() throws IOException {

        driver = new ChromeDriver();

        // To maximize browser
        driver.manage().window().maximize();

        // Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // To open site
        driver.get("http://www.automationpractice.pl/index.php");
        wait.until(ExpectedConditions.titleIs("My Shop"));
    }


    @AfterSuite
    // Close Browser
    public void TeardownTest() {
        if (TestBase.driver != null) {
            TestBase.driver.quit();
        }
    }
}