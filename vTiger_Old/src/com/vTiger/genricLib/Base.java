package com.vTiger.genricLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

public class Base {

	public WebDriver driver;
	public static WebDriver staticDriver;
	
	@Parameters("browser")
	@BeforeClass
	public void configBC(String browserVar)
	{
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		if(browserVar.equals("chrome"))
		{
		 driver = new ChromeDriver();
		 staticDriver=driver;
		}
		else if(browserVar.equals("Firefox"))
		{
			driver=new FirefoxDriver();
			staticDriver=driver;
		}
		 
		 driver.manage().window().maximize();
		 driver.get("http://localhost:8888/");
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@AfterClass
	public void configAC() 
	{
		driver.quit();
	}
	@BeforeMethod
	public void configBM()
	{
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager",Keys.ENTER);
	}
	@AfterMethod
	public void configAM() throws InterruptedException
	{
		WebElement el=driver.findElement(By.xpath("//img[contains(@src,'user.PNG')]"));
		Utility.moveToElement(driver, el);
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}

}
