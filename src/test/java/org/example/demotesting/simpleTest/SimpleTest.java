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
    static String fname = "Petros";
    static String lname = "Tsatsis";
    static String email = "test10@test.test";
    static String phoneNumber = "1234567886";
    static String birthDay = "30";
    static String birthMonth = "May";
    static String birthYear = "2002";


    @Test
    public void AddCustomerTest() {

        WebDriver driver = initializeDriver();
        driver.manage().window().maximize();

        // land in the page and sign in
        LandingPage landingPage = new LandingPage(driver);
        landingPage.goTo();
        landingPage.SignIn(username, password);

        // add a new customer
        HomePage homePage = new HomePage(driver);
        homePage.AddCustomer(fname, lname, email, phoneNumber, birthDay, birthMonth, birthYear);

    }

    public static WebDriver initializeDriver()
    {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }

}
