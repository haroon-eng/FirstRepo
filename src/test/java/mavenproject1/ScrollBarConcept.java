package mavenproject1;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class ScrollBarConcept {

	public static void main(String[] args) throws InterruptedException {
		
//		Scenario 1: To scroll down the web page by pixel.
//		Scenario 2: To scroll down the web page by the visibility of the element.
//		Scenario 3: To scroll down the web page at the bottom of the page.

		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.fommy.co.in/");
		driver.manage().window().maximize();
		//Thread.sleep(5000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		//js.executeScript(Script,Arguments);
		
		//Script – This is the JavaScript that needs to execute.
		//Arguments – It is the arguments to the script. It's optional.
		
		// This  will scroll down the page by  1000 pixel vertical		
        //js.executeScript("window.scrollBy(0,1000)");
        
        //This will scroll the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.linkText("Linux")));
        
        //This will scroll the web page till end.		
     //   js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
       // Thread.sleep(5000);
       js.executeScript("window.scrollBy(document.body.scrollHeight,-1000)"); // for scroll up
        
        
        
        
	}

}