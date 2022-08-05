package com.reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class reports {
	static WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	@BeforeTest
	public void setup() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\lokes\\Desktop\\Lokesh EVNL\\Myproject\\drivers\\chromedriver.exe");
		driver  = new ChromeDriver();
		Capabilities	capabilities = 	 ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());
		
	}
	@Test
	public void startreport() throws Exception {
		
		System.getProperties().list(System.out);
		
		System.out.println("os"+System.getProperty("os.name"));
		System.out.println("java"+System.getProperty("java.version"));

		Capabilities	capabilities = 	 ((RemoteWebDriver) driver).getCapabilities();
		System.out.println(capabilities.getBrowserName());
		System.out.println(capabilities.getBrowserVersion());
		
		driver.get("https://www.google.co.in/");
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter sparkReporterall = new ExtentSparkReporter("AllTestreport.html");
		ExtentSparkReporter sparkReporterfaield = new ExtentSparkReporter("FailedTests.html");
		sparkReporterfaield.filter().statusFilter().as(new Status[] {Status.FAIL}).apply();
		ExtentSparkReporter sparkReporterskied = new ExtentSparkReporter("Skiped.html");
		sparkReporterskied.filter().statusFilter().as(new Status[] {Status.SKIP}).apply();
		extent.attachReporter(sparkReporterall,sparkReporterfaield,sparkReporterskied);
		
		extent
		.createTest("text based Test")
		.log(Status.PASS, "Pass")
		
		.log(Status.FAIL, "<b><i>Info</i></b>")
		.log(Status.WARNING, "<b>WARNING</b>")
		.log(Status.SKIP, "<i>SKIP</i>");
		
		String XMLDATA = "<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		
		String jsondata = "{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		extent
		.createTest("XML based Test")
		.info(MarkupHelper.createCodeBlock(XMLDATA, CodeLanguage.XML));
		extent
		.createTest("XML jsondata Test")
		.info(MarkupHelper.createCodeBlock(jsondata, CodeLanguage.JSON));
	     List<String> list = new ArrayList<String>();
	     list.add("Giri");
	     list.add("Lokesh");
	     Map<Integer,String> mapdata = new HashMap<>();
	     mapdata.put(1, "raja");
	     mapdata.put(2, "ramu");
	     Set<Integer> set = mapdata.keySet();
	     
	     extent
			.createTest("List based Test")
			.info(MarkupHelper.createOrderedList(list))
	         .info(MarkupHelper.createUnorderedList(list));
	     
	     extent
			.createTest("set based Test")
			.info(MarkupHelper.createOrderedList(set));
	     
	     extent
			.createTest("set based Test")
			.info(MarkupHelper.createOrderedList(mapdata));
	     
	     extent
			.createTest("Highlist log Test")
			.info("this is not message Highlist log Test")
			.info(MarkupHelper.createLabel("this message Highlist log Test", ExtentColor.RED));
	     
	     extent.setSystemInfo("os", System.getProperty("os.name"));
	     extent.setSystemInfo("Java version", System.getProperty("java.version"));
	     extent.setSystemInfo("brower name & version", capabilities.getBrowserName() +capabilities.getBrowserVersion());
	     extent.setSystemInfo("user", System.getProperty("user.home"));
	     extent.setSystemInfo("country", System.getProperty("user.country"));

	     
	     try {
	    	 int i=5/0;
	     }catch(Exception e) {
	    	 extent
				.createTest("Exception log Test")
				.info(e);
	    	 
	     }
		Throwable t = new RuntimeException("This is a custom exception");
		
		extent
		.createTest("Exception log Test2")
		.info(t);
		String base64code = captureScreenshot();
		 String   path =   captureScreenshot("Google.jpg");
		extent
		.createTest("Screenshot Test1","This is for attaching the screenshot to the test at test level")
		.info("this is a msg")
		.addScreenCaptureFromBase64String(base64code);
		
		extent
		.createTest("Screenshot Test2","This is for attaching the screenshot to the test at test level")
		.info("this is a msg")
		.addScreenCaptureFromBase64String(base64code,"Google home page");
		
		extent
		.createTest("Screenshot Test3","This is for attaching the screenshot to the test at test level")
		.info("this is a msg")
		.addScreenCaptureFromPath(path);
		
		extent
		.createTest("Screenshot Test4","This is for attaching the screenshot to the test at test level")
		.info("this is a msg")
		.addScreenCaptureFromPath(path,"Google home page");
		extent
		.createTest("Screenshot Test5","This is for attaching the screenshot to the test at log level")
		.fail(MediaEntityBuilder.createScreenCaptureFromBase64String(base64code).build())
		.fail(MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		
		extent
		.createTest("Test 10","Test Decs")
		.assignAuthor("Giri")
		.assignCategory("smoke")
		.assignDevice("Chrome 99 version")
		.pass("Test case passed");
		
		extent
		.createTest("Test 11","Test Decs")
		.assignAuthor("johns")
		.assignCategory("sanity")
		.assignDevice("edge 99 version")
		.pass("Test case passed");
		
		extent
		.createTest("Test 12","Test Decs")
		.assignDevice("firefox 99 version")
		.assignAuthor("ramu")
		.assignAuthor("giri")
		.assignCategory("unit test")
		.assignCategory("integration test")
		.fail("failed");
		
		
		
		extent.flush();
		driver.close();
		Desktop.getDesktop().browse(new File("AllTestreport.html").toURI());
		Desktop.getDesktop().browse(new File("FailedTests.html").toURI());
		Desktop.getDesktop().browse(new File("Skiped.html").toURI());
	}
	public static String captureScreenshot () {
		TakesScreenshot tc = (TakesScreenshot) driver;
		     String Base64 =     tc.getScreenshotAs(OutputType.BASE64);
		     System.out.println("Screenshot saven successfully");
		     return Base64;
		          
	}
	
	public static String captureScreenshot (String filename) {
		TakesScreenshot tc = (TakesScreenshot) driver;
		     File source =     tc.getScreenshotAs(OutputType.FILE);
		          File destFile = new File("./Screenshot/"+filename);
		          try {
		        	  FileUtils.copyFile(source, destFile);
		          }catch(IOException e) {
		        	  e.printStackTrace();
		          }
		          System.out.println("Screenshot saven successfully");
		          return destFile.getAbsolutePath();
	
	}
	
	
	

}
