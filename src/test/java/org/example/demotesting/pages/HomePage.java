package org.example.demotesting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    @FindBy(xpath = "//button[@aria-label='Toggle navigation']")
    private WebElement offCanvasToggler;

    @FindBy(xpath = "//a[@href='/Profile']")
    private WebElement profile;

    public void goToCustomers()  {

        // click the Customers field from the navigation bar
        customers.click();
        CustomersPage customersPage = new CustomersPage(driver);

        // Add a new customer
        customersPage.addNewCustomer();

    }

    public void goToPurchases()  {

        // click the Purchases field from the navigation bar
        purchases.click();
        PurchasesPage purchasesPage = new PurchasesPage(driver);

        // Add a new purchase
        purchasesPage.addNewPurchase();

    }

    public void goToProfile(){

        offCanvasToggler.click();

        // Create an explicit wait to wait for the profile to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(profile));

        profile.click();

        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.editProfile();
    }
}
