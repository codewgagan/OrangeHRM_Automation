package com.qa.orangehrm.TestCases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.orangehrm.BaseClass.BaseClass;
import com.qa.orangehrm.Pages.AddEmp;
import com.qa.orangehrm.Utils.TestUtils;

public class AddEmpTestCase extends BaseClass {
int TCID;
	public AddEmpTestCase() throws IOException {
		super();
		
	}
	AddEmp emp;
	@BeforeMethod
	public void setUp() throws IOException {
		
		Initialization();
		login(props.getProperty("username"),props.getProperty("password"));
		emp = new AddEmp();
	}
	@Test(priority=1)
	public void emp_add() throws InterruptedException {
		TCID = 1;
		emp.Emp_details();
	}
	
	@Test(priority=2)
	public void verifyIn_Emp_list() throws InterruptedException {
		TCID = 2;
		emp.Emp_list();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException, InterruptedException  {
		if(result.getStatus() == ITestResult.SUCCESS) 
		{
			TestUtils.ScreenShot(TCID);
			driver.quit();
			Thread.sleep(3000);
		}
		
	}

}
