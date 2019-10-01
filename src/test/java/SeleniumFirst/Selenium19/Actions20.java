package SeleniumFirst.Selenium19;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.annotations.Test;

public class Actions20 {
	WebDriver driver;
	Actions act;
	@BeforeTest
	public void beforetest() {
		driver = BrowseClass.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("http://www.demoaut.com");
	}
	@Test(priority=1)
  public void f() {
		act=new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("Home"))).build().perform();
	}
	@Test(priority=2)
	public void f1()
	{
		WebElement txt;
		//WebElement txtt;
		txt = driver.findElement(By.name("userName"));
		act = new Actions(driver);
//		act.contextClick(txt).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		act.contextClick(txt).keyDown(Keys.SHIFT).sendKeys("tutorial").sendKeys(Keys.ARROW_DOWN).click().build().perform();
		/*txtt=driver.findElement(By.name("password"));
		act=new Actions(driver);
		act.contextClick(txtt).keyDown(Keys.SHIFT).sendKeys("tutorial").sendKeys(Keys.ARROW_DOWN).click().build().perform();*/
	}
	@AfterTest
	public void afterTest() {
		driver.close();
	}
}
