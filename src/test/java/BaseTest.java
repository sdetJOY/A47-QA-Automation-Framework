import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

// Applying Inheritance, BaseTest class is parent to Homework17 child class
public class BaseTest {

    // we declare a java attribute using the interface WebDriver
    // we use this variable (driver) in test to control web browsers with Selenium WebDriver
    // this statement is declared so that WebDriver can be used everywhere in every test method
    public static WebDriver driver = null;

    // we declare a variable for the webpage of the practice site
    public static String url = "https://qa.koel.app/";


    // this setup is for all tests in this class (i.e. executed once)
    // we call WebDriver.Manager to manage the required driver
    // in our test, since we use Chrome as a browser, we need to resolve chromedriver
    // @BeforeSuite will run only once, before all tests in the suite are executed
    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }


    // this method is executed only once to initiate the browser
    // we added ChromeOptions argument to fix websocket error
    // @BeforeMethod will be executed before every @test annotated method
    @BeforeMethod
    public void launchBrowser() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

    // after the setup, we create driver instances (objects)
    // before interacting with the elements, we specify an implicit waite strategy; a timeout of 10 seconds
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();//maximize browser window
    }

    // at the end of the test, we need to close the browser with the method quite() of the driver object
    // @AfterMethod will be executed after every @test annotated method
    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }


    // the HANDLE (reusable) methods are defined below; they are called in the homework17 class
    public static void navigateToPage() {
        driver.get(url);
    }// we open the practice site

    public static void provideEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click(); // not needed
        emailField.clear();
        emailField.sendKeys(email);
    }

    public static void providePassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click(); // not needed
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }
}