package co.com.client.webproject.test.stepdefinition;

import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.sofka.test.automationtools.selenium.Browser;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupStepDefinition {
    protected TestInfo testInfo;

    public Browser browser(){
        Browser browserConfigiguration = new Browser();
        browserConfigiguration.setBrowser(Browser.Browsers.CHROME);
        browserConfigiguration.setIncognito(true);
        browserConfigiguration.setDriverVersion("95.0.4638.54");
        browserConfigiguration.setChromeOptions(chromeOptions());

        return browserConfigiguration;
    }

    private ChromeOptions chromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return options;
    }
}