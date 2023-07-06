import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;

public class Homework16 extends BaseTest {

    // We add the file name "Homework16" inside TestNG file configuration
    // We use a TestNG annotation to create a test case "registrationNavigation" method
    @Test
    public void registrationNavigation() {

        // We declare the Chrome Options class to open the Chrome browser
        // We add arguments that allow to access remote origins both http and https
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        // We use a definition statement to use our script for any browser
        // We can do this by creating reference variable of WebDriver interface
        WebDriver driver = new ChromeDriver(options);

        // Before interacting with the elements, we specify an implicit waite strategy
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Creating a test case: registrationNavigation
        // Precondition: Chrome browser should be opened

        // Test step #1:
        // We navigate to the URL using the Get method (an HTTP GET request operation)
        // Open a web page
        // driver.get(url) is practically the same as navigate().to(url)
        // navigate() can track browser history and can perform back and forth in the browser
        String url = " https://qa.koel.app/";
        driver.navigate().to(url);

        // Test step $2:
        // WE find the first WebElement using a given locator in the current web page
        // We find the element based on the value: 'hel' of the Attribute/Locator: id
        // We click the Registration link using Click method
        WebElement registrationLink = driver.findElement(By.cssSelector("[id='hel']"));
        registrationLink.click();

        // Test step #3:
        // We verify that we are redirected to Registration Page (Expected Result) using Assert method
        String registrationUrl = "https://qa.koel.app/registration.php";
        Assert.assertEquals(driver.getCurrentUrl(), registrationUrl);

        // At the end of each test, we need to:
        // Close the current window
        // Then close all windows and quit the browser
        driver.close(); // optional
        driver.quit();

    }

}
