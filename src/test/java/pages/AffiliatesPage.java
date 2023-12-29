package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AffiliatesPage extends Base {

	private By itemMenuAffiliado = By.xpath("//a[contains(text(),'Afiliados')]");
	private By textBusquedaPor = By.xpath("//label[contains(text(),'squeda por')]");
	private By listBusquedaPor = By.id("select2-filter-1-container");
	private By opcionesBusqueda = By.className("select2-results__option");
	private By opcionAfiliado = By
			.xpath("//label[contains(text(),'Búsqueda por')]/parent::div/span/span[2]/span/span[2]/ul/li");

	// private By opcionContrato =
	// By.xpath("//label[contains(text(),'mero')]/parent::div/input");

	private By opcionContrato = By
			.xpath("//label[contains(text(),'Búsqueda por')]/parent::div/span/span[2]/span/span[2]/ul/li[2]");
	private By inputNumeroContrato = By.xpath("//label[contains(text(),'mero')]/parent::div/input");

	private By inputClickNumero = By
			.xpath("//label[contains(text(),'Documento o nombre')]/parent::div/div/span/span/span/span");
	private By inputNumero = By
			.xpath("//label[contains(text(),'Documento o nombre')]/parent::div/div/span/span[2]/span/span/input");

	// private By inputCompletado = By.xpath("//label[contains(text(),'Documento o
	// nombre')]/parent::div/div/span/span[2]/span/span[2]/ul[1]");

	private By inputCompletado = By.xpath("//li[contains(text(),'22569863')]");

	private By btnBuscar = By.xpath("//button[contains(text(),'Buscar')]");

	// Localizadores para las aserciones

	private By tituloColpsDatosPersonales = By
			.xpath("//a[contains(text(),'Datos personales') and @data-toggle='collapse']");
	private By tituloColpsGrupoFamiliar = By
			.xpath("//a[contains(text(),'Grupo familiar') and @data-toggle='collapse']");
	private By tituloColpsDomicilios = By.xpath("//a[contains(text(),'Domicilios') and @data-toggle='collapse']");
	private By tituloColpsFormasDePago = By.xpath("//a[contains(text(),'Formas de pago')and @data-toggle='collapse']");
	private By tituloColpsIntermediarios = By
			.xpath("//a[contains(text(),'Intermediarios') and @data-toggle='collapse']");

	
	//Localizador de la tabla cuando se busca por contrato
	private By tablaAfiliados = By.xpath("//div[@id='affiliateTable']/div/div[2]/table");
	
	
	public AffiliatesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void clickOnAfiliadosLista() {

		List<WebElement> lista = findElements(itemMenuAffiliado);

		for (WebElement webElement : lista) {
			if (webElement.getText().equalsIgnoreCase("Afiliados"))
				webElement.click();
		}

	}

	public boolean verificarListaDeFiltros() {

		List<WebElement> lista = findElements(opcionesBusqueda);

		// Creamos una lista para contar con los valores permitidos
		ArrayList<String> filtrosValidos = new ArrayList<String>();
		filtrosValidos.add("Afiliado");
		filtrosValidos.add("Contrato");
		filtrosValidos.add("Filtros");

		for (WebElement webElement : lista) {

			if (!filtrosValidos.contains(webElement.getText()))
				return false;
		}

		return true;
	}

	public void clickOnAfiliados() {

		esperar(itemMenuAffiliado, 5);
		click(itemMenuAffiliado);
	}

	public boolean estaTextoBusquedaPorPresente() {
		esperar(itemMenuAffiliado, 5);
		if (isDisplayed(textBusquedaPor))
			return true;
		else
			return false;
	}

	public void clickOnBusquedaPor() {
		click(listBusquedaPor);
	}

	public void clickBuscar() {
		click(btnBuscar);

	}

	public void clickOpcionBusqueda(String parametroBusqueda) {
		// esperar(opcionesBusqueda, 5);

		if ("Afiliado".equals(parametroBusqueda)) {
			esperar(opcionAfiliado, 5);
			click(opcionAfiliado);
		} else if ("Contrato".equals(parametroBusqueda)) {
			esperar(opcionContrato, 5);
			click(opcionContrato);
		}

		/*
		 * List<WebElement> lista = findElements(opcionesBusqueda);
		 * 
		 * for (WebElement webElement : lista) {
		 * 
		 * if (webElement.getText().equalsIgnoreCase(parametroBusqueda))
		 * webElement.click(); }
		 */
	}

	public void ingresarNumero(String numero) {

		esperar(inputClickNumero, 5);
		click(inputClickNumero);

		type(numero, inputNumero);

		setNumero(numero);
		esperar(inputCompletado, 5);
		click(inputCompletado);

		// type(numero, inputNumero);

	}

	public void ingresarNumeroDeContrato(String numeroContrato) {

		esperar(inputNumeroContrato, 5);
		type(numeroContrato, inputNumeroContrato);
	}

	private void setNumero(String numero) {
		inputCompletado = By.xpath("//li[contains(text(),'" + numero + "')]");
	}

	public boolean estaHabilitado() {
		esperar(btnBuscar, 5);
		if (isEnabled(btnBuscar))
			return true;
		else
			return false;
	}

	public boolean estanVisiblesLosColapsables() {

		esperar(tituloColpsIntermediarios, 90);
		// Creamos una lista para contar con los valores permitidos
		ArrayList<By> listaColapsables = new ArrayList<By>();
		listaColapsables.add(tituloColpsDatosPersonales);
		listaColapsables.add(tituloColpsDomicilios);
		listaColapsables.add(tituloColpsFormasDePago);
		listaColapsables.add(tituloColpsGrupoFamiliar);
		listaColapsables.add(tituloColpsIntermediarios);

		for (By by : listaColapsables) {
			if (!isDisplayed(by)) {
				System.out.println("El elemento: " + by + "No esta presente");
				return false;
			}
		}
		return true;
	}
	
	
	public boolean estaVisibleinputNumeroContrato() {
		if (isDisplayed(inputNumeroContrato)) {
			return true;
		} 
		return false;
	}
	
	public boolean estaVisibleLaTablaDeAfiliados() {
		esperar(tablaAfiliados,60);
		if (isDisplayed(tablaAfiliados)) {
			return true;
		} 
		return false;
	}
	

}
