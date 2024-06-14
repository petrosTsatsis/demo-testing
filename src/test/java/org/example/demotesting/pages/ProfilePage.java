package org.example.demotesting.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {

    WebDriver driver;
    String newFname = "Test";

    public ProfilePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Edit']")
    private WebElement editButton;

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    @FindBy(id = "fname")
    private WebElement fnameField;

    public void editProfile(){

        editButton.click();
        fnameField.clear();
        fnameField.sendKeys(newFname);
        saveButton.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();

    }


}
