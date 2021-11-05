# new feature
# Tags: optional
@FeatureName:registro
Feature: Yo como usuario quiero regístrame en la página demo opencart para realizar compras.

  Background:
  Given El usuario ingresa a la pagina demo opencart con la url indicada luego de esto seleccionara My Account luego register

  @ScenarioName:RegistroExitoso
  Scenario: Registro exitoso
    When El usuario ingresa todos los datos obligatorios para el registro acepta las políticas de privacidad y dará en continue.
    Then La página responderá que ha sido creado .

  @ScenarioName:RegistroNopoliticas
  Scenario: No aceptar las políticas de privacidad
    When El usuario ingresa todos los datos obligatorios para el registro y no acepta las políticas de privacidad y dará en continue.
    Then La página responderá que debe aceptar las políticas de privacidad para realizar el registro.

  @ScenarioName:RegistroErrorPassword
  Scenario: El usuario se equivoca al momento de confirmar la contraseña
    When El usuario ingresa todos los datos obligatorios para el registro pero se equivoca en la confirmación de la contraseña y acepta las políticas de privacidad y dará en continue.
    Then La página deberá mostrar un mensaje de error en password .
