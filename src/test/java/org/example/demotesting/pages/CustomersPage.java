package org.example.demotesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomersPage {

    WebDriver driver;

    public CustomersPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    String fname = "Petros";
    static String lname = "Tsatsis";
    static String email = "test@test.test";
    static String phoneNumber = "1234567888";
    static String birthDay = "30";
    static String birthMonth = "May";
    static String birthYear = "2002";

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

    @FindBy(xpath = "(//button[@class='carousel-button'])[2]")
    private WebElement carouselTableButton;

    @FindBy(xpath = "//div[@class='popover-content']//button[1]")
    private WebElement customerDetailsButton;

    public void addNewCustomer(){
        CustomerFields(fname, lname, email, phoneNumber, birthDay, birthMonth, birthYear);
    }

    public void CustomerFields(String fname, String lname, String email, String phoneNumber,
                            String customerBirthDay, String customerBirthMonth, String customerBirthYear)  {

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

        boolean isClickable = isElementClickable(carouselTableButton);
        viewNewCustomer(isClickable);

    }

    public void viewNewCustomer(boolean isClickable){

        while (isClickable){
            carouselTableButton.click();
            isClickable = isElementClickable(carouselTableButton);
        }

        // Find the checkbox of the row based on the email of the user
        String xpathExpression = String.format("//tr[td[contains(text(), '%s')]]//input[@type='checkbox']", email);
        WebElement checkbox = driver.findElement(By.xpath(xpathExpression));

        // Click the checkbox
        checkbox.click();
        customerDetailsButton.click();
    }

    public boolean isElementClickable(WebElement element) {
        // Check if the element has the 'disabled' attribute
        return element.getAttribute("disabled") == null;
    }


}
