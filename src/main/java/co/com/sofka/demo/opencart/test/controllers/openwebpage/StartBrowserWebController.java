package co.com.sofka.demo.opencart.test.controllers.openwebpage;

import co.com.sofka.demo.opencart.test.helpers.Dictionary;
import co.com.sofka.demo.opencart.test.helpers.Helper;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.automationtools.selenium.Browser;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class StartBrowserWebController {
    private WebAction webAction;
    private String feature;
    private Browser browser;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setBrowser(Browser browser) {
        this.browser = browser;
    }

    public void openPage() {
        try{
            webAction.startWebApp(browser, Helper.getProperty(Dictionary.APP_URL_PROPERTY), feature);
        } catch (WebActionsException e){
            Report.reportFailure("Ocurrio un error al intentar abrir la pagina", e);
        }
    }

}
