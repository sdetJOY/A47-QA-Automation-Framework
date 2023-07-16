import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;


public class LoginTests extends BaseTest {

    @Test
    public void loginValidEmailPasswordTest() {

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

         loginPage.provideEmail("tesfaye.abagaz@testpro.io")
                  .providePassword("te$t$tudent")
                  .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}
