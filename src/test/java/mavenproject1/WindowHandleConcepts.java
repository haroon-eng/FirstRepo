package mavenproject1;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class WindowHandleConcepts {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://en-gb.facebook.com/");

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		String ParentWinHandler = driver.getWindowHandle();
		String ParentWinTitle  = driver.getTitle();
		System.out.println("ParentWinTitle : "+ParentWinTitle);
		
		driver.findElement(By.id("terms-link")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("privacy-link")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("cookie-use-link")).click();
		Thread.sleep(1000);
		

		
		Set<String> HandleColl = driver.getWindowHandles();
		Iterator<String> itobj = HandleColl.iterator();
		
		while (itobj.hasNext()){
			
			String ChildWindowHandle = itobj.next();
			if(!ParentWinHandler.equalsIgnoreCase(ChildWindowHandle)){
				Thread.sleep(3000);
				driver.switchTo().window(ChildWindowHandle);
				String CTitle = driver.getTitle();
				System.out.println("After Switching The title is : "+CTitle);
				driver.close();
			}
			
		}
 

	}

}
