package myTestcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Signup extends Parameters {
	
	
	WebDriver driver = new ChromeDriver();
	
	
	@BeforeTest
	public void mySetup () {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}
	
	
	@Test()
	public void myFirstTest ()  throws InterruptedException  {
	
	driver.get("https://magento.softwaretestingboard.com/");
	driver .findElement(By.linkText("Create an Account")).click();
	
	
	WebElement FirstName =driver.findElement(By.id("firstname"));
	WebElement LastName =driver.findElement(By.id("lastname"));
	WebElement Email =driver.findElement(By.id("email_address"));
	WebElement password =driver.findElement(By.id("password"));
	WebElement confirmPassword =driver.findElement(By.id("password-confirmation"));
	WebElement CreateAccountButtonElement =driver.findElement(By.cssSelector("button[title='Create an Account']"));
	
	
	FirstName.sendKeys(firstNames[randomIndex]);
	LastName.sendKeys(lastNames[randomIndex]);
	Email.sendKeys(emailID);
	password.sendKeys(CommonPassword);
	confirmPassword.sendKeys(CommonPassword);
	
	CreateAccountButtonElement.click();
	
	String WelcomeMsg =driver.findElement(By.className("message-success")).getText();
	assertEquals(WelcomeMsg,"Thank you for registering with Main Website Store.");
	
	
	
	}

	
	

}