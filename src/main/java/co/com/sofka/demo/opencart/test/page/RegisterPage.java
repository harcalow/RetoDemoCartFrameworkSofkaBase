package co.com.sofka.demo.opencart.test.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    @CacheLookup
    @FindBy(css = ".fa-user")
    WebElement myAccount;

    @FindBy(linkText="Register")
    WebElement register;


    public WebElement getmyAccount() {
        return myAccount;
    }
    public WebElement getRegister() {
        return register;
    }

    public RegisterPage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

}
