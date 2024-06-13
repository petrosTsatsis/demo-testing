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

    @FindBy(xpath = "//a[@href='/Purchases']")
    private WebElement purchases;

    public void GoToCustomers()  {

        // click the Customers field from the navigation bar
        customers.click();
        CustomersPage customersPage = new CustomersPage(driver);

        // Add a new customer
        customersPage.addNewCustomer();

    }

    public void GoToPurchases()  {

        // click the Purchases field from the navigation bar
        purchases.click();
        PurchasesPage purchasesPage = new PurchasesPage(driver);

        // Add a new purchase
        purchasesPage.addNewPurchase();

    }
}
