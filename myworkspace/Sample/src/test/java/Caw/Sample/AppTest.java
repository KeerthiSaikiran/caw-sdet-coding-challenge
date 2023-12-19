package Caw.Sample;

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

		driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");
		driver.manage().window().maximize();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority = 1)
	void testmethod() {
		driver.findElement(By.xpath("//summary[text()='Table Data']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement textbox1 = driver.findElement(By.xpath("//textarea[@id='jsondata']"));
		String str = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, {\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, {\"name\":\r\n"

				+ "\"Sara\", \"age\" : 42, \"gender\": \"female\"}, {\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, {\"name\":\r\n"

				+ "\"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]\r\n";

		JSONArray ja = new JSONArray(str);
		
		System.out.println(ja);

		textbox1.clear();

		textbox1.sendKeys(str);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(By.xpath("//button[@class='styled-click-button']")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test(priority=2)
   void getTableData() {

	WebElement table = driver.findElement(By.xpath("(//div[@class='centered']//div)[1]"));
	List<WebElement> rows = table.findElements(By.xpath(".//tr"));
	for(WebElement row:rows) {
		List<WebElement> cells = row.findElements(By.xpath(".//td"));
		for(WebElement cell : cells) {
			System.out.println(cell.getText());
    }
}

   }

	@AfterTest
	void quit() {
		driver.close();

	}

}
