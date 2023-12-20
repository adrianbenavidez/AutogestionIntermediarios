#Author: hbenavidez@ext.sancorseguros.com
#Date: 11/12/2023

Feature: Varificación de la página de Login

  Background: 
    Given un usuario que se encuentra en la pagina de login

  Scenario: Verificar ingreso exitoso con credenciales válidas
    When ingresa credenciales validas
    And hace click en iniciar sesion
    Then navega al home

  Scenario Outline: Verificar ingreso exitoso con múltiples credenciales válidas
    When ingresa <usuario> y <clave>
    And hace click en iniciar sesion
    Then navega al home

    Examples: 
      | usuario              | clave  |
      | productor@psalud.com | 123456 |
      | cgpato@psalud.com    | 123456 |
