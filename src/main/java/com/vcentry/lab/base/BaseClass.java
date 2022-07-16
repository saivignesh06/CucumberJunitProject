package com.vcentry.lab.base;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vcentry.lab.pages.CartPage;
import com.vcentry.lab.pages.HomePage;
import com.vcentry.lab.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public static LoginPage login;
	public static HomePage home;
	public static CartPage cart;
	public static Logger log = LogManager.getLogger(BaseClass.class);
    public static HashMap<Long, WebDriver> currentDriver;
	public boolean openBrowser(String browser) {
		boolean flag = false;
		try {
			if(browser.equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
			}else if (browser.equals("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
			}
			currentDriver=new HashMap<Long, WebDriver>();
			currentDriver.put(Thread.currentThread().getId(),driver);
			driver.manage().window().maximize();
			flag=true;
			log.info("Browser is opened");
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to Open Browser");
			
		}

		return flag;
	}
	  
	public WebDriver getDriver(){
		return currentDriver.get(Thread.currentThread().getId());
	}
	public void initObject() {
		login =new LoginPage (getDriver());
		home =new HomePage(getDriver());
		cart =new CartPage(getDriver());
	}
	
	public boolean waitForElement (WebElement element) {
		boolean flag = false;
		try {
			@SuppressWarnings("deprecation")
			WebDriverWait wait=new WebDriverWait(getDriver(),30);
			wait.until(ExpectedConditions.visibilityOf(element));
			flag=true;
			log.info(element+"is visible");
		} catch(Exception e) {
			e.printStackTrace();
			log.error(element+"is not visible");
		}
		return flag;
	}
	
	public boolean clickElement (WebElement element) {
		boolean flag=false;
		try {
			waitForElement(element);
			element.click();
			flag=true;
			log.info(element+" is clicked");
		} catch (Exception e) {
			log.info(element+"is not clicked");
			e.printStackTrace();
			
			
		}
		return flag;
	}
	
	public boolean elementDisplayed (WebElement element) {
		boolean flag=false;
		try {
			waitForElement(element);
			element.isDisplayed();
			flag=true;
			log.info(element+" is displayed");
		} catch (Exception e) {
			log.info(element+"is not displayed");
			e.printStackTrace();
			
			
		}
		return flag;
	}
	
	public boolean enterText (WebElement element,String text) {
		boolean flag=false;
		try {
			waitForElement(element);
			element.sendKeys(text);
			flag=true;
			log.info(text+" is entered in"+element);
		} catch (Exception e) {
			log.info(text+"is not entered in"+element);
			e.printStackTrace();
			
			
		}
		return flag;
	}

}
