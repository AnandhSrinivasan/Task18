package org.Task18_MethodsandActions;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Facebook {
	static WebDriver driver;
	public static void main(String[] args) {
	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://www.facebook.com");
		
		driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
		
		
		String childwndw =  driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();
		for (String window : allwindow ) {
			driver.switchTo().window(window);
		}
		WebElement name =driver.findElement(By.name("firstname"));
		name.sendKeys("Test");
		WebElement last =driver.findElement(By.name("lastname"));
		last.sendKeys("User");
		WebElement email=driver.findElement(By.name("reg_email__"));
		email.sendKeys("testuser@test.com");
		WebElement pass =driver.findElement(By.name("reg_passwd__"));
		pass.sendKeys("testPassword");
		
		Select selDate = new Select(driver.findElement(By.id("day")));
		Select selMonth = new Select(driver.findElement(By.id("month")));
		Select selYear = new Select(driver.findElement(By.id("year")));
		
		selDate.selectByVisibleText("21");
		selMonth.selectByVisibleText("Jun");
		selYear.selectByVisibleText("1989");
		
		driver.findElement(By.xpath("//input[@type='radio' and @value='2']")).click();
		
		driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
	}
	

 }
/*
 * import org.openqa.selenium.By; import org.openqa.selenium.WebDriver; import
 * org.openqa.selenium.WebElement; import
 * org.openqa.selenium.chrome.ChromeDriver; import
 * org.openqa.selenium.interactions.Actions;
 * 
 * public class Facebook {
 * 
 * static WebDriver driver; public static void main(String[] args) { //Step 1 :-
 * //Initialize the chrome browser to perform the task driver = new
 * ChromeDriver();
 * 
 * //Step 2 :- //Navigate to URL
 * driver.navigate().to("https://www.facebook.com/");
 * driver.manage().window().maximize();
 * 
 * //Step 3 :- //Check the Webpage String Homepage = driver.getCurrentUrl();
 * String ExpectedURL = "https://www.facebook.com/"; if
 * (ExpectedURL.equals(Homepage)) {
 * System.out.println("The website is Redirected to the homepage"); } else {
 * System.out.println("The website is Not Redirected to the homepage"); }
 * 
 * //Step 4 :- //Click to create account driver.findElement(By.xpath(
 * "//a[@data-testid='open-registration-form-button']")).click();
 * 
 * //Step 5 :- //Enter First Name as Test public void facebookSignUp() {
 * 
 * driver.findElement(By.name("firstname")).sendKeys("Test");
 * driver.findElement(By.name("lastname")).sendKeys("User");
 * driver.findElement(By.name("reg_email__")).sendKeys("testuser@test.com");
 * driver.findElement(By.name("reg_passwd__")).sendKeys("testPassword"); } } } }
 */