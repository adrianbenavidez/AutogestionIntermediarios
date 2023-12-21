package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AffiliatesPage extends Base {

	private By itemMenuAffiliado = By.xpath("//a[contains(text(),'Afiliados')]");

	
	
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

	public void clickOnAfiliados() {

		esperar(itemMenuAffiliado, 5);
		
		click(itemMenuAffiliado);
	}

}
