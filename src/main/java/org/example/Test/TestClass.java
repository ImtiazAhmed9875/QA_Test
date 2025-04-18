package org.example.Test;

import org.example.Driver.DriverManager;
import org.example.Page.Registration;
import org.example.Page.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class TestClass {

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = DriverManager.getDriver();
    }

    @Test(priority = 1)
    public void registrationTest() {
        Registration regs = new Registration(driver);
        regs.reg("Imtiaz", "imtiazahmed9875@gmail.com", "12345678", "12345678");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By errorMsg = By.xpath("//*[@id=\"username__error\"]");

        String actualError = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
        Assert.assertEquals(actualError, "Please use a different username. It's not available.");
    }

    @Test(priority = 2)
    public void loginTest() {
        Login loginPage = new Login(driver);
        loginPage.log("Imtiaz", "12345678");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals(currentUrl, "", "URL should not be empty after login");
    }

    @AfterClass
    public void tearDown() {
        DriverManager.quiteDriver();
    }
}
