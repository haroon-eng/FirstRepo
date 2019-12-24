package mavenproject1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertConcept {
	

	@Test
	public void Sign_On() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		
		driver.switchTo().frame("login_page");
		driver.findElement(By.xpath("//img[@alt='continue']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("footer");
		String txtmsg = driver.findElement(By.xpath("//p[@class='footer']")).getText();
		System.out.println(txtmsg);
		//driver.quit();
	}
	
}
