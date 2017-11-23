package pages;

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
public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public void login(String usernName, String password) throws Exception {

        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login_field']")));
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(usernName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        Thread.sleep(8000);
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
    }

    public void inValidlogin(String usernName, String password) {

        driver.findElement(By.xpath("//a[text()='Sign in']")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login_field']")));
        driver.findElement(By.xpath("//input[@id='login_field']")).sendKeys(usernName);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();

    }

    public void verifyErorMsg()
    {

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Dismiss this message']")));
        driver.findElement(By.xpath("//button[@aria-label='Dismiss this message']")).isDisplayed();

    }
    public void getSignout()

    {
        driver.findElement(By.xpath("//summary[@class='HeaderNavlink name mt-1']")).click();
        driver.findElement(By.xpath("//button[@class='dropdown-item dropdown-signout']")).click();

    }

    public int getVerifyProjects () throws Exception
    {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='mini-repo-list']")));
        int count = driver.findElements(By.xpath("//ul[@class='mini-repo-list']/li")).size();
        return count;
    }


    public String getTitile()
    {
        String title = driver.getTitle();
        System.out.println("Title is--"+ title);
        return title;
    }

}
