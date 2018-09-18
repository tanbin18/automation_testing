package com.ap.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ap.qa.base.TestBase;
import com.ap.qa.pages.HomePage;
import com.ap.qa.pages.SignIn;



public class SignInPageTest extends TestBase{

	SignIn SignIn;
	HomePage homepage;
	
	public SignInPageTest(){
		super();
	}
	@BeforeMethod
	public void setUp(){
		initializing();
		SignIn = new SignIn();
	}
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = SignIn.validateTitle();
		Assert.assertEquals(title, "Login - My Store");
	}
	@Test(priority=2)
	public void aplogoTest(){
		boolean flag = SignIn.validateLogo();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest(){
		homepage = SignIn.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
