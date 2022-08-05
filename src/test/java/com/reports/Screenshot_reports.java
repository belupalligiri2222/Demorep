package com.reports;

import java.awt.Desktop;
import java.io.File;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Screenshot_reports {
	
	ExtentReports extent;
	ExtentTest test;
	
	@Test
	public void startreport() throws Exception {
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report.html");
		
		extent
		.createTest("Screenshot Test1","This is for attaching the screenshot to the test at test level")
		.info("this is a msg");
		
		extent.flush();
		Desktop.getDesktop().browse(new File("report.html").toURI());
}
}