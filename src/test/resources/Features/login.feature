#Author: hbenavidez@ext.sancorseguros.com
#Date: 11/12/2023
Feature: Varificación de la página de Login

  Scenario: Verificar ingreso exitoso con credenciales válidas
    Given un usuario que se encuentra en la pagina de login
    When ingresa usuario y clave validas
    And hace click en iniciar sesion
    Then navega al home

  @debug
  Scenario Outline: Verificar ingreso exitoso con múltiples credenciales válidas
    Given un usuario que se encuentra en la pagina de login
    When ingresa <usuario> y <clave> validas
    And hace click en iniciar sesion
    Then navega al home

    Examples: 
      | usuario              | clave  |
      | productor@psalud.com | 123456 |
      | cgpato@psalud.com    | 123456 |
