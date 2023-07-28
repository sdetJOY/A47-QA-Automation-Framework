import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;


public class BaseTest {
    public static WebDriver driver = null;

    //public ThreadLocal<WebDriver> threadDriver = null;
    public static WebDriverWait wait;

    public static String url = null;

    public static Actions actions = null;

    public static final ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
    // this driver informs java the current running thread (parallel execution), which is 2
    // threadDriver = new ThreadLocal<>(); make sure to create this object at first in front of the @BeforeMethod
    // before assigning the driver variable

    @BeforeSuite
    static void setupClass() {
    }

    @BeforeMethod
    @Parameters({"baseURL"})
    public void launchBrowser(String baseURL) throws MalformedURLException {

        threadDriver.set(pickBrowser(System.getProperty("browser")));
       // driver = (pickBrowser(System.getProperty("browser")));
       // threadDriver.set(driver);

        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().manage().window().maximize();

        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        actions = new Actions(getDriver());

        url = baseURL;
        navigateToPage();
    }

    public void navigateToPage() {
        getDriver().get(url);
    }

    @AfterMethod
    public void teardown() {
        threadDriver.get().quit();
        threadDriver.remove();
    }
    // the teardown() method is executed after each test method (@AfterMethod)
    // and its purpose is to close the WebDriver and remove its instances from ThreadLocal.
    public WebDriver getDriver() {
        return threadDriver.get();
    }
    // this getDriver() method returns the current instance of WebDriver associated with the current thread

    public static WebDriver pickBrowser(String browser) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String gridURL = "http://192.168.1.200:4444";

        switch (browser) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return driver = new FirefoxDriver();

            case "MSEdge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--remote-allow-origins=*");
                return driver = new EdgeDriver(edgeOptions);

            case "grid-firefox": //gradle clean test -DbrowserName=grid-firefox
                caps.setCapability("browser", "firefox");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-edge": //gradle clean test -DbrowserName=grid-edge
                caps.setCapability("browser", "MicrosoftEdge");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "grid-chrome": //gradle clean test -DbrowserName=grid-chrome
                caps.setCapability("browser", "chrome");
                return driver = new RemoteWebDriver(URI.create(gridURL).toURL(), caps);

            case "cloud":
                return lambdaTest();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return driver = new ChromeDriver(options);
        }
    }

    public static WebDriver lambdaTest() throws MalformedURLException {

    String username =  "bgreatspirit";
    String accessToken = "RLug8iFLFL8quwaP4PrS0t47VvVFVxkNKN84tMp9JknTnZ6bBQ";
    String hubURL = "https://hub.lambdatest.com/wd/hub";

    ChromeOptions browserOptions = new ChromeOptions();
    browserOptions.setPlatformName("Windows 10");
    browserOptions.setBrowserVersion("114.0");
    HashMap<String, Object> ltOptions = new HashMap<>();
    ltOptions.put("username", username );
    ltOptions.put("accessKey", accessToken);
    ltOptions.put("project","Untitled");
    ltOptions.put("w3c",true);
    ltOptions.put("plugin","java-testNG");
    browserOptions.setCapability("LT:Options",ltOptions);

    return new RemoteWebDriver(new URL(hubURL), browserOptions);
}
}
