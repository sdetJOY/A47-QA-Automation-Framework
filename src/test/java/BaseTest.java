import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

// this comment line is added to create a fork and save; allows to commit
    public class BaseTest {

    public static WebDriver driver = null;

    public static WebDriverWait wait;

    public static String url = "https://qa.koel.app/";


    @BeforeSuite
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);

        wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.manage().window().maximize();

        url = baseURL;
        navigateToPage();
    }


    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

    public void navigateToPage() {
        driver.get(url);
    }

    public void provideEmail(String email) {
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='email']")));
        //WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void providePassword(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type='password']")));
        //WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickSubmit() {
        WebElement submit = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[type='submit']")));
        //WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

}




