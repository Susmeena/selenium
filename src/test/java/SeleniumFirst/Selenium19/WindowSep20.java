package SeleniumFirst.Selenium19;

import java.util.Set;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import SeleniumFirst.Selenium19.BrowseClass;
public class WindowSep20 {
	WebDriver driver;

	@BeforeTest
	public void beforetest() {
		driver = BrowseClass.openBrowser("chrome");
		driver.manage().window().maximize();
		driver.get("http://www.naukri.com/");
	}

	@Test
	public void TestPopUp() {
		String parent = driver.getWindowHandle();
//		driver.switchTo().window(parent);
		Set<String> s1 = driver.getWindowHandles();
		//Iterator<String> I1 = s1.iterator();
		//while (I1.hasNext()) {
			//String child_window = I1.next();
		for (String i:s1) {
			String child_window=i;
			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);
				System.out.println(driver.switchTo().window(child_window).getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parent);
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
