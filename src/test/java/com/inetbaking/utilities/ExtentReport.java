package com.inetbaking.utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport extends TestListenerAdapter {
	
	ExtentReports extent;
	ExtentTest test;
	
	@Test
	public void startreport() throws Exception {
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter sparkReporterall = new ExtentSparkReporter("AllTestreport.html");
		extent.attachReporter(sparkReporterall);
		
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("User", "Giri");
		
		sparkReporterall.config().setDocumentTitle("InetBanking Test Project");
		sparkReporterall.config().setReportName("Funtional Test cases Report");
		sparkReporterall.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr) {
		extent.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		
	}
	
	public void onTestFailure(ITestResult tr) throws IOException {
		extent.createTest(tr.getName());
		test.log(Status.PASS,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		
		String screenshotPath= System.getProperty("C:\\Users\\lokes\\Desktop\\Lokesh EVNL\\Myproject\\Screenshot"+tr.getName()+".png");
		 File f = new File(screenshotPath);
	
		 if(f.exists()) {
			 try {
				 test.fail("Screenshot below:"+test.addScreenCaptureFromPath(screenshotPath));
			 }
			 catch (Exception e) {
				 
				 e.printStackTrace();
			 }
		 }
		
		
		
		
		
		
		
		extent.flush();
		Desktop.getDesktop().browse(new File("AllTestreport.html").toURI());
	}

}