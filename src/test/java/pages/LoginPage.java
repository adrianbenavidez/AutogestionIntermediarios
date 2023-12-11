package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends Base {

	By inputCorreo = By.id("1-email");
	By inputClave = By.name("password");
	By buttonIniciar = By.name("submit");
	By imgLogoPrevencion = By.xpath("//img[@src=\"/images/logo-ps-agi.svg\"]");

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void loginPage() {

		esperar(inputCorreo, 5);

		if (isDisplayed(inputCorreo)) {
			type("productor@psalud.com", inputCorreo);
			type("123456", inputClave);
			click(buttonIniciar);
		} else {
			System.out.println("Some element was not found");
		}
	}

	public boolean isHomePageDisplayed() {
		esperar(imgLogoPrevencion, 10);
		if (isDisplayed(imgLogoPrevencion)) {
			return true;
		} else
			return false;
	}

}
