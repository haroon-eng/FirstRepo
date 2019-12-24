package mavenproject1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WebdriverWaitConcepts {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("file:///C:/Users/Yogesh/Desktop/waitexample.html");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
				
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();

	    //WebElement element = driver.findElement(By.xpath("//p[text()='WebDriver']"));

		WebElement element  = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		
		boolean status = element.isDisplayed();
		if(status){
			System.out.println("Element is Displayed: "+element.getText());
		}
		else{
			System.out.println("Element is not Displayed:");
		}
		
	}

}