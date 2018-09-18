package com.ap.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.ap.qa.util.TimeUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public TestBase(){
		//Creating a process which will allow us to read the information from config.properties file
		try {
			prop = new Properties();
			FileInputStream cp = new FileInputStream("E:\\Java_Selenium\\AutomationTest\\src\\main\\java\\com\\ap\\qa\\config\\config.properties");
			prop.load(cp);
		} catch (FileNotFoundException e ) {
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	//All Browser
	public static void initializing(){
		String BrowserName = prop.getProperty("Browser");
		if(BrowserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\All Elements\\Java Selenium\\Prosmart\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
		}
/*		else if(BrowserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "E:\\All Elements\\Java Selenium\\Prosmart\\chromedriver.exe");
			WebDriver driver = new FirefoxDriver();
		}*/
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
}
