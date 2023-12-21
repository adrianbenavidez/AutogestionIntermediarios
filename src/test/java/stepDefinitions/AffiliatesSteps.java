package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import pages.AffiliatesPage;
import pages.HomePage;
import pages.LoginPage;

public class AffiliatesSteps {
	
	WebDriver driver;
	AffiliatesPage page;
	HomePage home;
	LoginPage login;

	
	@Cuando("el productor hace click en el item del menu Afiliados")
	public void el_productor_hace_click_en_el_item_del_menu_afiliados() {
	   
		System.out.println("desde el paso: @Cuando(\"el productor hace click en el item del menu Afiliados\")");
		//homeSteps = new HomeSteps();
		//homeSteps.un_usuario_autenticado();
		//homeSteps.que_se_encuentra_en_el_home();
	   //page = new AffiliatesPage(homePage.getDriver());
	   //page.clickOnAfiliados();
		
		page = new AffiliatesPage(LoginPage.chromeDriverConnection());
		
		page.clickOnAfiliados();
		
	}
	
	@Entonces("accede a la busqueda de afiliados")
	public void accede_a_la_busqueda_de_afiliados() {
	   
	}
	
	@Entonces("se visualiza las opciones de busqueda")
	public void se_visualiza_las_opciones_de_busqueda() {
	    
	}
	
	@Cuando("hace click en el combo Busqueda por")
	public void hace_click_en_el_combo_busqueda_por() {
	
	}
	
	@Entonces("se listan las opciones disponibles")
	public void se_listan_las_opciones_disponibles() {
	 
	}
	
	@Cuando("se selecciona la opcion {string}")
	public void se_selecciona_la_opcion(String string) {
	
	}
	
	@Cuando("se ingresa un (.*)")
	public void se_ingresa_un(Integer int1) {

	}
	
	@Entonces("se habilita el boton Buscar")
	public void se_habilita_el_boton_buscar() {
	
	}
	
	@Cuando("se hace click en el boton buscar")
	public void se_hace_click_en_el_boton_buscar() {

	}
	
	@Entonces("se visualizan los datos personales del afiliado")
	public void se_visualizan_los_datos_personales_del_afiliado() {
	   
	}

}