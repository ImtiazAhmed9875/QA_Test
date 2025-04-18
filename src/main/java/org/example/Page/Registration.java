package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;


public class Registration {
    WebDriver driver;

public Registration(WebDriver driver) {
    this.driver = driver;
    driver.get("https://labsqajobs.qaharbor.com/candidate-registration/");
}

    By Signup = By.xpath("//*[@id=\"jet-theme-core-header\"]/div/div/section[1]/div[2]/div[2]/div/div[3]/div/nav/div[2]/div/div/a/span");
    By UserName = By.xpath("//input[@name=\"username\"]");
    By Email = By.xpath("//input[@name=\"email\"]");
    By Password = By.xpath("//input[@name=\"password\"]");
    By ConPasswprd = By.xpath("//input[@name=\"conf-pass\"]");
    By Reg = By.xpath("//button[@class=\"jet-form-builder__action-button jet-form-builder__submit submit-type-reload\"]");

    public void reg(String User,String email,String pass,String cpass){
        driver.findElement(Signup).click();
        Select select = new Select(driver.findElement(Signup));
        select.selectByVisibleText("Candidate");
        driver.findElement(UserName).sendKeys(User);
        driver.findElement(Email).sendKeys(email);
        driver.findElement(Password).sendKeys(pass);
        driver.findElement(ConPasswprd).sendKeys(cpass);
        driver.findElement(Reg).click();

}

}
