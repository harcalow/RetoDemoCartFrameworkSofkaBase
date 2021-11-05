package co.com.client.webproject.test.stepdefinition.register;

import co.com.client.webproject.test.controllers.CreateAnAccountWebController;
import co.com.client.webproject.test.controllers.RegisterPageController;
import co.com.client.webproject.test.controllers.openwebpage.StartBrowserWebController;
import co.com.client.webproject.test.data.objects.TestInfo;
import co.com.client.webproject.test.stepdefinition.SetupStepDefinition;
import co.com.sofka.test.actions.WebAction;
import co.com.sofka.test.evidence.reports.Assert;
import co.com.sofka.test.evidence.reports.Report;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterStepDefinition extends SetupStepDefinition {

    private WebAction webAction;

    @Before
    public void setup(Scenario scenario){
        testInfo = new TestInfo(scenario);
        webAction = new WebAction(testInfo.getFeatureName());
        webAction.setScenario(testInfo.getScenarioName());
    }


    @Given("El usuario ingresa a la pagina demo opencart con la url indicada luego de esto seleccionara My Account luego register")
    public void elUsuarioIngresaALaPaginaDemoOpencartConLaUrlIndicadaLuegoDeEstoSeleccionaraMyAccountLuegoRegister() {
        StartBrowserWebController startBrowserWebController = new StartBrowserWebController();
        startBrowserWebController.setWebAction(webAction);
        startBrowserWebController.setBrowser(browser());
        startBrowserWebController.setFeature(testInfo.getFeatureName());
        startBrowserWebController.abrirPagina();
        RegisterPageController registerPageController = new RegisterPageController();
        registerPageController.setWebAction(webAction);
        registerPageController.irHaciaRegiserPage();
    }

    @When("El usuario ingresa todos los datos obligatorios para el registro acepta las políticas de privacidad y dará en continue.")
    public void elUsuarioIngresaTodosLosDatosObligatoriosParaElRegistroAceptaLasPoliticasDePrivacidadYDaráEnContinue() {
        CreateAnAccountWebController createAnAccountWebController=new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuenta();

    }

    @Then("La página responderá que ha sido creado .")
    public void laPaginaResponderaQueHaSidoCreado() {
        CreateAnAccountWebController createAnAccountWebController=new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        Assert.Hard.thatIsTrue(createAnAccountWebController.yourAccountHasBeenCreated());
    }


    @When("El usuario ingresa todos los datos obligatorios para el registro y no acepta las políticas de privacidad y dará en continue.")
    public void elUsuarioIngresaTodosLosDatosObligatoriosParaElRegistroYNoAceptaLasPolíticasDePrivacidadYDaráEnContinue() {
        CreateAnAccountWebController createAnAccountWebController=new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuentaSinSeleccionDePrivacidad();
    }

    @Then("La página responderá que debe aceptar las políticas de privacidad para realizar el registro.")
    public void laPáginaResponderáQueDebeAceptarLasPolíticasDePrivacidadParaRealizarElRegistro() {
        CreateAnAccountWebController createAnAccountWebController=new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        Assert.Hard.thatIsTrue(createAnAccountWebController.warningMessagePage());
    }

    @When("El usuario ingresa todos los datos obligatorios para el registro pero se equivoca en la confirmación de la contraseña y acepta las políticas de privacidad y dará en continue.")
    public void elUsuarioIngresaTodosLosDatosObligatoriosParaElRegistroPeroSeEquivocaEnLaConfirmaciónDeLaContraseñaYAceptaLasPolíticasDePrivacidadYDaráEnContinue() {
        CreateAnAccountWebController createAnAccountWebController=new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        createAnAccountWebController.crearUnaCuentaErrorEnPassword();
    }

    @Then("La página deberá mostrar un mensaje de error en password .")
    public void laPáginaDeberáMostrarUnMensajeDeErrorEnPassword() {
        CreateAnAccountWebController createAnAccountWebController=new CreateAnAccountWebController();
        createAnAccountWebController.setWebAction(webAction);
        Assert.Hard.thatIsTrue(createAnAccountWebController.warningMessagePasswordPage());
    }




    @After
    public void cerrarDriver() throws InterruptedException {
        Thread.sleep(2000);

        if (webAction != null && webAction.getDriver() != null)
            webAction.closeBrowser();

        Report.reportInfo("***** HA FINALIZADO LA PRUEBA******"
                .concat(testInfo.getFeatureName())
                .concat("-")
                .concat(testInfo.getScenarioName()));
    }




}
