package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }

    /*  @FindBy annotation is used at the attribute level
         to identify web elements in a page
        @CacheLookup is used to cache the web element location results
         (since the web page is static and its content will not change)
     */
    // web elements
    @FindBy(css = "[type='email']")
    @CacheLookup
    WebElement emailField;

    @FindBy(css = "[type='password']")
    @CacheLookup
    WebElement passwordField;

    @FindBy(css = "[type='submit']")
    @CacheLookup
    WebElement submitBtn;

   // Methods
    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        submitBtn.click();
    }

    public void login() {
        provideEmail("tesfaye.abagaz@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
    }
}

/*  Replaced by the @FindBy lines above in POM
    (used in HW #22)
    By emailField = By.cssSelector("input[type='email']");
    By passwordField = By.cssSelector("input[type='password']");
    By submitBtn = By.cssSelector("button[type='submit']");


    Replaced by the 3 methods above in POM
    (used in HW #22)

    public void provideEmail(String email) {
        findElement(emailField).sendKeys(email);
    }
    public void providePassword(String password) {
        findElement(passwordField).sendKeys(password);
    }
    public void clickSubmit() {
        findElement(submitBtn).click();
    } */

