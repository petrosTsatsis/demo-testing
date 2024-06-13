package org.example.demotesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/Customers']")
    private WebElement customers;

    @FindBy(xpath = "//a[@href='/Customers/add-customer']")
    private WebElement addCustomerButton;

    @FindBy(id = "fname")
    private WebElement fnameField;

    @FindBy(id = "lname")
    private WebElement lnameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "phoneNumber")
    private WebElement phoneNumberField;

    @FindBy(className = "react-datepicker__input-container")
    private WebElement datePickerField;

    @FindBy(className = "year-picker")
    private WebElement yearPickerField;

    @FindBy(className = "month-picker")
    private WebElement monthPickerField;

    @FindBy(xpath = "//a[@type='submit']")
    private WebElement submitCustomer;

    public void AddCustomer(String fname, String lname, String email, String phoneNumber,
                            String customerBirthDay, String customerBirthMonth, String customerBirthYear)  {

        // click the Customers field from the navigation bar
        customers.click();

        // click the add customer button
        addCustomerButton.click();

        // fill the fields for customer's addition
        fnameField.sendKeys(fname);
        lnameField.sendKeys(lname);
        emailField.sendKeys(email);
        phoneNumberField.sendKeys(phoneNumber);
        datePickerField.click();
        yearPickerField.click();
        yearPickerField.sendKeys(customerBirthYear);
        monthPickerField.sendKeys(customerBirthMonth);
        String dayXPath = String.format("(//*[text()='%s'])[2]", customerBirthDay);
        WebElement dayOption = driver.findElement(By.xpath(dayXPath));
        dayOption.click();

        // click the submit button
        submitCustomer.click();
    }
}
