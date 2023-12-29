package stepDefinitions;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import pages.AffiliatesPage;
import pages.HomePage;
import pages.LoginPage;

public class AffiliatesSteps {

	WebDriver driver;
	AffiliatesPage pageAfilliates;
	HomePage home;
	LoginPage login;

	@Cuando("el productor hace click en el item del menu Afiliados")
	public void el_productor_hace_click_en_el_item_del_menu_afiliados() {

		System.out.println("desde el paso: @Cuando(\"el productor hace click en el item del menu Afiliados\")");
		// homeSteps = new HomeSteps();
		// homeSteps.un_usuario_autenticado();
		// homeSteps.que_se_encuentra_en_el_home();
		// page = new AffiliatesPage(homePage.getDriver());
		// page.clickOnAfiliados();

		pageAfilliates = new AffiliatesPage(LoginPage.chromeDriverConnection());

		pageAfilliates.clickOnAfiliados();

	}

	@Entonces("accede a la busqueda de afiliados")
	public void accede_a_la_busqueda_de_afiliados() {

		assertTrue(pageAfilliates.estaTextoBusquedaPorPresente());

	}

	@Cuando("hace click en el combo Busqueda por")
	public void hace_click_en_el_combo_busqueda_por() {
		pageAfilliates.clickOnBusquedaPor();
	}

	@Entonces("se listan las opciones disponibles")
	public void se_listan_las_opciones_disponibles() {

		assertTrue(pageAfilliates.verificarListaDeFiltros());
	}

	@Cuando("se selecciona la opcion {string}")
	public void se_selecciona_la_opcion(String parametroBusqueda) {
		pageAfilliates.clickOpcionBusqueda(parametroBusqueda);
	}

	@Cuando("^se ingresa un (.*)$")
	public void se_ingresa_un(String numero) {
		pageAfilliates.ingresarNumero(numero);
	}

	@Entonces("se visualiza el campo para ingresar el numero de contrato")
	public void se_visualiza_el_campo_para_ingresar_el_numero_de_contrato() {
	    assertTrue(pageAfilliates.estaVisibleinputNumeroContrato());
	}
	
	@Cuando("^el productor ingresa un (.*)$")
	public void el_productor_ingresa_un(String numero) {
		pageAfilliates.ingresarNumeroDeContrato(numero);
	    
	}

	@Entonces("se habilita el boton Buscar")
	public void se_habilita_el_boton_buscar() {
		assertTrue(pageAfilliates.estaHabilitado());
	}

	@Cuando("se hace click en el boton buscar")
	public void se_hace_click_en_el_boton_buscar() {
		pageAfilliates.clickBuscar();
	}

	@Entonces("se visualizan los datos personales del afiliado")
	public void se_visualizan_los_datos_personales_del_afiliado() {
		assertTrue(pageAfilliates.estanVisiblesLosColapsables());
	}
	
	@Entonces("se visualiza una tabla con los afiliados")
	public void se_visualiza_una_tabla_con_los_afiliados() {
	    assertTrue(pageAfilliates.estaVisibleLaTablaDeAfiliados());
	}

}