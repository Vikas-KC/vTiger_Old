package com.vTiger.testScripts;

import java.util.Iterator;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Set;
import com.vTiger.genricLib.Base;

@Listeners(com.vTiger.genricLib.ListenersImpmt.class)
public class CreateProductsTest extends Base
{
	@Test
	public void createProductTest()
	{
		String vendorName="Vikas";
		String productName="keyboard";
		driver.findElement(By.linkText("Products")).click();
		Reporter.log("clicked on product link",true );
		driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		Reporter.log("clicked on create product",true);
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(productName);
		Reporter.log("product name entered",true);
		driver.findElement(By.xpath("//input[@name='vendor_name']/../img[@title='Select']")).click();
		Reporter.log("vendor name to be selected",true);
		
		 java.util.Set<String> setStr = driver.getWindowHandles();
		 Iterator<String> it=setStr.iterator();
		 String pid=it.next();//id of parent browser
		 String cid=it.next();//id of child browser
		 
		 driver.switchTo().window(cid);
		 Reporter.log("switched to child browser",true);
		 driver.findElement(By.linkText(vendorName)).click();
		 Reporter.log("vendor name selected",true);
		 driver.switchTo().window(pid);
		 Reporter.log("switched to parent browser",true);
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("cliked on save button",true);
		
		//verifying the created product
		String actualText=driver.findElement(By.xpath("//span[contains(.,'Product Information')]")).getText();
		Assert.assertTrue(actualText.contains(productName));
		Reporter.log("product created successully",true);
		
		driver.findElement(By.linkText("Products")).click();
		Reporter.log("clicked on product link",true);
	}
}
