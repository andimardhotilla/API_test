package selenium.test;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BodyEmailExtract{
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeMethod
	public void createChromeDriver() {	
		WebDriverManager.chromedriver().setup();
		driver.set (new ChromeDriver());
		driver.get().get("https://yopmail.com/en/");
		driver.get().manage().window().maximize();		
	}
	
	@Test
	public void testdalamiframe() {
		String email = "automationtest";
		driver.get().findElement(By.xpath("//input[@id='login']")).sendKeys(email);
		driver.get().findElement(By.xpath("//i[@class='material-icons-outlined f36']")).click();
		driver.get().switchTo().frame("ifmail");
		WebElement body = driver.get().findElement(By.xpath("//body"));
		String isi = body.getText();
	    System.out.println("Body email: " + isi);
	}
	
	@AfterMethod
	public void quitChromeDriver() {
		driver.get().quit();
	}
	
}
