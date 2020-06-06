package com.vTiger.genricLib;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImpmt implements ITestListener
{

//	@Override
//	public void onTestFailure(ITestResult result)
//	{
//		TakesScreenshot ts=(TakesScreenshot)Base.staticDriver;
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		File dest=new File("./screenShot/ScreenShot1.PNG");
//		try {
//			FileUtils.copyFile(src, dest);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
	
	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		
		Date dt=new Date();
		
		String compeleteDate=dt.toString();
		String[] st=compeleteDate.split(" ");
		
		int day=dt.getDay();
		String mon=st[1];
		String year=st[5];
		String time=st[3].replace(":", "-");
		
		TakesScreenshot ts=(TakesScreenshot)Base.staticDriver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./ScreenShots/"+methodName+"-"+day+"-"+mon+"-"+year+"-"+time+".PNG");
		try 
		{
			FileUtils.copyFile(src, dest);
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
