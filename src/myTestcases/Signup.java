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
	
	
	@Test(priority=1,enabled=true)
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

	@Test(priority=2,enabled=true)
	
	public void logoutProcess() throws InterruptedException {
	
	driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
	
	 assertEquals(driver.getCurrentUrl().contains("logoutSuccess"),true);
	}	
	
	
	@Test(priority=3,enabled=true)
	public void LoginProcess() throws InterruptedException {
		
	driver.findElement(By.linkText("Sign In")).click();
	driver.findElement(By.id("email")).sendKeys(emailID);
	driver.findElement(By.id("pass")).sendKeys(CommonPassword);
	driver.findElement(By.id("send2")).click();
	
	Thread.sleep(30000);
	System.out.println(driver.findElement(By.cssSelector(".greet.welcome")).getText());
	
	String WelcomeMessage =driver.findElement(By.cssSelector(".greet.welcome")).getText();
	assertEquals(WelcomeMessage.contains("Welcome"),true);
	
	}

   // @Test(priority=4,enabled=false)
   // public void addOneRandomItem1() {
   // driver.get("https://magento.softwaretestingboard.com/customer/account/logout/");
    	
   // WebElement footer =   driver.findElement(By.cssSelector(".footer.content"));
   // int theNumberOfTagA=footer.findElements(By.tagName("a")).size();
    //System.out.println(theNumberOfTagA);
    
  //  int theNumberOfH1Tag=driver.findElements(By.tagName("h1")).size()	;
    //System.out.println(theNumberOfH1Tag+"this is the total h1 tags inside the bage");
    	
    	
    //}
	
    @Test(priority=4,enabled=true)
   public void addOneRandomItem() throws InterruptedException {
   driver.get("https://magento.softwaretestingboard.com/");
    WebElement ItemsContainer =driver.findElement(By.cssSelector(".product-items.widget-product-grid"));
    int numberofitems=ItemsContainer.findElements(By.tagName("li")).size();
    System.out.println(numberofitems);
    
   int randomItemToSelect=rand.nextInt(4);
   
   ItemsContainer.findElements(By.tagName("li")).get(randomItemToSelect).click() ;
   
  
   WebElement sizesContainer=driver.findElement(By.cssSelector(".swatch-attribute.size"));
   
  int theSizes=sizesContainer.findElements(By.className("swatch-option")).size();
  sizesContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theSizes)).click();
  Thread.sleep(2000);
  
  WebElement colorsContainer=driver.findElement(By.cssSelector(".swatch-attribute.color"));
  int theColors=colorsContainer.findElements(By.className("swatch-option")).size();
  colorsContainer.findElements(By.className("swatch-option")).get(rand.nextInt(theColors)).click();
  Thread.sleep(2000);
  
  
  driver.findElement(By.id("product-addtocart-button")).click();
  Thread.sleep(2000);
  
 String ActualMsg= driver.findElement(By.cssSelector(".page.messages")).getText();
  
 assertEquals(ActualMsg.contains("You added"),true); 
    

    
    }
    
    
    
    }
    
    









	
	
	

	

}
