package org.example.demotesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage  {

    WebDriver driver;

    @FindBy(xpath = "//*[text()='Get Started']")
    WebElement signInButton;

    @FindBy(id = "formUsername")
    WebElement usernameField;

    @FindBy(id = "formPassword")
    WebElement passwordField;

    @FindBy(xpath = "//*[text()='Login']")
    WebElement loginButton;

    public LandingPage( WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo(){
        driver.get("http://localhost:3000/");
    }

    public void SignIn(String username, String password){

        signInButton.click();
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();
    }
}
