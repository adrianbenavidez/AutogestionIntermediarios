package stepDefinitions;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pages.LoginPage;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.es.Cuando;

public class LoginSteps {

	private WebDriver driver;
	LoginPage page;
	
	@Dado("un usuario que se encuentra en la pagina de login")
	public void un_usuario_que_se_encuentra_en_la_pagina_de_login() {
	    System.out.println("desde - un_usuario_que_se_encuentra_en_la_pagina_de_login");
	    
	    page = new LoginPage(driver);
		driver = LoginPage.chromeDriverConnection();
		page.visit("https://autogestionintermediarios-tst.prevencionsalud.com.ar");
		
		assertEquals("Ingresar con Auth0", page.obtenerTituloPagina()); 
	    
	}

	@Cuando("ingresa credenciales validas")
	public void ingresa_credenciales_validas() {
		System.out.println("desde - ingresa_usuario_y_clave_validas");
		
		page.ingresarCampos();
		
	}
	
	@Cuando("^ingresa (.*) y (.*)$")
	public void ingresa_usuario_y_clave_params(String usuario, String clave) {
		System.out.println("FUNCION CON PARAMETROS");
		
		page.ingresarCampos(usuario, clave);
		
	}

	@Y("hace click en iniciar sesion")
	public void hace_click_en_iniciar_sesion() {
		System.out.println("desde - hace_click_en_ingresar");
		
		page.clickIniciarSesion();
	}

	@Entonces("navega al home")
	public void navega_al_home() {
		System.out.println("desde - navega_al_home");
		
		assertTrue(page.isHomePageDisplayed());
		
		page.closePage();
	}
	
}
