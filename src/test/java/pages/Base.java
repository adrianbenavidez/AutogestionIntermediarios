package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	protected static WebDriver driver;

	public Base(WebDriver driver) {
		Base.driver = driver;
	}

	public static WebDriver chromeDriverConnection() {

		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions op = new ChromeOptions();
			op.addArguments("--incognito");

			driver = new ChromeDriver(op);
		}

		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public String getTextOfElement(By locator) {
		return driver.findElement(locator).getText();
	}

	public boolean isDisplayed(By locator) {
		if (driver.findElement(locator).isDisplayed()) {
			return true;
		} else
			return false;
	}

	public void type(String text, By locator) {
		driver.findElement(locator).sendKeys(text);
	}

	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void submit(By locator) {
		driver.findElement(locator).submit();
	}

	public void esperar(By locator, int seg) {
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(d -> driver.findElement(locator).isDisplayed());
	}

	public void visit(String url) {
		driver.get(url);
	}

	public String obtenerTituloPagina() {
		return driver.getTitle().toString();
	}

	public void cerrarDriver() {
		driver.close();
	}

	public void salirDriver() {
		driver.quit();
	}
}
