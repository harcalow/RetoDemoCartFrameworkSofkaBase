package co.com.sofka.demo.opencart.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAnAccountPage {

    @CacheLookup
    @FindBy(id = "input-firstname")
    WebElement firstName;

    @CacheLookup
    @FindBy(id = "input-lastname")
    WebElement lastName;

    @CacheLookup
    @FindBy(id = "input-email")
    WebElement emailAddress;

    @CacheLookup
    @FindBy(id = "input-telephone")
    WebElement telephone;

    @CacheLookup
    @FindBy(id = "input-password")
    WebElement password;

    @CacheLookup
    @FindBy(id = "input-confirm")
    WebElement passwordConfirm;


    @CacheLookup
    @FindBy(name = "agree")
    WebElement privacyPolicy;

    @CacheLookup
    @FindBy(css= ".btn-primary")
    WebElement btnContinue;

    @CacheLookup
    @FindBy(id= "content")
    WebElement verificationMessage;

    @CacheLookup
    @FindBy(css= ".alert")
    WebElement warningMessage;

    @CacheLookup
    @FindBy(css= ".text-danger")
    WebElement warningMessagePassword;


    public WebElement getFirstName() {
        return firstName;
    }

    public WebElement getLastName() {
        return lastName;
    }

    public WebElement getEmailAddress() {
        return emailAddress;
    }

    public WebElement getTelephone() {
        return telephone;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getPasswordConfirm() {
        return passwordConfirm;
    }

    public WebElement getPrivacyPolicy() {
        return privacyPolicy;
    }

    public WebElement getBtnContinue() {
        return btnContinue;
    }

    public CreateAnAccountPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    public WebElement getVerificationMessage() {
        return verificationMessage;
    }

    public WebElement getWarningMessage() {
        return warningMessage;
    }

    public WebElement getWarningMessagePassword() {
        return warningMessagePassword;
    }
}
