package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import logic.dao.RoomDao;
import logic.model.Room;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;

/*
 * Author: Pierpaolo Spaziani
 */

public class AddRoomTestPierpaolo {
	
  @Test
  public void addRoom() {
	  
	WebDriver driver;
	driver = new ChromeDriver();
	
    driver.get("http://localhost:8080/FindIT/");
    driver.manage().window().setSize(new Dimension(1920, 978));
    driver.findElement(By.linkText("Profile")).click();
    driver.findElement(By.xpath("//button[@onclick=\"location.href = \'loginView.jsp\';\"]")).click();
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).sendKeys("Riccardo");
    driver.findElement(By.name("password")).sendKeys("riccardo");
    driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
    driver.findElement(By.xpath("//input[@value=\'Hotel Virgilio\']")).click();
    driver.findElement(By.xpath("//button[@onclick=\"location.href=\'addRoomPage.jsp\'\"]")).click();
    driver.findElement(By.name("id")).click();
    driver.findElement(By.name("id")).sendKeys("10");
    driver.findElement(By.name("price")).sendKeys("20");
    driver.findElement(By.name("beds")).sendKeys("2");
    driver.findElement(By.cssSelector("input:nth-child(10)")).click();

	driver.close();
    
	String roomsTable = "HotelVirgilioRooms";
	int id = 10;
	int price = 20;
	
	Room room = RoomDao.getRoom(roomsTable, id);
	
	assertEquals(price, room.getPrice());
  }
}
