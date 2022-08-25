package WinAppDriver;

import java.net.URL;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.windows.WindowsDriver;

public class WinAppDriver {
	WindowsDriver driver = null;
	
	public static String getDate() {
		LocalDate date = LocalDate.now();
		System.out.println(date.toString());
		return date.toString();
	}
	@BeforeTest
	public void setUptest() {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("app", "C:\\System32\\Notepad++\\notepad++.exe");
			cap.setCapability("platformName", "Windows");
			cap.setCapability("deviceName", "LAPTOP-8L8GS2SD");
			driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), cap);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void accessHomeThenContact() {
		driver.findElement(By.linkText("Home")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.linkText("Contact")).click();
	}
	@AfterTest
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
