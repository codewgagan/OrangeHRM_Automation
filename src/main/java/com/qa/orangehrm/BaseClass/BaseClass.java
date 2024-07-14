package com.qa.orangehrm.BaseClass;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseClass {
	public static WebDriver driver;
	public static Properties props;
	
	
	public BaseClass() throws IOException {
		props = new Properties();
		try{
			FileInputStream fis = new FileInputStream("D:\\Eclipse-workspace\\OrangeHRMTest\\src\\main\\java\\com\\qa\\orangehrm\\config\\config.properties");
			props.load(fis);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void Initialization() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\gowda\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		String browserName = props.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}
	public void login(String un, String pass) {
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(un);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}

}
