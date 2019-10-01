package SeleniumFirst.Selenium19;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import SeleniumFirst.Selenium19.BrowseClass;

public class NewTest1 {
	
		WebDriver driver;

		@BeforeTest
		public void beforeTest() {
			driver = BrowseClass.openBrowser("chrome");
			driver.get("http://demo.guru99.com/test/delete_customer.php");
			//driver.manage().window().maximize();
		}

		@Test
		public void handleAlert() {
			driver.findElement(By.name("cusid")).sendKeys("123");
			driver.findElement(By.name("submit")).click();
			Alert alert = driver.switchTo().alert();
			String alertText = driver.switchTo().alert().getText();
			System.out.println(alertText);
			alert.accept();

		}
		@AfterTest
		public void afterTest()
		{
		driver.close();
		}
	}

