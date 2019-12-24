package mavenproject1;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.testng.annotations.Test;

	
	public class DragandDrop {
		
		//https://jqueryui.com/resources/demos/droppable/default.html
		
		@Test
		public void Sign_On() {
			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://jqueryui.com/resources/demos/droppable/default.html");

			Actions actobj = new Actions(driver);
			
			WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
			WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
			actobj.dragAndDrop(drag, drop).build().perform();

		}

	}

