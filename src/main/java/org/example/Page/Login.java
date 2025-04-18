package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
    WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
        driver.get("https://labsqajobs.qaharbor.com/login/");
    }

    By usernameField = By.xpath("//input[@id='email']");
    By passwordField = By.xpath("//input[@id='password']");
    By loginButton = By.xpath("//button[contains(@class, 'jet-form-builder__submit')]");

    public void log(String user, String pass) {
        driver.findElement(usernameField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
}
