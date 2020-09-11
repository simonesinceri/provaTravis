/*
 * Autore: Simone Sinceri
 * In questo test con selenium testo il Login
 * */

package test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLoginSeleniumApi {
	
	
	@Test
	public void testLoginSelenium() {
	
		String user = "Simone";
		String passw = "simone";
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8080/FindIT/");
		driver.findElement(By.xpath("//*[@id=\"header\"]/ul/li[5]/a")).click();  
		driver.findElement(By.xpath("//*[@id=\"box1\"]/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"box1\"]/form/input[1]")).sendKeys(user);
		driver.findElement(By.xpath("//*[@id=\"box1\"]/form/input[2]")).sendKeys(passw);
		driver.findElement(By.xpath("//*[@id=\"box1\"]/form/input[3]")).click();
		
	
		WebElement txtBoxContent = driver.findElement(By.xpath("//*[@id=\"box1\"]/label[1]"));
		

		assertEquals(user, txtBoxContent.getText()); 
		
		driver.close();
		
	}

}
