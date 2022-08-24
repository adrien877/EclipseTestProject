import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class MainSelenium {

	ChromeDriver driver = null;
	
	@BeforeTest
	public void setUP() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium Server\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void Test(){
		driver.get("htpps://https://azure.microsoft.com/fr-fr/");
		driver.findElement(By.className("lnXdpd")).isDisplayed();
	}
	
	@Test
	public void getLogoSize() {
		driver.get("https://google.com/");
		System.out.println(driver.findElement(By.className("gNO89b")).getText());
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
		driver.quit();
		System.out.println("Test complété");
	}

}
