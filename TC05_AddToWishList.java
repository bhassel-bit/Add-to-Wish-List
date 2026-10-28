package day7;

		import java.time.Duration;

import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;

		public class TC05_AddToWishList {

			public static void main(String[] args) throws InterruptedException 
			{
				/*
				 1. Launch Browser (chrome)
				 2. Open URL https://cloudberrystore.services/
				 3. Maximize the browser window
				 4. Click the My Account icon (user icon)
				 5. Click Login
				 6. Enter E-Mail Address
				 7. Enter Password
				 8. Click the Login button
				 9. Click Laptops & Notebooks from the top menu
				 10. Click Show All Laptops & Notebooks
				 11. Scroll to the product HP LP3065 and click it
				 12. Click Add to Wish List (heart icon)
				 13. Verify a success alert message appears and contains the word “Success”
				 14. Close the browser
				 */

				// 1. Launch Browser (chrome)
				
				WebDriver driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				
				// 2. Open URL https://cloudberrystore.services/
				driver.get("https://cloudberrystore.services/");
				
				// 3. Maximize the browser window
				driver.manage().window().maximize();
				
				// 4. Click the My Account icon (user icon)
				driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
				
				//  5. Click Login
				driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
				
				// 6. & 7. Enter E-Mail Address & Password
				driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("brookhassel@gmail.com");
				
				driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("120kbeforejan");
				
				// 8. Click the Login button
				driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
				// Add a small wait
				Thread.sleep(1000);
			
				//  9. Click Laptops & Notebooks from the top menu
				driver.findElement(By.xpath("//a[normalize-space()='Laptops & Notebooks']")).click();
				
				// 10. Click Show All Laptops & Notebooks
				driver.findElement(By.xpath("//a[normalize-space()='Show All Laptops & Notebooks']")).click();
				
				//  11. Scroll to the product HP LP3065 and click it
				
				WebElement elementHp = driver.findElement(By.xpath("//a[normalize-space()='HP LP3065']"));
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("arguments[0].scrollIntoView({block: 'center'});", elementHp);
				Thread.sleep(1000);
				elementHp.click(); 
				
				// 12. Click Add to Wish List (heart icon)
				driver.findElement(By.xpath("//button[@title='Add to Wish List']")).click();
				
				// 13. Verify a success alert message appears and contains the word “Success”
				boolean alertMessage= driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).isDisplayed();
				
				if(alertMessage == true)
				{
					System.out.println("Test Passed");
				} 
				else 
				{
					System.out.println("Test Failed");
				}
				
				 // 14. Close the browser
				driver.quit();
	}

}
