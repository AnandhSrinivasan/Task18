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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Step 1 and 2 Launch the browser and Navigate to Given URL
		driver = new ChromeDriver();
		driver.navigate().to("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//Step 3 and 4 Drag and Drop the Traget
		
		driver.switchTo().frame(driver.findElement(By.xpath("//title[text()='jQuery UI Droppable - Default functionality']")));
		driver.switchTo();
		
		Actions actions = new Actions(driver); 
		WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement drop = driver.findElement(By.xpath("//div[@id='droppable']"));
		actions.dragAndDrop(drag, drop);
		WebElement message =  driver.findElement(By.xpath("//*[text()='Dropped!']"));
		message.getCssValue("Color");
		String output = message.getText();
		System.out.println(output);
	}

}
