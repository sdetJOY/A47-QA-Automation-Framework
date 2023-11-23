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
    public void loginValidEmailValidPasswordTest() {

            LoginPage loginPage = new LoginPage(driver);
            HomePage homePage = new HomePage(driver);

            loginPage.provideEmail("tesfaye.abagaz@testpro.io")
                     .providePassword("te$t$tudent")
                     .clickSubmit();

            Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        }

    @Test
    public void loginValidEmailInvalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.provideEmail("tesfaye.abagaz@testpro.io")
                 .providePassword("abc")
                 .clickSubmit();

        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
    }
}

/* Fluent Interface .....
       HomePage homePage = new HomePage(driver); not used for url

        the code below --- a one liner --- represents Fluent Interface

        loginPage.provideEmail("tesfaye.abagaz@testpro.io").providePassword("te$t$tudent").clickSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url);*/


// Alternative style to Fluent Interface, most programmers use this style

/* loginPage.login(); not used on this page since we are using the Fluent Interface.
   The locators for email, password and submit are moved to LoginTests
   as shown above. */