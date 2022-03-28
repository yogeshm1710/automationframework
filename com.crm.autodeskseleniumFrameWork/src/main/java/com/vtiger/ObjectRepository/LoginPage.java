package com.vtiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//initialization of web elements
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration of web Element
	@FindBy(name="user_name")
	private WebElement userNameTextField;
	
	@FindBy(name="user_password")
	private WebElement passwordTextField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	//getters methods to use it in the test script 
	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business logic
	public void login(String username, String password)
	{
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		loginButton.click();
	}

}
