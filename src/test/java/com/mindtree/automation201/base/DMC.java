/**
 * 
 */
package com.mindtree.automation201.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author M1044429
 *
 */
public class DMC {

	/**
	 * @param args
	 */
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
				+ "/src/test/java/com/mindtree/automation201/configs/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://lfg.seismic.com/directlogon.aspx");
		driver.findElement(By.xpath("//label[normalize-space(.)='Username']/following-sibling::input")).sendKeys("tuhin.roy@lfg.com.sandbox");
		driver.findElement(By.xpath("//label[normalize-space(.)='Password']/following-sibling::input")).sendKeys("Lfgcrm54321@#");
		driver.findElement(By.xpath("//button[normalize-space(.)='LOGIN']")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//div[@class='input-area']/input")).sendKeys("FA-MERGE-EML003 | Optical Illusions and the Market - Outlook Style - Email",Keys.RETURN);
		driver.findElement(By.xpath("//div[@class='seismic-search-result-tabs']//child::span[text()='DocCenter' and @class='seismic-search-result-tabs-tab-label']")).click();
		driver.findElement(By.xpath("//div[@class='search-info-section-title']")).click();
		driver.findElement(By.xpath("//button[@aria-label='Send By Email Blast']")).click();
		WebElement emailframe = driver.findElement(By.xpath("//iframe[@name='email-blast']"));
        driver.switchTo().frame(emailframe);
        Thread.sleep(3000);
        WebElement emailfield = driver.findElement(By.xpath("//label[contains(text(),'email')]/following::input"));
        emailfield.sendKeys("tuhin.roy@lfg.com");
        WebElement nextbutton = driver.findElement(By.xpath("//button[text()='Next']"));
        nextbutton.click();
       
        WebElement emailframe2 = driver.findElement(By.xpath("(//iframe[@class='min-h-28 block'])[2]"));
        driver.switchTo().frame(emailframe2);
        Thread.sleep(3000);
        String body="";
        body=driver.findElement(By.xpath("(//body")).getText();
        System.out.println("tuhin "+body);

	}

}
