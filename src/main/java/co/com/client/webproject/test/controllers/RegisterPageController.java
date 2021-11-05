package co.com.client.webproject.test.controllers;

import co.com.client.webproject.test.page.RegisterPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class RegisterPageController {
    private WebAction webAction;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void irHaciaRegiserPage(){
        try{
            RegisterPage registerPage = new RegisterPage(webAction.getDriver());
            webAction.click(registerPage.getmyAccount(), 2,true);
            webAction.click(registerPage.getRegister(), 2,true);
        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar ir a register", e);
        }
    }

}
