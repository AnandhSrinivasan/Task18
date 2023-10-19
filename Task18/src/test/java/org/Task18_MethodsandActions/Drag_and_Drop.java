package org.Task18_MethodsandActions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_and_Drop {

	static WebDriver driver ;
	public static void main(String[] args) throws InterruptedException {
		
		
		//Step 1 and 2 Launch the browser and Navigate to Given URL
		driver = new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Step 3 and 4 Drag and Drop the Target
		
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.switchTo();
		
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions actions = new Actions(driver); 
		actions.dragAndDrop(drag, drop).build().perform();
		
		//Step 5 Check CSS value 
		WebElement message =  driver.findElement(By.xpath("//*[text()='Dropped!']"));
		String color = message.getCssValue("color");
		System.out.println("CSS value :" + color);
		
		//Step 6 Check Dropped Successfully
		String output = drop.getText();
		System.out.println("The Present text is : " + output);
		
		if (output.equalsIgnoreCase("Dropped!")) {
			System.out.println("The element has been Dropped");
		} else {
			System.out.println("The element was Not Dropped");
		}
		
		driver.switchTo().defaultContent();
	}
}
