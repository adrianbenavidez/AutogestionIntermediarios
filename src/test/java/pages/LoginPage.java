package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {

	private By inputCorreo = By.id("1-email");
	private By inputClave = By.name("password");
	private By buttonIniciar = By.name("submit");
	private By imgLogoPrevencion = By.xpath("//img[@src=\"/images/logo-ps-agi.svg\"]");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ingresarCampos() {

		esperar(inputCorreo, 5);

		if (isDisplayed(inputCorreo)) {
			type("productor@psalud.com", inputCorreo);
			type("123456", inputClave);
		} else {
			System.out.println("Some element was not found [inputCorreo]");
		}
	}

	public void ingresarCampos(String usuario, String clave) {

		esperar(inputCorreo, 5);

		if (isDisplayed(inputCorreo)) {
			type(usuario, inputCorreo);
			type(clave, inputClave);
		} else {
			System.out.println("Some element was not found [inputCorreo]");
		}
	}

	public void clickIniciarSesion() {

		esperar(buttonIniciar, 5);

		if (isDisplayed(buttonIniciar)) {
			click(buttonIniciar);
		} else {
			System.out.println("Some element was not found [buttonIniciar]");
		}
	}

	public boolean isHomePageDisplayed() {
		esperar(imgLogoPrevencion, 10);
		if (isDisplayed(imgLogoPrevencion)) {
			return true;
		} else
			return false;
	}

	public void closePage() {
		cerrarDriver();
		salirDriver();
	}

}
