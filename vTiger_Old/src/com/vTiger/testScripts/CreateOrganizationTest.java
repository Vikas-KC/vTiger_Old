package com.vTiger.testScripts;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.vTiger.genricLib.Base;

@Listeners(com.vTiger.genricLib.ListenersImpmt.class)
public class CreateOrganizationTest extends Base
{
	@Test
	public void createOrgTest()
	{
		String orgName="Qspider";
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("cliked on organization link",true);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Reporter.log("clicked on create organization link",true);
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		Reporter.log("organization name is entered",true);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		Reporter.log("clicked on save button",true);
		
		//verifying the organization created
		String actualOrgaName=driver.findElement(By.xpath("//span[contains(.,'Organization ')]")).getText();
		org.testng.Assert.assertTrue(actualOrgaName.contains(orgName));
		Reporter.log("organization created successfully",true);
		driver.findElement(By.linkText("Organizations")).click();
		Reporter.log("clicked on organization link link",true);
		Assert.assertTrue(false);
		Reporter.log("failed the TC manualy",true);
	}
}
