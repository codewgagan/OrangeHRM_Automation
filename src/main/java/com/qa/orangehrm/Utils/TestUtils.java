package com.qa.orangehrm.Utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.qa.orangehrm.BaseClass.BaseClass;

public class TestUtils extends BaseClass {

	public TestUtils() throws IOException {
		super();
		
	}
	public static void ScreenShot(int TCID) throws IOException {
		File  f= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destination = new File ("D:\\Eclipse-workspace\\OrangeHRMTest\\ScreenShot\\ss"+TCID+".png");
		FileHandler.copy(f, destination);
	}

}
