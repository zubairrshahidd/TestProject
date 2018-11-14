package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
//	@FindBy(xpath="//*[@class='col-sm-6 margin copy']/p[4]/a")
	@FindBy(xpath="//a[contains(text(),'Forgot Password?')]")
	WebElement forgotLink;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
//		String actualTitle = driver.getTitle();
//        System.out.println("ActualTitle is******************************************" + actualTitle);
//        return actualTitle;
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
	}
	
	public boolean validateForgotPasswordLink(){
		return forgotLink.isDisplayed();
	}
	
	public HomePage login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
//		loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		        //To generate Alert window using JavascriptExecutor. Display the alert message 			
//		        js.executeScript("alert('Welcome to Guru99');");   

//		        /Fetching the Domain Name of the site. To string() change object to name.		
		        String DomainName = js.executeScript("return document.domain;").toString();			
		        System.out.println("Domain name of the site = "+ DomainName);					
		          		
		        //Fetching the URL of the site. To string() change object to name		
		        String url = js.executeScript("return document.URL;").toString();			
		        System.out.println("URL of the site = "+ url);	
		    	
		        
		      //Method document.title fetch the Title name of the site. To string() change object to name		
		        String TitleName = js.executeScript("return document.title;").toString();			
		        System.out.println("Title of the page = "+TitleName);
		        
		return new HomePage();
	}	
	
}
