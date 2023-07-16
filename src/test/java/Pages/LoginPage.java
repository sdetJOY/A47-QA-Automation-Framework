package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    @FindBy(css = "[type='email']")
    //@CacheLookup
    private WebElement emailField;

    @FindBy(css = "[type='password']")
    //@CacheLookup
    private WebElement passwordField;

    @FindBy(css = "[type='submit']")
    //@CacheLookup
    private WebElement submitBtn;


    public LoginPage provideEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage providePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmit() {
        submitBtn.click();
      return this;
    }
    public void login() {
    provideEmail("tesfaye.abagaz@testpro.io");
    providePassword("te$t$tudent");
    clickSubmit();
}
}


