import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    // add a comment line to create fork, and save changes
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }
}