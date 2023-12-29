#Author: hbenavidez@ext.sancorseguros.com
#Date: 20/12/2023
#https://signe.gruposancorseguros.com/browse/CRIO-40590
Feature: Verificacion de filtros de afiliados

  Background: 
    Given un usuario autenticado
    And que se encuentra en el home


  Scenario Outline: Busqueda de un afiliado por Documento o Nombre
    When el productor hace click en el item del menu Afiliados
    Then accede a la busqueda de afiliados
    When hace click en el combo Busqueda por
    Then se listan las opciones disponibles
    When se selecciona la opcion "Afiliado"
    And se ingresa un <Documento o Nombre>
    Then se habilita el boton Buscar
    When se hace click en el boton buscar
    Then se visualizan los datos personales del afiliado

    Examples: 
      | Documento o Nombre |
      |           22569863 |
      |           24789101 |
      |           26490081 |
      | ARRIOLA            |
      | ALVINO             |
      | VILLAR TELLO       |

  
  Scenario Outline: Busqueda de un afiliado por Contrato
    When el productor hace click en el item del menu Afiliados
    Then accede a la busqueda de afiliados
    When hace click en el combo Busqueda por
    Then se listan las opciones disponibles
    When se selecciona la opcion "Contrato"
    Then se visualiza el campo para ingresar el numero de contrato
    When el productor ingresa un <Contrato>
    Then se habilita el boton Buscar
    When se hace click en el boton buscar
    Then se visualiza una tabla con los afiliados

    Examples: 
      | Contrato |
      |    73798 |
