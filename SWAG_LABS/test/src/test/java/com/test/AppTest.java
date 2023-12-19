package com.test;

import static org.testng.Assert.assertEquals;

import java.sql.Time;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.json.JSONArray;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class AppTest

{

	WebDriver driver;

	@BeforeTest
	void setup() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

	}

	@Test(priority = 0)
	void loadWebsite() {

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

   }
	
//	@Test
//	void validateUsernamePassword() {
//		driver.findElement(By.xpath("//div[@class='login-box']//form[1]")).click();
//	}
	
	@Test
	void validateTitle() {
		String title = driver.getTitle();
		assertEquals(title, "Swag Labs");
	}
	
	@Test
	void getUserNamePassword() {
//		String username = driver.findElement(By.cssSelector("div[id*=’standard_user’]")).getText();
//		String password = driver.findElement(By.cssSelector("div[id*='secret_sauce]')")).getText();
		
		String username = "standard_user";
		String password = "secret_sauce";
		
		System.out.println("username = " + username);
		System.out.println("password = " + password);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
		
//		WebElement user = driver.findElement(By.name("username"));
//		user.sendKeys(username);
//		WebElement pass = driver.findElement(By.id("password"));
//		pass.sendKeys(password);
		
	}

	@AfterTest
	void quit() {
		driver.close();

	}

}
