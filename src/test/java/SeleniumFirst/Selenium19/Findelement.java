package SeleniumFirst.Selenium19;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
import SeleniumFirst.Selenium19.BrowseClass;

public class Findelement {
	


	public class NewTest {
	  

			WebDriver driver;
			WebDriverWait wait;
			@BeforeTest
			public void beforeTest() {
				driver = BrowseClass.openBrowser("chrome");
				driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
			}

			@Test
			public void doLogin() {
				Assert.assertEquals(driver.getTitle(),"Home");
				System.out.println("Launched AUT");
				driver.findElement(By.linkText("SignIn")).click();
				driver.findElement(By.name("userName")).sendKeys("lalitha");
				driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Password123");
				driver.findElement(By.name("Login")).click();
				//implicit wait
			//driver.manage().timeouts().implicitlyWait(100000, TimeUnit.MILLISECONDS);
				//explicit wait
				WebDriverWait wait=new WebDriverWait(driver,100);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("SignOut")));
				Assert.assertEquals(driver.getTitle(),"Home");
			}
			@AfterTest
			public void afterTest()
			{
				driver.close();
			}

	  }


}
