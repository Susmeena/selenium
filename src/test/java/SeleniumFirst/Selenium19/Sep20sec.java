package SeleniumFirst.Selenium19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sep20sec {
  WebDriver driver;
  @BeforeTest
	public void beforeTest() {
		driver = BrowseClass.openBrowser("chrome");
		driver.get("http://jqueryui.com/dialog/");
		//driver.manage().window().maximize();
	}
  @Test
  public void frames()
  {
	  int size=driver.findElements(By.tagName("iframe")).size();
	  System.out.println("No of frames:"+size);
	  driver.switchTo().frame(0);
	  String txt=driver.findElement(By.xpath(".//*[@id='dialog']/p")).getText();
	  System.out.println(txt);
	  driver.findElement(By.xpath("//button[@title='Close']")).click();
  }
  @AfterTest
	public void afterTest()
	{
	//driver.close();
	}

}
