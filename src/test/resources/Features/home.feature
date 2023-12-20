#Author: hbenavidez@ext.sancorseguros.com
#Date: 19/12/2023
Feature: Verificación del home

  Background: 
    Given un usuario autenticado
    And que se encuentra en el home

  Scenario: Verificar icono
    Then visualiza el logo de Prevencion Salud
  
  Scenario Outline: Verificar menu
    Then visualiza los <items de menu>

    Examples: 
      | items de menu |
      | Home          |
      | Afiliados     |
      | Cobranza      |

  Scenario: Verificar pie de pagina
    Then visualiza el texto "Grupo Sancor Seguros. Todos los derechos reservados. Copyright 2023. Argentina."
