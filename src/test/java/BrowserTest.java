import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class BrowserTest {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C:/Users/HP/eclipse-workspace/SeleniumFramework/Driver/geckodriver.exe");

		WebDriver driver = new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		
		String ActualLink ="https://rahulshettyacademy.com/seleniumPractise/#/";

		driver.navigate().to(ActualLink);

		driver.manage().window().maximize();
		// driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		 ((JavascriptExecutor)driver).executeScript("scroll(0,700)");
		 
		 Thread.sleep(5000);
		
		  WebElement capsicum= driver.findElement(By.xpath("//div[@class='products-wrapper'] /div/div[9]/div[3]/button\r\n"));
		  capsicum.click();
 
		  WebElement shop=driver.findElement(By.cssSelector(".cart-icon > img:nth-child(1)"));
		  shop.click(); 
		  WebElement Check= driver.findElement(By.xpath("/html/body/div/div/header/div/div[3]/div[2]/div[2]/button"));
		  Check.click();
		 WebElement order= driver.findElement(By.xpath("//button[text()='Place Order']"));
		  order.click();
	
		  Thread.sleep(2000);
		  
		  List<WebElement> e=driver.findElements(By.xpath("//button"));
		  int c=e.size();
		  System.out.println("No of buttons :" + c );
	
		 //Select(driver.findElement(By.xpath("//option[text()='Select']")); 
		 Select country=new Select(driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/select"))); //country.selectByIndex(1);
		 country.selectByValue("India");
		 
		 
		 
		 List<WebElement> countries=country.getOptions();
		// int count=countries.size();
		 
		 for(int i=0;i<countries.size();i++)
		 {
			 System.out.println(countries.get(i).getText());
		 }
		 
		  WebElement checkbox=driver.findElement(By.xpath("//input[@class='chkAgree']"));
		  checkbox.click();
		  WebElement proceed=driver.findElement(By.xpath("//button[text()='Proceed']"));
		  proceed.click();
		 
		  Thread.sleep(5000); 
		
		 Assert.assertEquals(ActualLink, "https://rahulshettyacademy.com/seleniumPractise/#/");
		 
		//  ((JavascriptExecutor)driver).executeScript("scroll(0,700)");
		 
		 WebElement search=driver.findElement(By.xpath("//input[@class='search-keyword']"));
		 search.sendKeys("Tom");
		 
		 Thread.sleep(5000); 
		 WebElement Add=driver.findElement(By.xpath("//div[@class='product-action'] /button"));
		 Add.click();
		 
		 
		
		 
	}

}
