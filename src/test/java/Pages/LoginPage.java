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

    @FindBy(css = "[type='email']")
    @CacheLookup
    public WebElement emailField;

    @FindBy(css = "[type='password']")
    @CacheLookup
    public WebElement passwordField;

    @FindBy(css = "[type='submit']")
    @CacheLookup
    public WebElement submitBtn;

// Applying Fluent Interface
    public LoginPage provideEmail(String email) {
       emailField.sendKeys((email));
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys((password));
        return this;
    }
    public LoginPage clickSubmit() {
        click (submitBtn);
        return this;
    }
}


/*  Using Fluent Interface...
    new minor changes are made to refine the existing codes
    Old code lines are still functional, only style changes are made

    public void provideEmail(String email) {
        emailField.sendKeys(email);
    }
    public void providePassword(String password) {
        passwordField.sendKeys(password);
    }
    public void clickSubmit() {
        submitBtn.click();
    }

The lines below are moved to LoginTests. They are working OK

    public void login() {
    provideEmail("tesfaye.abagaz@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
*/



