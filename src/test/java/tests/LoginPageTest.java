package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import pages.LoginPage;

class LoginPageTest {

	private WebDriver driver;
	LoginPage page;
	
	@BeforeEach
	void setUp() throws Exception {
		page = new LoginPage(driver);
		driver = page.chromeDriverConnection();
		page.visit("https://autogestionintermediarios-tst.prevencionsalud.com.ar");
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	void test() throws InterruptedException {
		page.loginPage();
		assertTrue(page.isHomePageDisplayed());
	}

}
