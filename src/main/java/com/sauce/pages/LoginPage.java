package com.sauce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void enterUsername(String username) {
        usernameField.sendKeys(username);
        // passwordField.sendKeys(password);
        // loginButton.click();
    }

    public void enterPassword(String password) {
        // usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
                loginButton.click();

    }
}
