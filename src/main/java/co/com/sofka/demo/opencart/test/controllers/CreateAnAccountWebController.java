package co.com.sofka.demo.opencart.test.controllers;

import co.com.sofka.demo.opencart.test.helpers.Dictionary;
import co.com.sofka.demo.opencart.test.helpers.Helper;
import co.com.sofka.demo.opencart.test.models.Customer;
import co.com.sofka.demo.opencart.test.page.CreateAnAccountPage;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Report;
import co.com.sofka.test.exceptions.WebActionsException;

public class CreateAnAccountWebController {

    private WebAction webAction;
    private Customer customer;

    public void setWebAction(WebAction webAction) {
        this.webAction = webAction;
    }

    public void createAnAccount(){
            try{
                customer = Helper.generateCustomer(Dictionary.ENGLISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);
                CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

                webAction.sendText(createAnAccountPage.getFirstName(),customer.getFirstName(), true);
                webAction.sendText(createAnAccountPage.getLastName(),customer.getLastName(), true);
                webAction.sendText(
                        createAnAccountPage.getEmailAddress(),
                        customer.getEmail(),
                        2,
                        true
                );
                webAction.sendText(createAnAccountPage.getTelephone(),customer.getMobilePhone(), true);
                webAction.sendText(createAnAccountPage.getPassword(),customer.getPassword(), true);
                webAction.sendText(createAnAccountPage.getPasswordConfirm(),customer.getPassword(), true);
                webAction.click(createAnAccountPage.getPrivacyPolicy() ,true);
                webAction.click(createAnAccountPage.getBtnContinue() ,true);

            } catch (WebActionsException e)
            {
                Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
            }
    }
    public boolean yourAccountHasBeenCreated(){
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());
        return webAction.isVisible(createAnAccountPage.getVerificationMessage(), 3,true);
    }

    public void createAnAccountWithoutPrivacy(){
        try{
            customer = Helper.generateCustomer(Dictionary.ENGLISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);
            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(createAnAccountPage.getFirstName(),customer.getFirstName(), true);
            webAction.sendText(createAnAccountPage.getLastName(),customer.getLastName(), true);
            webAction.sendText(
                    createAnAccountPage.getEmailAddress(),
                    customer.getEmail(),
                    2,
                    true
            );
            webAction.sendText(createAnAccountPage.getTelephone(),customer.getMobilePhone(), true);
            webAction.sendText(createAnAccountPage.getPassword(),customer.getPassword(), true);
            webAction.sendText(createAnAccountPage.getPasswordConfirm(),customer.getPassword(), true);
            webAction.click(createAnAccountPage.getBtnContinue() ,true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta. ", e);
        }
    }

    public boolean warningMessagePage(){
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());
        return webAction.isVisible(createAnAccountPage.getWarningMessage(), 3,true);
    }


    public void createAnAccountWithPasswordError(){
        try{
            customer = Helper.generateCustomer(Dictionary.ENGLISH_CODE_LANGUAGE, Dictionary.COUNTRY_CODE, Dictionary.EMAIL_DOMAIN);
            CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());

            webAction.sendText(createAnAccountPage.getFirstName(),customer.getFirstName(), true);
            webAction.sendText(createAnAccountPage.getLastName(),customer.getLastName(), true);
            webAction.sendText(
                    createAnAccountPage.getEmailAddress(),
                    customer.getEmail(),
                    2,
                    true
            );
            webAction.sendText(createAnAccountPage.getTelephone(),customer.getMobilePhone(), true);
            webAction.sendText(createAnAccountPage.getPassword(),customer.getPassword(), true);
            webAction.sendText(createAnAccountPage.getPasswordConfirm(),customer.getPassword()+"NONE", true);
            webAction.click(createAnAccountPage.getPrivacyPolicy() ,true);
            webAction.click(createAnAccountPage.getBtnContinue() ,true);

        } catch (WebActionsException e)
        {
            Report.reportFailure("Ocurrio un error al intentar crear una cuenta.", e);
        }
    }


    public boolean warningMessagePasswordPage(){
        CreateAnAccountPage createAnAccountPage = new CreateAnAccountPage(webAction.getDriver());
        return webAction.isVisible(createAnAccountPage.getWarningMessagePassword(), 3,true);
    }


}
