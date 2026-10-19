package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener{

//	public ExtentSparkReporter spark ;
	public ExtentReports report;
	public static ExtentTest test ;
	
	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		System.out.println("Reoport Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		
		// spark report config
				ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
				spark.config().setDocumentTitle("CRM Test Suite Results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);

				// add Environment information and create test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("BROWSER", "Chrome");
				report.setSystemInfo("OS", "Windows-10");
	}

	
	public void onFinish(ISuite suite) {
		System.out.println("Reoport backUp");
		report.flush();
		
	}


	public void onTestStart(ITestResult result) {
		System.out.println("========> "+result.getMethod().getMethodName()+" >=====START======");
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+"====> STARTED <====");
		
	}

	
	public void onTestSuccess(ITestResult result) {
		System.out.println("========> "+result.getMethod().getMethodName()+" >=====END======");
		test.log(Status.PASS, result.getMethod().getMethodName()+"====> COMPLETED <====");
		
	}


	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
//		File srcFile = ts.getScreenshotAs(OutputType.FILE);
		String srcFile = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
//		try {
//			FileHandler.copy(srcFile, new File("./screenshot/"+testName+  "+"+time+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		test.addScreenCaptureFromBase64String(srcFile, testName+"_"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"====> FAILED <====");
		
	}
	
}
