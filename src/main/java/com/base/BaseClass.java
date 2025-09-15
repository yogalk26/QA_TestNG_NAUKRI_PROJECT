package com.base;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public abstract class BaseClass {
	
	public static WebDriver driver;
	
	public static ExtentReports extentreports;
	
	public static File file;
	
	//browser launch
	protected static void browserLaunch(String browserName) {
		
		try {
			if(browserName.equalsIgnoreCase("chrome")){
				driver = new ChromeDriver();
			}else if(browserName.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
			}else if(browserName.equalsIgnoreCase("edge")){
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
		} catch (Exception e) {
			Assert.fail("Error occurred during browser launch");
		}
	}
	//launchurl
	protected static void launchUrl(String url) {
		
		try {
			driver.get(url);
		} catch (Exception e) {
			Assert.fail("Error occurred during url launch");
		}
	}
	//navigatemethods
	protected static void navigateMethods(String Type) {
		try {
			if(Type.equalsIgnoreCase("back")) {
				driver.navigate().back();
			}else if(Type.equalsIgnoreCase("forward")) {
				driver.navigate().forward();
			}else if(Type.equalsIgnoreCase("refresh")) {
				driver.navigate().refresh();
			}
		} catch (Exception e) {
			Assert.fail("Error occurred during navigation");
		}
	}
	//navigatetourl
	protected static void navigateToUrl(String navigateurl) {
		try {
			driver.navigate().to(navigateurl);
		} catch (Exception e) {
			Assert.fail("Error while navigating url");
		}
	}
	//send keys
	protected static void inputPassing(WebElement element, String value) {
		try {
			element.sendKeys(value);
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
	//Static wait
	protected static void staticWait(int milliseconds) throws InterruptedException {
		try {
			Thread.sleep(milliseconds);
		} catch (InterruptedException e) {
			Assert.fail("Error occurred during thread sleep");
		}
	}
	//implicit wait
	protected static void implicitlyWait(String type, int duration ) {
		try {
			if(type.equalsIgnoreCase("minutes")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(duration));
			}else if(type.equalsIgnoreCase("seconds")) {
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(duration));
			}
		} catch (Exception e) {
			Assert.fail("Error occurred during implicit wait");
		}
	}
	
	//Click
	protected static void elementClick(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			Assert.fail("Error occurred during element click");
		}
		
	}
	//Dropdown
	protected static void selectDropdown(WebElement element, String type, String value) {
		
		Select select = new Select(element);
		
		try {
			if(type.equalsIgnoreCase("index")) {
				select.selectByIndex(Integer.parseInt(value));
			}else if(type.equalsIgnoreCase("text")) {
				select.selectByVisibleText(value);
			}else if(type.equalsIgnoreCase("value")) {
				select.selectByVisibleText(value);
			}
		} catch (NumberFormatException e) {
			Assert.fail("Error in select dropdown");
		}
	}
	//is Selected
	protected static void isSelected(WebElement element) {
		try {
			boolean selected = element.isSelected();
			System.out.println("Element selected:" +selected);
		} catch (Exception e) {
			Assert.fail("Error occurred during is select");
			}
	}
	//is displayed
	protected static void isDisplayed(WebElement element) {
		try {
			boolean displayed = element.isDisplayed();
			System.out.println("Element displayed:" +displayed);
			} catch (Exception e) {
				Assert.fail("Error in element display");
			}
		}
	//is enabled
	protected static void isEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			System.out.println("Element enabled:" +enabled);
			} 
		catch (Exception e) {
			Assert.fail("Error in element enable");
			}
		}
	//get dropdown options
	protected static void getDropdownoptions(WebElement element) {
		Select select = new Select(element);
		try {
			List<WebElement> options = select.getOptions();
			System.out.println("All dropdown options");
			for(WebElement allopt : options) {
				System.out.println(allopt.getText());
			}
		} catch (Exception e) {
			Assert.fail("Error occurred while all options display");
		}
	}
	//get selected options
		protected static void getSelectedoptions(WebElement element) {
			Select select = new Select(element);
			try {
				List<WebElement> selectoptions = select.getOptions();
				System.out.println("All Selection options list");
				for(WebElement allselectopts : selectoptions) {
					System.out.println(allselectopts.getText());
				}
			} catch (Exception e) {
				Assert.fail("Error occurred while displaying all selected options");
			}
		}
		//get firstselected options
		protected static void getFirstselectedoptions(WebElement element) {
			Select select = new Select(element);
			try {
				List<WebElement> firstselectoptions = select.getOptions();
				System.out.println("All Selection options list");
				for(WebElement firstselectedoptions : firstselectoptions) {
					System.out.println(firstselectedoptions.getText());
					}
				} catch (Exception e) {
					Assert.fail("Error occurred while displaying first selected options");
					}
				}
	//Screenshot
	protected static String Takescreenshot(String location, String name, String format) throws IOException {
		String filePath = null;
		try {
			TakesScreenshot ts= (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			//File des = new File(location+"\\"+name+ "."+format);
			
			String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
			File des = new File("Screendhot\\.png" + "_" + timestamp + ".png");
			FileHandler.copy(src, des);
			filePath  = des.getAbsolutePath();
			
		} 
		catch (WebDriverException e) {
			Assert.fail("Error while capturing screenshot");
		}
		return filePath;
	}
	
	//Get CurrentUrl
	protected static void getCurrentURL(String value) {
		try {
			String currenturl = driver.getCurrentUrl();
			System.out.println("Currenturl: " +currenturl);
		} catch (Exception e) {
			Assert.fail("Error while displaying currenturl");
		}
	}
	//Get Title
	protected static void getTitle(String value) {
		try {
			String title = driver.getTitle();
			System.out.println("Title: " +title);
		} catch (Exception e) {
			Assert.fail("Error while displaying title");
		}
	}
	//Get Text
	protected static void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			Assert.fail("Error occurred while getting text");
		}
	}
	//Get Attribute
	protected static void getAttribute(WebElement element, String Attr) {
		try {
			String attribute = element.getAttribute(Attr);
			System.out.println(attribute);
		} catch (Exception e) {
			Assert.fail("Error occurred while getting attribute");
		}
	}
	//Alert
	protected static void alert(WebElement element, String Type) {
		Alert alert = driver.switchTo().alert();
		try {
			if(Type.equalsIgnoreCase("Ok")) {
				alert.accept();
			}else if(Type.equalsIgnoreCase("Cancel")) {
				alert.dismiss();
			}
		} catch (Exception e) {
			Assert.fail("Error occurred while handling alert");
		}
	}
	//Frames
	protected static void frame(WebElement element, String type,String value) {
		try {
			if(type.equalsIgnoreCase("index")) {
				driver.switchTo().frame(0);
			}
			else if(type.equalsIgnoreCase("id or name")) {
				driver.switchTo().frame(value);
			}
			else if(type.equalsIgnoreCase("webelement")) {
				driver.switchTo().frame(element);
			}
		} catch (Exception e) {
			Assert.fail("Error occurred during frame handling");
		}
	}
	//Action Methods
	protected static void Actionmethods(WebElement element, String type) {
		Actions action = new Actions(driver);
		try {
			if(type.equalsIgnoreCase("click")) {
				action.click(element).build().perform();			
			}else if(type.equalsIgnoreCase("rightclick")) {
				action.contextClick(element).build().perform();
			}else if(type.equalsIgnoreCase("doubleclick")) {
				action.doubleClick(element).build().perform();
			}else if(type.equalsIgnoreCase("hold")) {
				action.clickAndHold(element).build().perform();
			}else if(type.equalsIgnoreCase("release")) {
				action.release(element).build().perform();
			}
		} catch (Exception e) {
			Assert.fail("Error occurred in mouse actions");
		}
	}
	//Windlow Handles
	protected static void windowHandle() {
		try {
			String windowHandle = driver.getWindowHandle();
			driver.switchTo().window(windowHandle);
		} catch (Exception e) {
			Assert.fail("Error occurred during window handling");
		}
	}
	//Javascript executor
	protected static void Jsclick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].click();",element);
		} catch (Exception e) {
			Assert.fail("Error occurred during javascript click");
		}
	}
	protected static void JsScrollby(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("window.scrollBy(0,-300);");
		} catch (Exception e) {
			Assert.fail("Error occurred during javascript scroll down");
		}
	}
	protected static void JsValuepass(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		try {
			js.executeScript("arguments[0].value='9995866626';", element);
		} catch (Exception e) {
			Assert.fail("Error occurred during javascript value passing");
		}
	}
	/**public static void extentReportStart(String location) {
		try {
			extentreports = new ExtentReports();
			file = new File(location);
			ExtentSparkReporter  sparkreporter = new ExtentSparkReporter (file);
			extentreports.attachReporter(sparkreporter);
			extentreports.setSystemInfo("OS", System.getProperty("os.name"));
			extentreports.setSystemInfo("Java Version", System.getProperty("java.version"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void extentReportTearDown(String location) throws IOException {
		extentreports.flush();
		file =new File(location);
		Desktop.getDesktop().browse((file).toURI());
	} **/


	//Quit
	protected static void browserTerminate() {
		try {
			driver.quit();
		} catch (Exception e) {
			Assert.fail("Error occurred during termination");
		}
	}
	//Closeall
	protected static void browserClose() {
		try {
			driver.close();
		} catch (Exception e) {
			Assert.fail("Error occurred during closing");
		}
	}
	
	

}
