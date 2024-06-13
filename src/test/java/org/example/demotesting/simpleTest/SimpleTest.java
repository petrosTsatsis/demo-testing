package org.example.demotesting.simpleTest;

import org.example.demotesting.pages.HomePage;
import org.example.demotesting.pages.LandingPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.time.Duration;


public class SimpleTest {

    static WebDriver driver;
    static String username = "admin";
    static String password = "12345678";


    @Test(testName = "AddCustomer")
    public void AddCustomer() {

        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();

        // land in the page and sign in
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.SignIn(username, password);

        // add a new customer
        HomePage homePage = new HomePage(driver);
        homePage.GoToCustomers();

    }

    @Test(testName = "AddPurchase")
    public void AddPurchase(){
        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();

        // land in the page and sign in
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.SignIn(username, password);

        // add a new customer
        HomePage homePage = new HomePage(driver);
        homePage.GoToPurchases();
    }

    public static WebDriver initializeDriver()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }

}
