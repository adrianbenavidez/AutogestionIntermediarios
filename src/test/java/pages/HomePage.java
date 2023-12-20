package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Base{

	private By imgLogoPrevencion = By.xpath("//img[@src='/images/logo-ps-agi.svg']");
	
	private By menuItemElement = By.xpath("//a[@target='_self']");
	private By lblPiePagina = By.xpath("//p[@class='text-gray-dark']");
	
	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isLogoPrevencionDisplayed() {
		esperar(imgLogoPrevencion,10);
		if(isDisplayed(imgLogoPrevencion)) return true;
		else return false;
	}
	
	public Boolean isItemMenuDisplayed(String itemMenu){
		
		esperar(menuItemElement,10);
		List<WebElement> lista = findElements(menuItemElement);
		
		for (WebElement webElement : lista) {
			if(webElement.getText().equalsIgnoreCase(itemMenu)) return true;
		} 
		return false;
	}
	
	public String getTextOfElement() {
		esperar(lblPiePagina,10);
		return getTextOfElement(lblPiePagina);
		
	}
	

	
}
