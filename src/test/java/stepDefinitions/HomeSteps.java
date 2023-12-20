package stepDefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import pages.HomePage;
import pages.LoginPage;

public class HomeSteps {

	private WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;

	@Dado("un usuario autenticado")
	public void un_usuario_autenticado() {

		loginPage = new LoginPage(driver);
		driver = loginPage.chromeDriverConnection();
		loginPage.visit("https://autogestionintermediarios-tst.prevencionsalud.com.ar");

		assertEquals("Ingresar con Auth0", loginPage.obtenerTituloPagina());
		
		loginPage.ingresarCampos();
		loginPage.clickIniciarSesion();
	}

	@Y("que se encuentra en el home")
	public void que_se_encuentra_en_el_home() {
		assertTrue(loginPage.isHomePageDisplayed());
	}

	@Entonces("visualiza el logo de Prevencion Salud")
	public void visualiza_el_logo_de_prevencion_salud() {
		homePage = new HomePage(driver);
		assertTrue(homePage.isLogoPrevencionDisplayed()); 
		homePage.cerrarDriver();
	}

	@Entonces("^visualiza los (.*)$")
	public void visualiza_los_items_home_afiliados_y_cobranza(String itemMenu) {
		homePage = new HomePage(driver);
		assertTrue(homePage.isItemMenuDisplayed(itemMenu));
		homePage.cerrarDriver();
	}

	@Entonces("visualiza el texto {string}")
	public void visualiza_el_texto(String textPiePagina) {

		homePage = new HomePage(driver);
		assertEquals("Grupo Sancor Seguros. Todos los derechos reservados. Copyright 2023. Argentina.", homePage.getTextOfElement()); 
		homePage.cerrarDriver();
	}

}
