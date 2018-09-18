package com.ap.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ap.qa.base.TestBase;

public class SignIn extends TestBase{
	@FindBy(className="header_user_info")
	WebElement Signin;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(id="passwd")
	WebElement Password;
	
	@FindBy(name="SubmitLogin")
	WebElement SigninBTn;
	
	@FindBy(name="//img[@class='logo img-responsive']")
	WebElement aplogo;
	
	public SignIn(){
		PageFactory.initElements(driver, this);
	}
	public String validateTitle(){
		return driver.getTitle();
	}
	public boolean validateLogo(){
		return aplogo.isDisplayed();
	}
	public HomePage login(String ed,String pass){
		Signin.click();
		Email.sendKeys(ed);
		Password.sendKeys(pass);
		SigninBTn.click();
		return new HomePage();
	}
}
