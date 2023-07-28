import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.time.Duration;

public class LoginTests extends BaseTest {

    @Test(description = "login with valid email and valid password")

    public void loginValidEmailValidPasswordTest() {

        LoginPage loginPage = new LoginPage(getDriver());
       // HomePage homePage = new HomePage(getDriver());

        loginPage.provideEmail("tesfaye.abagaz@testpro.io");
        loginPage.providePassword("te$t$tudent");
        loginPage.clickSubmit();
        isAvatarDisplayed();
        // Assert.assertTrue(homePage.isAvatarDisplayed());
    }
    public void isAvatarDisplayed() {
    }

    @Test (description = "login with valid email and empty password")
    public void loginValidEmailEmptyPasswordTest() {

            LoginPage loginPage = new LoginPage(getDriver());
            loginPage.provideEmail("tesfaye.abagaz@testpro.io");
            loginPage.providePassword("");
            loginPage.clickSubmit();

            Assert.assertEquals(getDriver().getCurrentUrl(), url); // https://qa.koel.app/
        }
    }

