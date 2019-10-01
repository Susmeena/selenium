package SeleniumFirst.Selenium19;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import SeleniumFirst.Selenium19.BrowseClass;


public class NewTest {
  

		WebDriver driver;
		Select sel;

		@BeforeTest
		public void beforeTest() {
			driver = BrowseClass.openBrowser("firefox");
			driver.get("http://www.newtours.demoaut.com");
		}

		@Test(priority=1)
		public void doLogin() {
			Assert.assertEquals(driver.getTitle(), "Welcome: Mercury Tours");
			System.out.println("Launched AUT");
			driver.findElement(By.name("userName")).sendKeys("mercury");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("mercury");
			driver.findElement(By.name("login")).click();
			//implicit wait
		//driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);
			//explicit wait
			WebDriverWait wait=new WebDriverWait(driver,100);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SIGN-OFF")));
			Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		}
		@Test(priority=2)
				public void flightbooking() {
			sel=new Select(driver.findElement(By.name("passCount")));
			sel.selectByIndex(2);
			driver.findElement(By.xpath("//input[@type='radio' and @value='First']")).click();
			driver.findElement(By.name("findFlights")).click();
		}
		@AfterTest
		public void afterTest()
		{
			driver.close();
		}

  }

