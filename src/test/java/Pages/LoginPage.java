package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    @FindBy(css = "[type='email']")
    public WebElement emailField;

    @FindBy(css = "[type='password']")
    public WebElement passwordField;

    @FindBy(css = "[type='submit']")
    public WebElement submitBtn;

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


