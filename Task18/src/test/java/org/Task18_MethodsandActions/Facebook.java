package org.Task18_MethodsandActions;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		
		
		//Step 1 Initialize the chrome browser to perform the task 
		WebDriver driver   = new ChromeDriver();
        WebDriverManager.chromedriver().setup();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		//Step 2 Navigate to URL
		driver.navigate().to("https://www.facebook.com");

		//Step 3 Check the Webpage 
		String Homepage = driver.getCurrentUrl();
		String ExpectedURL = "https://www.facebook.com/"; 
		if(ExpectedURL.equals(Homepage)) {
			System.out.println("The website is Redirected to the homepage"); 
		} else {
			System.out.println("The website is Not Redirected to the homepage"); 
		}

		//Step 4 Click create New Button
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		Thread.sleep(3000);

		
		//Step 5, 6 and 7 to Enter first name and lastname and other credentials
		WebElement name =driver.findElement(By.xpath("//input[@name='firstname']"));
		name.sendKeys("Anandh");
		WebElement last =driver.findElement(By.name("lastname"));
		last.sendKeys("Srinivasan");
		WebElement email=driver.findElement(By.name("reg_email__"));
		email.sendKeys("devanandh2902@gmail.com");
		WebElement reenteremail=driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[3]/div/div/div[1]/input"));
		reenteremail.sendKeys("devanandh2902@gmail.com");
		//WebElement reenteremail=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		//reenteremail.sendKeys("9566259258");
		WebElement pass =driver.findElement(By.name("reg_passwd__"));
		pass.sendKeys("testPassword123");
		
		//Step8 and 9 Using Select class Select Month Date and Year
		
		Select  selectDate = new Select(driver.findElement(By.xpath("//select[@id='day']")));
		selectDate .selectByValue("11");
		Select selectmonth = new Select(driver.findElement(By.xpath("//select[@id='month']")));
		selectmonth.selectByValue("5");
		Select selectyear = new Select(driver.findElement(By.xpath("//select[@id='year']")));
		selectyear.selectByValue("1985");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[text()='Male']")).click();
		
		//Step 10 Click SignUp Button
		Thread.sleep(2000);
		WebElement Signupbutton = driver.findElement(By.xpath("//div[@class='_1lch']//button[1]"));
		Signupbutton.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/button[1]")).click();
		
		WebElement accountconfirm =  driver.findElement(By.xpath("//div[text()='Account Confirmed']"));
		accountconfirm.getText();
		accountconfirm.click();
		driver.getCurrentUrl();
		driver.getPageSource();
		
	}
}
