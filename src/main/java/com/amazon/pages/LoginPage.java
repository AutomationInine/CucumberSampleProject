package com.amazon.pages;

import com.accelerators.ActionEngine;
import com.accelerators.TestEngineWeb;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Satish on 10/25/2016.
 */
public class LoginPage extends ActionEngine{


    public static By signInLink = By.xpath("//span[contains(text(),'Hello. Sign in')]");
    public static By userId=By.xpath("//input[@id='ap_email']");
    public static By continueBtn =By.xpath("//input[@id='continue']");
    public static By passwordField =By.xpath("//input[@id='ap_password']");
    public static By signInBtn =By.xpath("//input[@id='signInSubmit']");






    public void login(String usernName, String password) throws Throwable {
        waitForElementPresent(signInLink, "SignInLink",60);
        click(signInLink, "SignInLink");
        type(userId,usernName,"UserNameField");
        click(continueBtn, "ContinueBtn");
        type(passwordField,password,"PasswordField");
        click(signInBtn, "SignInBtn");

    }

    public void inValidlogin(String usernName, String password)throws Throwable  {

        waitForElementPresent(signInLink, "SignInLink",60);
        click(signInLink, "SignInLink");
        type(userId,usernName,"UserNameField");
        click(continueBtn, "ContinueBtn");
        type(passwordField,password,"PasswordField");
        click(signInBtn, "SignInBtn");

    }



}
