package org.example.demotesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class PurchasesPage {

    WebDriver driver;

    int softwareIndexToSelect = 1;

    int licenseIndexToSelect = 1;

    int customerIndexToSelect = 1;

    String purchaseDay = "10";
    String purchaseMonth = "June";
    String purchaseYear = "2024";

    @FindBy(id = "software")
    WebElement softwareSelectField;

    @FindBy(id = "licensingOption")
    WebElement licenseSelectField;

    @FindBy(id = "customers")
    WebElement customerSelectField;

    public PurchasesPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='/Purchases/add-purchase']")
    private WebElement addPurchaseButton;

    @FindBy(className = "react-datepicker__input-container")
    private WebElement datePickerField;

    @FindBy(className = "year-picker")
    private WebElement yearPickerField;

    @FindBy(className = "month-picker")
    private WebElement monthPickerField;

    @FindBy(xpath = "//a[@type='submit']")
    private WebElement submitPurchase;

    @FindBy(xpath = "(//button[@class='carousel-button'])[2]")
    private WebElement carouselTableButton;

    @FindBy(xpath = "//div[@class='popover-content']//button[1]")
    private WebElement purchaseDetailsButton;

    @FindBy(xpath = "//table/tbody/tr[last()]//input[@type='checkbox']")
    private WebElement newPurchasesCheckbox;

    public void addNewPurchase()  {

        // click the add purchase button
        addPurchaseButton.click();

        Select softwareDropdown = new Select(softwareSelectField);

        // select the software by the index
        softwareDropdown.selectByIndex(softwareIndexToSelect);

        Select licenseDropdown = new Select(licenseSelectField);

        // select the license by the index
        licenseDropdown.selectByIndex(licenseIndexToSelect);

        Select customerDropdown = new Select(customerSelectField);

        // select the customer by the index
        customerDropdown.selectByIndex(customerIndexToSelect);

        datePickerField.click();
        yearPickerField.click();
        yearPickerField.sendKeys(purchaseYear);
        monthPickerField.sendKeys(purchaseMonth);
        String dayXPath = String.format("(//*[text()='%s'])[1]", purchaseDay);
        WebElement dayOption = driver.findElement(By.xpath(dayXPath));
        dayOption.click();

        // click the submit button
        submitPurchase.click();

        viewNewPurchase(isElementClickable(carouselTableButton));

    }

    public void viewNewPurchase(boolean isClickable){

        while (isClickable){
            carouselTableButton.click();
            isClickable = isElementClickable(carouselTableButton);
        }

        // Click the checkbox
        newPurchasesCheckbox.click();
        purchaseDetailsButton.click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public boolean isElementClickable(WebElement element) {
        // Check if the element has the 'disabled' attribute
        return element.getAttribute("disabled") == null;
    }

}
