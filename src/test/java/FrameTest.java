import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameTest {
	
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/HP/eclipse-workspace/SeleniumFramework/Driver/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		String ActualLink ="http://demo.automationtesting.in/Frames.html";

		driver.navigate().to(ActualLink);
		
		WebElement frames=driver.findElement(By.linkText("Iframe with in an Iframe"));
		frames.click();
		
		driver.switchTo().frame(0);
		
		
		WebElement input=driver.findElement(By.xpath("//div[@class='row'] /div/input"));
		input.sendKeys("Shreya");
		
	}

}
