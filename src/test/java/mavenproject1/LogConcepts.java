package mavenproject1;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LogConcepts {

	

	public static void main(String[] args) {
		
		Logger LogGenerator =Logger.getLogger(LogConcepts.class);
		PropertyConfigurator.configure("log4j.properties");
		try{
			
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		LogGenerator.info("Firefox Launched");
		driver.manage().window().maximize();
		LogGenerator.info("Firefox Window maxmized");
		driver.get("http://www.google.com");
		LogGenerator.info("Application Launched");
		LogGenerator.info("Application Title :"+driver.getTitle());
		LogGenerator.error("Error Message");
		driver.close();
		LogGenerator.info("Application Closed");
		}catch(Exception e){
			
			LogGenerator.error("Fail to Launch :"+e);
		}

	}

}


